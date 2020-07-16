package thread.creation.example;

public class ThreadExceptionHandling {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				throw new RuntimeException("Intentional");
			}
		});

		thread.setName("Misbehaving Thread");
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println(
						"A critical error happened in thread " + t.getName() + ". The error is " + e.getMessage());
			}
		});
		
		thread.start();
	}
}
