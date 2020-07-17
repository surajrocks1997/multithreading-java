package thread.interrupt;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
//		Thread thread = new Thread(new BlockingTask());
//		thread.start();
//		thread.interrupt();
		
		Thread thread = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("1000000")));
		
		thread.start();
		thread.interrupt();
		
	}
	
	private static class LongComputationTask implements Runnable{
		private BigInteger base;
		private BigInteger power;
		
		public LongComputationTask(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			System.out.println(base + "^" + power + " = " + pow(base, power));
		}
		
		private BigInteger pow(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;
			
			for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Prematurely interrupted computation");
					return BigInteger.ZERO;
				}
				result = result.multiply(base);
			}
			
			return result;
		}
	}
	
//	private static class BlockingTask implements Runnable{
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			try {
//				Thread.sleep(50000000);
//			} catch (InterruptedException e) {
//				System.out.println("Exiting blocking thread.");
//			}
//		}
//	}
}
