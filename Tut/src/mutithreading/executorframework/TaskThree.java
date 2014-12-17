package mutithreading.executorframework;

public class TaskThree implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing Task Two");
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
