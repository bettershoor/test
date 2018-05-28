import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {
	private static Integer t;//情况数
	private static int n1;
	private static int n2;
	private static int n3;
	private static int n4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入包括t+1行");
		List<Integer> q = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			t = scanner.nextInt();
			n1 = scanner.nextInt();
			n2 = scanner.nextInt();
			n3 = scanner.nextInt();
			n4 = scanner.nextInt();
			break;
		}	
		q.add(n1);
		q.add(n2);
		q.add(n3);
		q.add(n4);
		System.out.println("输出结果为：");
		int temp1 = 0;//牛吃
		int temp2 = 0;//羊吃
		Iterator iterator = q.iterator();
		while(iterator.hasNext()) {
			
			int t = (int) iterator.next();
			//System.out.println(t);
			int i = 1;
			while(i <= t) {
				temp1 = i;
				if (temp1 > t) {
					System.out.println("niu");
					break;
				}
				temp2 = i * 4;
				t = t - temp1;
				if(temp2 > t) {
					System.out.println("yang");
					break;
				}
				t = t - temp2;
			}
			
		}
	}

}
