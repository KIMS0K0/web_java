package hk.edu20240729;

public class D2_ThreadInheritance extends Thread{
   @Override
   public void run() {
      for(int i =0; i<5; i++) {
         System.out.println("나는 쓰레드르 상속받은 스레드야.");
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

   }

}
