package mutithreading.blockingqueueandthreadpoolexe;

public class DemoThread implements Runnable {

	private String name = null;

	public DemoThread(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(500);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Executing : " + name);

	}

}
