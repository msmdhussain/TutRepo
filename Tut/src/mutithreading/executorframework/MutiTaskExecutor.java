package mutithreading.executorframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MutiTaskExecutor {

	public static void main(String[] args) {

		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(
				10);

		RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
		int corePoolSize = 3, maximumPoolSize = 3, keepAliveTime = 10;
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
				maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
				blockingQueue, rejectedExecutionHandler);

		executor.prestartAllCoreThreads();

		List<Runnable> taskGroup = new ArrayList<Runnable>();

		taskGroup.add(new TaskOne());
		taskGroup.add(new TaskTwo());
		taskGroup.add(new TaskThree());

		blockingQueue.add(new MultiRunnable(taskGroup));

	}
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString() + " : I've been rejected ! ");
	}
}
