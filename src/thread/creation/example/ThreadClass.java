package thread.creation.example;

public class ThreadClass {

	public static void main(String[] args) {
		Thread thread = new NewThread();
		
		thread.start();
	}
	
	
	
	private static class NewThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Hello from " + Thread.currentThread().getName());
			System.out.println("Hello from " + this.getName());
		}
		
	}
}
