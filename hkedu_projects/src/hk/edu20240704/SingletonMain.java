package hk.edu20240704;

public class SingletonMain {
	public static void main(String[] args) {
//		SingletonTest st=new SingletonTest();
		SingletonTest st=
				SingletonTest.getInstance();
		
		st.print();
	}
}
