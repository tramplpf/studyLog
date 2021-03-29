
public class MaxAreaTest {
	
	/**
	 *
	 * @author lpf
	 * @date 2021年3月29日21:29:11
	 */
	@Test 
	public void test1(){
		SolutionOne demo = new SolutionOne();
		int[] height = new int[]{1,8,6,2,5,4,8,3,7};
		int result = demo.maxArea(height);
		Assert.assertEquals(49,result);
		
		int[] height2 = new int[]{1,1};
		result = demo.maxArea(height2);
		Assert.assertEquals(1,result);

		int[] height3 = new int[]{4,3,2,1,4};
		result = demo.maxArea(height3);
		Assert.assertEquals(result,16);
	}
	
	/**
	 * 
	 * @author lpf
	 * @date 2021年3月29日21:29:11
	 */
	@Test
	public void test1(){
		SolutionTwo demo = new SolutionTwo();
		int[] height = new int[]{1,8,6,2,5,4,8,3,7};
		int result = demo.maxArea(height);
		Assert.assertEquals(49,result);
		
		int[] height2 = new int[]{1,1};
		result = demo.maxArea(height2);
		Assert.assertEquals(1,result);

		int[] height3 = new int[]{4,3,2,1,4};
		result = demo.maxArea(height3);
		Assert.assertEquals(result,16);
	}
}



















