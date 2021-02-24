
package dev.boot.features.jms.messaging;

public class Confirmation {

	private int ackNumber;
	private String OTP;

	public Confirmation(int ackNumber, String oTP) {
		super();
		this.ackNumber = ackNumber;
		OTP = oTP;
	}

	public Confirmation() {
	}

	public int getAckNumber() {
		return ackNumber;
	}

	public void setAckNumber(int ackNumber) {
		this.ackNumber = ackNumber;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	@Override
	public String toString() {
		return "Confirmation [ackNumber=" + ackNumber + ", OTP=" + OTP + "]";
	}

}
