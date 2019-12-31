public class Demo03UseLambda{
	public static void main(String[] args){
		test(()->{System.out.println("使用lambda完成单接口的实现");});
	}

	private static void test(Cook cook){
		cook.makeFood();
	}
}