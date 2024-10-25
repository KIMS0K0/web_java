package hk.edu20240729;

public class D3_ThreadSync {
   //내부클래스
   class ShareObject{
      public synchronized void print(String title){
         for(int i=0; i<10; i++) {
            System.out.println(title);
            try {
               Thread.sleep(500);
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
   }
   public static void main(String[] args) {
      //공유 객체 생성
      ShareObject so = new D3_ThreadSync().new ShareObject();
      
      //A와 B 스레드가 동시접근.
      //동기화 설정하기: A스레드의 작업이 종료되기까지 B스레드가 대기.
      //설정방법은 동기화 synchronized 메서드 or synchronized(공유객체){} 문법이라 외워야 함.
      Thread trA = new Thread() {
         @Override
         public void run() {
            so.print("공");
         }
      };
      Thread trB = new Thread() {
         @Override
         public void run() {
            so.print("유");
         }
      };
	      trA.start();
	      trB.start();
      
      //---------------------
      
      D3_ThreadSync d3 = new D3_ThreadSync();
      Thread trC = new Thread() {
         @Override
         public void run() {
            d3.sbTest("건");
         }
      };
      
      Thread trD = new Thread() {
         @Override
         public void run() {
            d3.sbTest("양");
         }
      };
      
      trC.start(); trD.start();
   }//main 종료
   
 //자체 동기화 제공 o 안정 o 속도 x
//   public static StringBuffer sb = new StringBuffer();
   
 //자체 동기화 제공 x 안정 x 속도 o
   public static StringBuilder sb = new StringBuilder(); //static : 공유
   
   
   public void sbTest(String s) { //순서 정해주기
      synchronized (sb) {
		sb.append(s);
		System.out.println(sb.toString());
	}
	try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
}
