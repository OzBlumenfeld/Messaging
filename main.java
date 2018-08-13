package checkpoint2;

import java.util.Collection;

public class main {

	
	public static void main(String[] args) {
		Message[] msgArr = initialization();
		sendingMessages(msgArr);
		printBadIPs(msgArr);
		
	}
	
	public static Message[] initialization() {
		Message [] arr = new Message[4];
		
		arr[0] = new Message("Hello", new Address("02"));
		arr[1] = new Message("Hola", new Address("12"));
		arr[2] = new Message("Halo", new Address("22"));
		arr[3] = new Message("Bonjour", new Address("32"));
		
		return arr;
	}
	
	public static void sendingMessages(Message[] msgArr) {
		MessageControl msgCon = new MessageControl();
		for (int i= 0; i < msgArr.length;i++) {
			msgCon.recieveMsg(msgArr[i]);
		}
		for (int i= 0; i < 10;i++) {
			msgCon.recieveMsg(msgArr[0]);
		}
		for (int i= 0; i < 10;i++) {
			msgCon.recieveMsg(msgArr[1]);
		}
	}
	
	public static void printBadIPs(Message[] msgArr ) {
		FraudDetector detector = new FraudDetector() ;
		String[] foulWordsArr = {"Hello","Halo","Feeder"};
		detector.detectBadIPs(msgArr, foulWordsArr);
		detector.printBadIPs();
		
	}
	
}
