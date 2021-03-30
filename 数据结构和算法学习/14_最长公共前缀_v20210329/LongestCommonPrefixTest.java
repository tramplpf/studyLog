/**
 * 最长公共前缀的测试类
 *  
 * @author lpf 
 * @date 2021年3月29日23:33:25
 **/
public class LongestCommonPrefixTest {
	
	/**
	 * 测试类
	 *
	 * @author lpf 
	 * @date 2021年3月29日23:33:25
	 **/
	@Test
	public void test1(){
		Solution demo =  new Solution();
		String[] strs = new String[]{"flower","flow","flight"};
		String result = demo.longestCommonPrefix(strs);
		Assert.assertEquals("fl",result);
		
		String[] strs1 = new String[]{"dog","racecar","car"};
		String result1 = demo.longestCommonPrefix(strs1);
		Assert.assertEquals("",result1);
	}
	
}