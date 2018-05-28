package findMaxProfitOnCapital;
/**
 * 题目：k：为可投资项目个数
 * 		W：为初始资金
 * 		Profits[]：为各个项目的收益
 * 		Capital[]：为各个项目的成本
 * 要求：有一定的时间限制；数组长度不超过50000
 * 思路：1、算法核心：在Captical成本小于已有资金W的基础上，选择项目收益Profits最大的项目，之后更新已有资金：W=W+Profits[i]
 * 		2、运算时间限制：当k的值很大时，若单纯的每次遍历比较，则循环次数巨大，需要事先对两个数组进行排序处理，之后在取得适合的最大值时跳出循环
 * @author yifei
 *
 */
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {	
   	 int arrlen = Profits.length;
        if (arrlen<=0||arrlen>50000) {
			return W;
		 }
        sortArray(Profits,Capital);
        boolean [] selectedflag = new boolean[arrlen];
        for (int i = 0; i < k; i++) {
        	int maxprofit = -1;
        	int maxprofitindex = -1;
			for (int j = arrlen-1; j >= 0; j--) {
				if (Capital[j] <=W && selectedflag[j] == false) {
					if (maxprofit < Profits[j]) {
						maxprofit = Profits[j];
						maxprofitindex = j;
						break;
					}
				}
			}
            if (maxprofitindex == -1) {
				return W;
			}
			selectedflag[maxprofitindex] = true;
			W = W + maxprofit;
		 }
        return W;
   }
   //直接插入排序
   public void sortArray(int[] arr1,int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			int temp1 = arr1[i];
			int temp2 = arr2[i];
			int j =i;
			while (j>0&&temp1<arr1[j-1]) {
				arr1[j] = arr1[j-1];
				arr2[j] = arr2[j-1];
				j--;
			}
			arr1[j] = temp1;
			arr2[j] = temp2;
		}
	}
	public static void main(String[] args) {
		int k = 3;
		int w = 0;
		int profit[] = {1,2,3};
		int captical[] = {0,1,2};
		System.out.println(new Solution().findMaximizedCapital(k, w, profit, captical));
	}
}
