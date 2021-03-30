/** 
 * 双指针法
 * 		两个指针开始的时候，分别指向数组的开头和结尾，然后为了保证可能获取得到更多的面积，
 *     应该移动较小高度的指针。 这样才有可能获取得到更大的面积。 
 * @author lpf
 * @date 2021年3月29日21:56:17
 *
 **/
public class SolutionTwo {

	/**
     * 双指针法求解
     *
     * @author lpf
     * @date 2021年3月29日22:01:39
     */
    public int maxArea(int[] height) {
        //return method01(height);
        return method02(height);
    }
	
	
	/**
	 * 官方给出的资料
	 *
	 * 执行结果：通过
	 * 显示详情
	 * 执行用时：5 ms, 在所有 Java 提交中击败了40.07%的用户
	 * 内存消耗：51.9 MB, 在所有 Java 提交中击败了18.17%的用户
	 * 
	 * @author lpf
	 * @date 2021年3月29日23:09:05 
	 */
	private int method02(int[] height){
		int maxarea = 0, l = 0, r = height.length - 1;
		while(l < r){
			maxarea = Math.max(maxarea, Math.min(height[l],height[r]) * (r-l));
			if(height[l] < height[r]){
				l++;
			}else{
				r--;
			}
		}
		return maxarea;
	}
	

    /**
     * 执行结果： 通过
     * 显示详情
     * 执行用时：20 ms, 在所有 Java 提交中击败了17.42%的用户
     * 内存消耗：51.5 MB, 在所有 Java 提交中击败了30.87%的用户
     * @param height
     * @return
     */
    private int method01(int[] height) {
        int len = height.length;
        int startIndex = 0;
        int endIndex = len - 1;

        int startResult = startIndex;
        int endResult = endIndex;
        // 开始的时候，直接用数组长度 * 最小的高度， 没有意识到，数组的长度并不等于数据首尾两个取值之间的间隔
        int maxAreas = (endIndex - startIndex) * Math.min(height[0], height[len - 1]);
        while(startIndex < endIndex){
            if(height[startIndex] > height[endIndex]){
                endIndex = endIndex - 1;
            }else{
                startIndex = startIndex + 1;
            }
            int tempMaxArea =  (endIndex - startIndex) * Math.min(height[startIndex] , height[endIndex]);
            if (maxAreas < tempMaxArea) {
                maxAreas = tempMaxArea;
                startResult = startIndex;
                endResult = endIndex;
            }
        }
        System.out.println("最大面积是：" + maxAreas +",其中startResult = " + startResult + ",取值是" + height[startResult]
                + ", endResult = " + endResult + ", 取值是:" + height[endResult]);
        return maxAreas;
    }
}