package hk.edu20240729;

public class D2_ThreadMain {
 public static void main(String[] args) {
      //스레드 생성 방법 2가지
      
      //1. Runable 구현 방법
      Runnable runObj = new D2_RunnalbeTest();
      Thread tr = new Thread(runObj);
      tr.setPriority(10);//우선순위 1~10까지
      tr.start();
      
      //2.Thread 클래스 상속 방법
      Thread thr = new D2_ThreadInheritance();
      thr.setPriority(Thread.MIN_PRIORITY); //가장 하위 순위
      thr.start();
      
      //메인스레드
      for(int i=0; i<5; i++) {
         System.out.println("난 메인스레드야.");
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}
