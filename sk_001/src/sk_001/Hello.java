package sk_001;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {	
		
		System.out.println(yaksu(12));
		System.out.println(choidae(10,20));
		System.out.println(choiso(2,4));
		chinwhasu(220);
		whanjeonsu(1000);
		//lunar(2001,2030);
		//ant(6);
		//dangcheom();
		magicSquare(3);
		//magicSquare(5);
		
		makeCards(52);
		baseball();
	}
	
	public static String yaksu(int num) { //1. 약수 구하기
		System.out.println("1. 약수구하기");
		String yaksoo = num + "의 약수는 ";
		for (int i = 1; i<= num; i++) {
			if(num % i == 0) yaksoo += i + " ";
		}
	    return yaksoo;
	}
	
	public static int choidae(int x, int y) { //2. 최대공약수 구하기
		System.out.println("\n2. 최대공약수 구하기");
		System.out.print(x+"와 " + y + "의 최대공약수는 ");
		int num = x > y ? y : x;
		int cg = 1;
		for (int i = 1; i<=num ; i++) {
			if (x % i == 0 && y % i == 0) cg = i;
		}
		return cg;
	}
	
	public static int choiso(int x, int y) { //3. 최소공배수 구하기
		System.out.println("\n3. 최소공배수 구하기");
		System.out.print(x+"와 " + y + "의 최소공배수는 ");
		
		int cg = 0;
		while (true) {
			cg ++;
			if (cg % x == 0 && cg % y == 0) break;
		}
		return cg;
	}
	
	public static void chinwhasu(int num) { //4. 친화수 구하기
		System.out.println("\n4. 친화수 구하기");
		int chiwhasoo = 0;
		for (int i = 1; i<num; i++) {
			if(num % i == 0) chiwhasoo += i;
		}
		int chiwhasoo2 = 0;
		for (int i = 1; i<chiwhasoo; i++) {
			if(chiwhasoo % i == 0) chiwhasoo2 += i;
		}
		if (chiwhasoo2 == num)
			System.out.println(num + "의 친화수는 " + chiwhasoo);
	}
	
	public static void whanjeonsu(int num) { //5. 완전수 구하기
		System.out.println("\n5. 완전수 구하기");
		String whanjeonsoolist = num + " 이하의 완전수 : ";
		for(int i = 1; i<num; i++) {
			int whanjeonsoo = 0;
			for (int j = 1; j<i; j++) {
				if(i % j == 0) whanjeonsoo += j;
			}
			if (i == whanjeonsoo)
				whanjeonsoolist += whanjeonsoo + " ";
		}
		System.out.println(whanjeonsoolist);
	}
	
	
	public static void lunar(int year1, int year2) { //6. 윤년 구하기
		System.out.println("\n6. 윤년 구현하기");
		for (int i = year1; i<=year2;i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
				System.out.println(i +"년은 윤년입니다.");
		}
	}
	
	public static void ant(int num) { //7. 개미수열
		System.out.println("\n7. 개미수열 구현하기");
		String antt = "1 ";
		int count = 1;
		String anttt = "";
		
		for(int j = 0; j<num;j++) {
			System.out.println(j+1 + ": " + antt);
			count = 1;
			anttt = "";
			for (int i = 0; i<antt.length()-1; i++) {
				if (antt.charAt(i) == antt.charAt(i+1)) {
					count ++;
				}
				else {
					anttt += antt.charAt(i) + "" + count + "";
					count = 1;
				}
			}
			antt = anttt + " ";
		}
	}
	
	public static int[] Lotto() {
		int[] lotto = new int[6];
		int a = 0;
		int correct = 0;
		for (int i = 0; i<6 ;i++) {
			
			while(true) {
				correct = 0;
				a = (int)((Math.random()*100)%45)+1;
				for (int k = 0;k<i;k++) {
					if (lotto[k] != a) correct += 1;
				}
				if (correct ==i) break;
			}
			
			lotto[i] = a;			
		}
		return lotto;
	}
	public static int[][] LottoStore() {
		int[][] lotto = new int[6][6];
		for (int i = 0; i<6 ; i++) {
			lotto[i] = Lotto();
		}
		return lotto;
	}
	public static void dangcheom() {
		System.out.println("\n8. 로또 번호 만들기");
		
		System.out.printf("<<추첨번호>> ");
		int[] lotto = Lotto();
		for(int i = 0;i<6;i++) System.out.print(lotto[i]+" ");
		
		String numbers = "";
		int num = 0;
		
		System.out.printf("\n<<주문 로또>>\n");
		int[][] myLotto = LottoStore();
		for(int i = 0;i<6;i++) {
			System.out.printf("%d번: ",i+1);
			for(int j = 0; j<6;j++) {
				System.out.printf(myLotto[i][j] + " ");
				for(int k = 0;k<6;k++) {
					if (lotto[k] == myLotto[i][j]) {
						numbers += lotto[k] + " ";
						num += 1;
					}
				}
			}
			System.out.print(" | 당첨번호: " + numbers + "| 당첨수: " + num);
			if(num >= 2) System.out.printf(" | %d등", (7-num));
			
			System.out.println();
			numbers="";
			num = 0;
		}
		LottoStore();
	}
	
	public static void magicSquare(int k) {
		System.out.printf("\n8. 추가_홀수 마방진 구현하기\n");
		int[][] ms = new int[k][k];
		
		int x = k-1;
		int y = k-1;
		int clear = 0;
		
		int stop = 0;
		int correct = 0;
		int sum_crossA = 0;
		int sum_crossB = 0;
		
		int[] sum_x = new int[k]; // 0 0 0
		int[] sum_y = new int[k]; // 0 0 0
		boolean sum_xx = true;
		boolean sum_yy = true;
		
		while(true) {
			stop ++;
			//if (stop > k*k) break;
			
			while (true) {
				correct = 0;
				ms[x][y] = (int)((Math.random()*10)%(k*k))+1;
				for (int i = 0; i< k;i++) {
					for (int j = 0; j<k;j++) {
						if (ms[x][y] != ms[i][j]) correct ++;
					}
				}
				if (correct == (k*k)-1) break;
			}

			for (int i = 0; i< k;i++) {
				for (int j = 0; j<k;j++) {
					if (ms[i][j] != 0) clear ++;
				}
			}
			if (clear == k*k) {
				for (int i = 0;i<k;i++) { // 0 1 2
					sum_crossA += ms[i][i]; // 0 1 2
					sum_crossB += ms[k-1-i][i]; // 2 1 0
					for (int j = 0;j<k;j++) { // 0 1 2
						sum_x[i] += ms[i][j]; // 00 01 02 
						sum_y[i] += ms[j][i];
					}
				}
				for (int i = 1; i<k;i++) {
					if (sum_x[i] != sum_x[0]) sum_xx = false;
					if (sum_y[i] != sum_y[0]) sum_yy = false;
				}
				if (sum_crossA == sum_crossB) {
					if (sum_xx == true && sum_yy == true) break;
				}
				for (int i = 0; i< k;i++) {
					sum_x[i] = 0;
					sum_y[i] = 0;
					for (int j = 0; j<k;j++) {
						ms[i][j] = 0;
					}
				}
				sum_xx = true;
				sum_yy = true;
				sum_crossA = 0;
				sum_crossB = 0;
			}
			clear = 0;
			
			x --;
			y --;
			
			if (x<0) x = k-1;
			if (y<0) y = k-1;
			
			if(ms[x][y] != 0) x ++;
			
			if (x > k-1) x = 1;
			
			
		}
		
		for (int i = 0; i< k;i++) {
			for (int j = 0; j<k;j++) {
				System.out.printf(ms[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 * System.out.println("\n" + sum_crossA + " " + sum_crossB);
		 * System.out.println(sum_x[0] + " " + sum_x[1] + " " + sum_x[2]);
		 * System.out.println(sum_y[0] + " " + sum_y[1] + " " + sum_y[2]);
		 * System.out.println(sum_xx); System.out.println(sum_yy);
		 */
	}
	
	public static void baseball() {
		System.out.printf("\n\n8. 야구게임");
		int[] pitcher = new int[3];
		
		int num = 0;
		int correct = 0;
		
		int strike = 0;
		int ball = 0;
		
		for (int i = 0;i<3;i++) {
			while(true) {
				correct = 0;
				pitcher[i] = (int)((Math.random()*100)%10);
				for(int j = 0;j<i;j++)
					if (pitcher[i] != pitcher[j]) correct += 1;
				if (correct != i) continue;
				break;
			}
			//System.out.printf(pitcher[i] + " ");
		}
		System.out.println();
		while (true) {
			strike = 0;
			ball = 0;
			
			System.out.println("\n숫자 3개를 입력하세요. ");
			Scanner scanner = new Scanner(System.in);
			int[] batter = new int[3];
			
			for(int i = 0; i<3;i++) {
				while(true) {
					try {
						batter[i] = scanner.nextInt();
						if (batter[i] > 9 || batter[i] < 0) throw new ArithmeticException(); 
					} catch (Exception e) {
						System.out.println("다시 입력");
						scanner = new Scanner(System.in);
						continue;
					}
					break;
				}
			}
			
			System.out.print("타자: ");
			for(int i = 0; i<3;i++) {
				System.out.print(batter[i] + " ");
			}
			
			for (int i = 0; i<3;i++) {
				for (int j = 0; j<3; j++) {
					if (pitcher[i] == batter[j]) {
						if (i == j) strike ++;
						else ball ++;
					}
				}
			}
			System.out.printf("-> ");
			if (strike > 0) System.out.printf(strike + "S ");
			if (ball > 0) System.out.print(ball + "B ");
			if (strike == 0 && ball == 0) System.out.print("out");
			
			if (strike ==3) {System.out.println("모두 일치!! 타자 승리!!");scanner.close(); break;}
			System.out.println();
		}
	}
	
	public static void calender(int year) {
		System.out.println("\n9. 달력 구현하기");
		int days = 0;
		
		int day = 0;
		List<Integer> month = Arrays.asList(new Integer[] {31,28,31,30,31,30,31,31,30,31,30,31});
		
		for (int i = 1; i<year;i++) {
			days += 365;
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
				days+=1;
		}
		
		day = (days+1)%7;
		int firstday = 0;
		
		if (year % 4 == 0 && year % 100 != 0) month.set(1, 29);
		

		for (int i = 0; i<12;i++) {
			firstday = day % 7; //1일 요일 번호
			System.out.printf("\n# %d년 %d월",year,i+1);
			System.out.printf("\n  M  T  W  T  F  S  S");
			for (int j = 0;j<=month.get(i)+firstday;j++) {
				if (j-firstday>0) System.out.printf("%3d",j-firstday);
				else System.out.printf("   ");
				if (j % 7 == 0) System.out.println();
			}
			day += month.get(i); //며칠까지 있는지
			System.out.println();
		}
	}
	public static int calender(int year, int my_month, int my_day) {
		int days = 0; //일수
		int day = 0; //1일 요일
		List<Integer> month = Arrays.asList(new Integer[] {31,28,31,30,31,30,31,31,30,31,30,31});
		
		for (int i = 1; i<year;i++) {
			days += 365;
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
				days+=1;
		}
		
		day = (days+1)%7;
		int firstday = 0;
		
		if (year % 4 == 0 && year % 100 != 0) month.set(1, 29);
	

		for (int i = 0; i<my_month-1;i++) {
			days += month.get(i);
			firstday = day % 7; //1일 요일 번호
			day += month.get(i); //며칠까지 있는지
		}
		days+=my_day;
		return days;
	}
	public static void myLife(int year1, int month1, int day1, int year2, int month2, int day2) {
		System.out.printf("\n9-2. 살아온 일수 구하기\n");
		int life1 = calender(year1, month1, day1);
		int life2 = calender(year2, month2, day2)+1;
		System.out.printf("%d.%02d.%02d ~ %d.%02d.%02d : ", year1,month1,day1, year2,month2,day2);
		System.out.println(life2 - life1 + "일");
	}
	
	public static String makeCard() {
		List<String> img = Arrays.asList(new String[] {"♥","♣","♠","◆"});
		//List<String> img = Arrays.asList(new String[] {"A","B","C","D"});
		List<String> num = Arrays.asList(new String[] {"2","3","4","5","6","7","8","9","10","T","J","Q","K"});
		int i = (int)((Math.random()*10)%4);
		int n = (int)((Math.random()*100)%13);
		
		String card = img.get(i)+""+num.get(n); 
		return card;
	}
	public static void makeCards(int num) {
		System.out.print("\n10.카드 만들기");
		
		String[] cards = new String[num];
		cards[0] = makeCard();		
		int correct = 0;
		
//		for (int i = 1;i<num;i++) { // 1 2 3 4 5 6 7 8 9
//			System.out.println();
//			cards[i] = makeCard();
//			System.out.print(i+":" + cards[i] +" ");
//			for (int j = 0; j<i;j++) { // 0
//				if (cards[i].contains(cards[j])) System.out.print("같");
//				if (cards[i] == cards[j]) System.out.print("같");
//				else System.out.print("다");
//				System.out.print(cards[i] + ":" +cards[j] + " ");
//			}
//		}
//
//		System.out.println();
//		for (int i = 0;i<num;i++) {
//			if (i > 0 && cards[i] == cards[0]) System.out.println("같다");
//			System.out.print(cards[i] + " ");
//		}
//		System.out.println();
//		System.out.println();
		for (int i = 1;i<num;i++) { // 1 2 3 4 5 6 7 8 9
			while(true) {
				correct = 0;
				cards[i] = makeCard();
				for (int j = 0; j<i;j++) { // 0
					//if (cards[i] != cards[j]) correct ++;
					if ((cards[i].contains(cards[j])) == false) correct ++;
				}
				if (correct == i) break;
			}
		}
		
		//System.out.println();
		System.out.println(); // 9 18 27 36 45 54
		for (int i = 0;i<num;i++) {
			System.out.print(cards[i] + " ");
			if ((i+1) %10 == 0) System.out.println();
		}
	}
}





