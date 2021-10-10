public class Demo02Lambda{

	public static void main(String[] args){
		new Thread(()->System.out.println("lambda run thread")).start();
	}
}