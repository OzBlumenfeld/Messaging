package checkpoint2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FraudDetector {
	private Collection<String> badIPs;
	
	public FraudDetector() {
		this.badIPs = new ArrayList<String>();

	}
	
	public void printBadIPs() {
		Iterator<String> iter = badIPs.iterator();
		while (iter.hasNext()) {
			System.out.println("bad ip : " + iter.next());
		}
	}
	
	public void detectBadIPs(Message[] msgArr,String[] foulWordsArr) {
		for (int i = 0; i < msgArr.length ; i++) {
			if (!validMsg(msgArr[i],foulWordsArr))
				badIPs.add(msgArr[i].getAddress().getIP());
		}
	}
	
	public boolean validMsg(Message msg,String[] foulWordsArr) {
		for (int i = 0 ; i < foulWordsArr.length; i++ ) {
			if (msg.getData().contains(foulWordsArr[i])) 
				return false;
		}
		return true;
	}
	
	public Collection<String> getBadIPs() {
		return this.badIPs;
	}
	
	public void setBadIP(String badIP) {
		this.badIPs.add(badIP);
	}
}
