package com.gj.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class Client {
	private ByteBuffer buffer=ByteBuffer.allocate(512);
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public void query(String host,int port){
		InetSocketAddress address=new InetSocketAddress(host, port);
		SocketChannel socket=null;
		byte[] bytes=new byte[512];
		while(true) {
			try{
			System.in.read(bytes);
			socket=SocketChannel.open();
			socket.connect(address);
			buffer.clear();
			buffer.put(bytes);
			buffer.flip();
			socket.write(buffer);
			buffer.clear();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
				if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Client().query("localhost", 8099);  
		
	}

}
