/**
 * 盛最多水的容器
 * 
 * 暴力破解法 
 */
public class SolutionOne {
	
	/**
	 * 
	 * 学到的：数组有一个属性length。 可以直接得到长度值。 而不是通过length() 方法来获得。 
	 * 
	 * @author lpf
	 * @date 2021年3月29日21:26:49
	 */
	public int maxArea(int[] height){
		int len = height.length;
		int maxAreas = 0;
		int currentArea = 0;
		// 最大值时，数组的下标 
		int maxI = 0;
		int maxJ = 0;
		for(int i = 0; i < len; i++){
		    for (int j = i + 1; j < len; j ++) {
				currentArea = Math.min(height[j],height[i]) * (j - i);
				if (maxAreas < currentArea) {
					maxAreas = currentArea;
				}
			}
		}
        System.out.println("索引值i = " + maxI +",取值是" + height[maxI]+" , j = " + maxJ + ",取值是:"+ height[maxJ] + ",最大值是:" + maxAreas);
		return maxAreas;
	}
}

