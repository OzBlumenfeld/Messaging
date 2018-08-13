package checkpoint2;

import java.util.HashMap;

public class MessageControl {
	//Fields
	private int msgCounter;
	private HashMap<Address, Integer> all;
	private HashMap<Address, Integer> tenPercent;
	
	//Constructors
	public MessageControl() {
		this.msgCounter = 0;
		this.all = new HashMap<Address,Integer>();
		this.tenPercent = new HashMap<Address,Integer>(10);
	}
	//Getters
	public HashMap<Address,Integer> getAll(MessageControl msgControl){
		return this.all;
	}
	public HashMap<Address,Integer> getTenPercent(MessageControl msgControl){
		return this.tenPercent;
	}
	public int getMsgCounter() {
		return this.msgCounter;
	}
	public void setMsgCounter(int value) {
		this.msgCounter = value;
	}
	
	public void recieveMsg(Message msg){
		Address msgAddr = msg.getAddress();
		//Entering data to all hash table.
		if (all.containsKey(msgAddr)) {
			this.setMsgCounter(this.getMsgCounter() + 1);
			all.put(msgAddr, all.get(msgAddr) + 1);
		}
		else {
			this.setMsgCounter(this.getMsgCounter() + 1);
			all.put(msgAddr, 1);
		}
		updateTenPercent();
//		double proportion = (double)all.get(msgAddr)/this.getMsgCounter();
//		if (proportion >= 0.1) {
//			this.tenPercent.put(msgAddr, all.get(msgAddr));
//		}
	}
		
	public void updateTenPercent() {
		System.out.println("The top 10% messagers are:");
		for (Address key : this.all.keySet()) {
			double proportion = (double)all.get(key)/this.getMsgCounter();
			if (proportion >= 0.1) {
				System.out.println("***");
				this.tenPercent.put(key, all.get(key));
				System.out.println("IP: " + key.getIP() +" Messages:  " + tenPercent.get(key));
				System.out.println("");
			}
			else {
				if (tenPercent.containsKey(key)) {
					tenPercent.remove(key);
				}
			}
		}
	}	
}


