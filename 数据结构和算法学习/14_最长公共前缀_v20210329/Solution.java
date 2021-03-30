/** 
 * 
 *
 *
 */
public class SolutionOne{

	/**
	 *
	 * @author lpf
	 * @date 2021年3月29日23:28:19
	 *
	 **/
	public String longestCommonPrefix(String[] strs) {
		return this.method01(strs);
    }
	
	/**
     * 自己的答案
     * 思路：
     * 		依次遍历数组中的每一个取值的相同索引位置的字符，知道出现不一样的字符
     *
     * @author lpf
     * @date 2021年3月29日23:29:19
     */
    private String method01(String[] strs){
        int len = strs.length;
        boolean status = true;
        int index = 0;
        //StringJoiner joiner = new StringJoiner("");
        StringBuffer sb = new StringBuffer();
        while(status && index < len){
            if(strs[0] == null || strs[0] == ""){
                break;
            }
            Character startChar = strs[0].charAt(index);
            for (int i = 0; i < len - 1; i++) {
                status = startChar == strs[i+1].charAt(index);
                if(!status){
                    break;
                }
            }
            if(status){
                sb.append(strs[0].charAt(index) +"");
                //joiner.add(strs[0].charAt(index) +"");
                index++;
            }/*else{
                break;
            }*/
        }
        //return joiner.toString();
        return  sb.toString();
    }
}

























