package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	public static void main(String[] args) {
		// Ҫ��֤���ַ���
	    String str = "d47896ef-19b4-446a-af97-8cb702dd5c83";
	    // ������֤����
	    String regEx = "^([0-9a-fA-F]){8}-([0-9a-fA-F]){4}-([0-9a-fA-F]){4}-([0-9a-fAF]){4}-([0-9a-fA-F]){12}$";
//	    String regEx = "^[\w$"
	    // ����������ʽ
	    Pattern pattern = Pattern.compile(regEx);
	    // ���Դ�Сд��д��
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // �ַ����Ƿ���������ʽ��ƥ��
	    boolean rs = matcher.matches();
	    System.out.println(rs);
	}
}
