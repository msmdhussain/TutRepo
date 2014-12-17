package mutithreading.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorUsage {
	private static ExecutorService executorService = null;
	private static volatile Future taskOneResult = null;
	private static volatile Future taskTwoResult = null;

	public static void main(String[] args) {

		executorService = Executors.newFixedThreadPool(2);

		while (true) {
			try {
				checkTasks();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	private static void checkTasks() throws Exception {
		if (taskOneResult == null || taskOneResult.isDone()
				|| taskOneResult.isCancelled()) {
			taskOneResult = executorService.submit(new TestOne());
		}

		if (taskTwoResult == null || taskTwoResult.isDone()
				|| taskTwoResult.isCancelled()) {
			taskTwoResult = executorService.submit(new TestTwo());
		}

	}

}

class TestOne implements Runnable {
	public void run() {

		while (true) {
			System.out.println("Executing task one");
			try {

				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class TestTwo implements Runnable {
	public void run() {

		while (true) {
			System.out.println("Executing task two");
			try {

				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
