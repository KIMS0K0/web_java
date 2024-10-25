package sk_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class my_SC {
	public static void main(String[] args) {
		Socket socket = null;
		Socket clientSocket = null;//클라이언트 소켓
		PrintWriter out = null; // 클라이어트로 출력할때 사용할 객체
		PrintWriter out_client = null;
		BufferedReader in = null;// 서버로 읽어들일때 사용할 객체
		BufferedReader in_client = null;//서버에서 전달된 메시지를 읽어들일 객체
		BufferedReader userInput = null;//사용자가 키보드로 입력하는 메시지를 읽어들일 객체
		
		try {
			//서버 소켓 생성
			ServerSocket serverSocket=new ServerSocket(9595);
			System.out.println("Server is running.....");
			
			socket=new Socket("192.168.22.62",9595);
			System.out.println("Client:Connection to server...");
			out_client = new PrintWriter(socket.getOutputStream(),true);
			in_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			userInput=new BufferedReader(new InputStreamReader(System.in));
			String inputLine2="";
			
			while(true) {
				clientSocket = serverSocket.accept();
				System.out.println("클라이언트 연결됨:"
							     +clientSocket.getInetAddress().getHostName());
				out = new PrintWriter(clientSocket.getOutputStream(),true);
				
				in = new BufferedReader(
						                new InputStreamReader(
								                   clientSocket.getInputStream()
								                   )
						               );
				
				String inputLine ="";
				while((inputLine=in.readLine())!=null) {
					System.out.println("클라이언트로부터 전달되는 메시지:"+inputLine);
					//클라이언트로 보낼 메시지
					out.println("니가 보낸 메시지:"+inputLine);
				}
				
				
				while ((inputLine2=userInput.readLine())!=null) {
					out_client.println(inputLine2);//키보드로 입력된 내용을 소켓으로 출력
					System.out.println(in.readLine());//서버에서 전달된 메시지를 읽고 출력하기
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(in!=null) {
					in.close();
				}
				if(out!=null) {
					out.close();
				}
				if(clientSocket!=null) {
					clientSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
