//http://ifeve.com/lock-objects/
package com.gj.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safelock {
	static class Friend {
		private final String name;
		private final Lock lock=new ReentrantLock();
		
		public Friend(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}
		public boolean impendingRow(Friend  bower) {
			Boolean myLock=false;
			Boolean yourLock=false;
			try{
				myLock=lock.tryLock();
				yourLock=bower.lock.tryLock();
			}finally{
				if(!(myLock && yourLock)) {
					if(myLock) {
						lock.unlock();
					}
					if(yourLock) {
						bower.lock.unlock();
					}
				}
			}
			return myLock && yourLock;
		}
		public void bow(Friend bower) {
			if(impendingRow(bower)) {
				try {
					//bower.b
				} finally {
					lock.unlock();
					bower.lock.unlock();
				}
			}
		}
	}

}
