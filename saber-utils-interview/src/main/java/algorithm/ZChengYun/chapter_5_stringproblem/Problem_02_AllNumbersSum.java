package algorithm.ZChengYun.chapter_5_stringproblem;

/**
 * https://www.cnblogs.com/zhaoqi3215/p/5303925.html
 */
public class Problem_02_AllNumbersSum {

	public static int numSum(String str) {
		if (str == null) {
			return 0;
		}
		char[] charArr = str.toCharArray();
		int res = 0;
		int num = 0;
		boolean posi = true;
		int cur = 0;
		for (int i = 0; i < charArr.length; i++) {
			cur = charArr[i] - '0';
			if (cur < 0 || cur > 9) {
				// 之所以把num放到非num的判断里面是因为
				// ，到此为止这个num的统计已经技术，例如123A-> num= (((1)*10)+2)*10 +3 = 123
				// ，当计算到A的时候num正好统计出来...故可以计算res+=num...
				res += num;
				num = 0;
				if (charArr[i] == '-') {
					//当出现'-' 的时候就需要去判断这个'-' 到底是第一个'-' 还是第二个
					//原则是第一次出现'-' 就令posi为false...出现两次就设为true...
					if (i - 1 > -1 && charArr[i - 1] == '-') {
						//判断的时候，防止是'-' 开头的，则需要用i-1>-1判断...
						posi = !posi;
					} else {
						posi = false;
					}
				} else {
					posi = true;
				}
			} else {
				num = num * 10 + (posi ? cur : -cur);
			}
		}
		res += num;
		return res;
	}

	public static void main(String[] args) {
		String test = "1K-100ABC500D-T--100F200G!!100H---300";
		System.out.println(numSum(test));

	}

}
