package euro.genomics.generics;

public class WaitForMoment {

	public static void wait(int t)
	{
		try {
			Thread.sleep(t*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
