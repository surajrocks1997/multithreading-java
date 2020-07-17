package thread.interrupt;

public class Main1 {

	public static void main(String[] args) {
		Thread thread = new Thread(new BlockingTask());
		thread.start();
		thread.interrupt();
		
	}
	
	private static class BlockingTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(50000000);
			} catch (InterruptedException e) {
				System.out.println("Exiting blocking thread.");
			}
		}
	}
}
