package utils;

public class ResponseTime {
	private long milliStart;
	
	public void start() {
		milliStart = System.currentTimeMillis();
	}
	
	public void stop() {
		long milliEnd = System.currentTimeMillis();
		long milliTime = milliEnd - milliStart;
		System.out.println("Milliseconds: " + milliTime);
	}

}
