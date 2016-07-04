/*
 * http://blog.csdn.net/u014201191/article/details/50603337
 * nio socket
 */
package com.gj.nio;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;


public class Server implements Runnable{
	private Integer port1=8099;
	private Integer port2=9099;
	private ServerSocketChannel serversocket1;
	private ServerSocketChannel serversocket2;
	private SocketChannel clientchannel1;
	private SocketChannel clientchannel2; 
	//选择器 注册中心
	private Selector selector;
	//缓冲区
	private ByteBuffer buf=ByteBuffer.allocate(512);
	public Server() {
		init();
	}

	public void init() {
		try {
			this.selector=SelectorProvider.provider().openSelector();		
			this.serversocket1=ServerSocketChannel.open();
			this.serversocket1.configureBlocking(false);
			this.serversocket1.socket().bind(new InetSocketAddress("localhost", this.port1));
			this.serversocket1.register(this.selector, SelectionKey.OP_ACCEPT);
			
			this.serversocket2=ServerSocketChannel.open();
			this.serversocket2.configureBlocking(false);
			this.serversocket2.socket().bind(new InetSocketAddress("localhost", this.port2));
			this.serversocket2.register(this.selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void accept(SelectionKey key) throws IOException {
		ServerSocketChannel server=(ServerSocketChannel) key.channel();
		if(server.equals(serversocket1)) {
			clientchannel1=server.accept();
			clientchannel1.configureBlocking(false);
			clientchannel1.register(this.selector, SelectionKey.OP_READ);
		} else {
			clientchannel2=server.accept();
			clientchannel2.configureBlocking(false);
			clientchannel2.register(this.selector, SelectionKey.OP_READ);
		}
	}
	public void read(SelectionKey key) throws IOException {
		this.buf.clear();
		SocketChannel channel=(SocketChannel)key.channel();
		int count=channel.read(this.buf);
		if(count==-1){
			key.channel().close();
			key.cancel();
			return;
		}
		String input=new String(this.buf.array()).trim();
		System.out.println(input);
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				this.selector.select();
				Iterator selectorKeys=this.selector.selectedKeys().iterator();
				while(selectorKeys.hasNext()) {
					SelectionKey key=(SelectionKey) selectorKeys.next();
					selectorKeys.remove();
					if(!key.isValid())
						continue;
					if(key.isAcceptable())
						this.accept(key);
					else if(key.isReadable())
						this.read(key);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		Server server=new Server();
		Thread thread=new Thread(server);
		thread.start();
	}

}
