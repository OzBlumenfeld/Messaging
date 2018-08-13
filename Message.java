package checkpoint2;

public class Message {
	private String data;
	private Address addr;
	
	public Message(String data,Address addr) {
		this.data = data;
		this.addr = new Address(addr);
	}
	
	public String getData() {
		return this.data;
	}
	
	public Address getAddress() {
		return this.addr;
	}
}
