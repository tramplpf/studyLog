public class Demo01Runnable{

	public static void main(String[] args){
		Runnable task = new Runnable(){
			@Override
			public void run(){
				System.out.println("thread run");
			}
		};
		new Thread(task).start();
	}
}