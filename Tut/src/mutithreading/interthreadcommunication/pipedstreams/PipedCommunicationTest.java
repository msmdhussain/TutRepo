package mutithreading.interthreadcommunication.pipedstreams;

import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedCommunicationTest {

	public static void main(String[] args) {

		try {

			// Create writer and reader instatnces
			PipedReader pr = new PipedReader();
			PipedWriter pw = new PipedWriter();
			// Connect the writer with reader
			pw.connect(pr);
			// Create one writer therad and one reader thread

			Thread thread1 = new Thread(new PipedReaderThread("ReaderThread",
					pr));

			Thread thread2 = new Thread(new PipedWriterThread("WriterThread",
					pw));

			// start both threads
			thread1.start();
			thread2.start();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class PipedReaderThread implements Runnable {

	PipedReader pr;
	String name = null;

	public PipedReaderThread(String name, PipedReader pr) {
		this.name = name;
		this.pr = pr;
	}

	@Override
	public void run() {
		try {
			// continuously read data from stream and print it in console

			while (true) {
				char c = (char) pr.read(); // read a char
				if (c != -1) {
					// check for -1 indicating end of file
					System.out.println(c);
				}
			}

		} catch (Exception e) {
			System.out.println("PipeThread Exeception : " + e);
		}

	}

}

class PipedWriterThread implements Runnable {

	PipedWriter pw;
	String name = null;

	public PipedWriterThread(String name, PipedWriter pw) {
		this.name = name;
		this.pw = pw;

	}

	@Override
	public void run() {
      try {
		while(true){
			pw.write("Testing data written...n");
			pw.flush();
			Thread.sleep(2000);
		}
    	  
	} catch (Exception e) {
		System.out.println("PipeThread Exception: "+e);
	}
		
	}

}
