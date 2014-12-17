package mutithreading.deadlock.sample1;

public class ResolveDeadLockTest {

	public static void main(String[] args) {
		ResolveDeadLockTest test = new ResolveDeadLockTest();

		
		final A a = test.new A();
		final B b = test.new B();
		
		
		//Thread-1
		Runnable block1 = new Runnable() {
			
			@Override
			public void run() {
				synchronized (b) {
					// Adding delay so that both thgreads can start trying to lock resources
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					//Thread-1 have A but need B also
					synchronized (a) {
						System.out.println("In block 1");
					}
				}
				
				
			}
		};
		
		//Thread-2
		Runnable block2 =  new Runnable() {
			
			@Override
			public void run() {
				synchronized (b) {
					// Thread-2 have B but need A also
					synchronized (a) {
						System.out.println("In bolck 2");
					}
					
				}
				
			}
		};
		
		
		new Thread(block1).start();
		System.out.println("Thread 1 started");
		new Thread(block2).start();
		System.out.println("Thread 2 started");
		
	}

// Resource A
	private class A {
		private int i = 10;

		public int getI() {
			return i;
		}
		
		public void setI(int i){
			this.i=i;
		}

	}
	
	
	// Resource B
	private class B {
		private int i = 20;

		public int getI() {
			return i;
		}
		
		public void setI(int i){
			this.i=i;
		}

	}
	

}
