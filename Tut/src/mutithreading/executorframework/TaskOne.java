package mutithreading.executorframework;

public class TaskOne implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing Task One");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}







