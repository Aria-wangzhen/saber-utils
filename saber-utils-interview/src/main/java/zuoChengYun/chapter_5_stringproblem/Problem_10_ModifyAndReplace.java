package zuoChengYun.chapter_5_stringproblem;

/**
 * 字符串调整与替换
 */
public class Problem_10_ModifyAndReplace {

	public static void replace(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int num = 0;
		int len = 0;
		for (len = 0; len < chas.length && chas[len] != 0; len++) {
			if (chas[len] == ' ') {
				num++;
			}
		}
		int j = len + num * 2 - 1;
		for (int i = len - 1; i > -1; i--) {
			if (chas[i] != ' ') {
				chas[j--] = chas[i];
			} else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}
	}

	public static String replace1(char[] chas) {
		if (chas == null || chas.length == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for(int i= 0;i<chas.length;i++){
			sb.append(chas[i]);
		}
		return sb.toString().replaceAll(" ","%20");
	}

	public static void modify(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int j = chas.length - 1;
		for (int i = chas.length - 1; i > -1; i--) {
			if (chas[i] != '*') {
				chas[j--] = chas[i];
			}
		}
		for (; j > -1;) {
			chas[j--] = '*';
		}
	}

	public static void main(String[] args) {
		char[] chas1 = { 'a', ' ', 'b', ' ', ' ', 'c', 0, 0, 0, 0, 0, 0, 0, 0, };
		replace(chas1);
		System.out.println(String.valueOf(chas1));
		System.out.println("++++："+replace1(chas1));

		char[] chas2 = { '1', '2', '*', '*', '3', '4', '5' };
		modify(chas2);
		System.out.println(String.valueOf(chas2));

	}

}
