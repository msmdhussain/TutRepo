package mutithreading.blockingqueueandthreadpoolexe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoExecutor {

	public static void main(String[] args) {

		Integer threadCounter = 0;

		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(
				50);

		int corePoolSize = 10, maximumPoolSize = 20, keepAliveTime = 5000;

		TimeUnit unit = TimeUnit.MILLISECONDS;

		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(
				corePoolSize, maximumPoolSize, keepAliveTime, unit,
				blockingQueue);

		
		RejectedExecutionHandler handler = new RejectedExecutionHandler() {

			@Override
			public void rejectedExecution(Runnable r,
					ThreadPoolExecutor executor) {

				System.out.println("DemoTask Rejected : "
						+ ((DemoThread) r).getName());

				System.out.println("Waiting for a second !!");

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();

				}

				System.out.println("Lets add another time in Queue : "
						+ ((DemoThread) r).getName());

				executor.execute(r);
			}
		};

		executor.setRejectedExecutionHandler(handler);
		
		// Let start all core theads initiallsy
		executor.prestartAllCoreThreads();
		
		while(true){
			threadCounter++;
			// Adding threads one by one
			System.out.println("Adding DemoTask : "+threadCounter);
			executor.execute(new DemoThread(threadCounter.toString()));
			
			if(threadCounter==100)
				break;
		}
		
		

	}

}
