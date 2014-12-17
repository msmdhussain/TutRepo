package mutithreading.executorframework;

public class TaskTwo implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing Task Three");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}