
public class Demo01UseImpl{
	public static void main(String[] args){
		// method01
		//Cook cook = new CookImpl();
		//test(cook);

		//方法二： 通过匿名内部类实现接口
		test(new Cook(){
			@Override
			public void makeFood(){
				System.out.println("inner class");
			}
		});
	}
	public static void test(Cook cook){
		cook.makeFood();
	}
}