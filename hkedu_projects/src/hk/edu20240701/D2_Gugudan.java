package hk.edu20240701;

public class D2_Gugudan {

	public static void main(String[] args) {
		
//		D1_ControlFlow control=new D1_ControlFlow();
	
		//구구단 출력하기
		//2단 출력:
		for (int i = 1; i <= 9; i++) {
//			System.out.println("2X"+i+"="+(2*i));
			System.out.printf("2x%d=%d\n",i,(2*i));
//			System.out.println();
		}
		
		//2~9단 출력하기
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%dx%d=%d\n",i,j,i*j);
			}
			System.out.println();
		}
		//2~9단까지 출력하는데 이때 짝수단만 출력하기
		for (int i = 2; i <= 9; i++) {
			if(i%2==0) {
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%dx%d=%d\n",i,j,i*j);
				}				
			}
			System.out.println();
		}
		//2~9단까지 출력하는데 이때 홀수단만 출력하기
		for (int i = 2; i <= 9; i++) {
			if(i%2!=0) {
				for (int j = 1; j <= 9; j++) {
					System.out.printf("%dx%d=%d\n",i,j,i*j);
				}				
			}
			System.out.println();
		}
		
		//1~100까지 정수의 총합을 출력하자.
		// 1 2 3 4.... 100  
		// 1+2+3+4...+100 총합
		
		int sum=0;//정수들의 합을 저장할 변수 선언
		for (int i = 1; i <= 100; i++) {
//			sum=sum+i;
			sum+=i;  //단축연산자 사용
		}
		System.out.println("1~100까지 총합:"+sum);
		
		//1~100까지 정수 중 3의 배수의 총합을 출력하자
		int sum2=0;//정수들의 합을 저장할 변수 선언
		for (int i = 1; i <= 100; i++) {
//			sum=sum+i;
			if(i%3==0) {
				sum2+=i;  //단축연산자 사용				
			}
		}
		System.out.println("1~100까지 3배수의 총합:"+sum2);
		
		//주사위 두개의 합이 5이면 실행을 멈추고, 5가 아니면 계속 실행하는 코드를 작성하자
		//실행결과 출력하기: (2,5) (1,3) (4,3).....
		//1~6까지의 숫자로 구성되며, 프로그램상에서는 랜덤하게 숫자가 생성되도록 해야함
		//Math 객체에 random()메서드를 사용하면 랜덤한 숫자를 얻을 수 있음
		//수학관련 내용 기능 제공
		//random(); 0.00000....1  ~ 0.999999  -> 0과 1사이의 실수를 반환
		int number=(int)Math.random();
		System.out.println("랜덤숫자생성:"+number+(Math.random()));
		//우리가 필요한 숫자는 1~6
		number=(int)(Math.random()*6+1);//  0~1사이  *6  1 *6= 6 
		                                // 5.999999 +1 = 6.9999..
		while(true) {
			int num1=(int)(Math.random()*6+1);//주사위1번
			int num2=(int)(Math.random()*6+1);//주사위2번
			System.out.printf("(%d,%d)\n",num1,num2);
			if(num1+num2==5) {
				System.out.println("합이 5가되어 종료합니다.");
				break;
			}
		}
	}
}






