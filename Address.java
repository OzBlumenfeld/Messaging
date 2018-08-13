package checkpoint2;

public class Address {

	private String ip;
	
	public Address(String ip) {
		this.ip = ip;
	}
	
	public Address(Address addr) {
		this.ip = addr.getIP();
	}

	public String getIP() {
		return this.ip;
	}
}
