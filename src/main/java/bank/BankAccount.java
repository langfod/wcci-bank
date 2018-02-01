package bank;

public class BankAccount {

	private double balance;
	private String type;
	private String accountNum;

	public BankAccount(String accountNum, String type, double balance) {
		this.setAccountNum(accountNum);
		this.setType(type);
		this.setBalance(balance);

	}

	public String getAccountNum() {
		return accountNum;
	}

	private void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("%-6s\t%10s\t$%8.2f", getAccountNum(), getType(), getBalance());
	}

	public boolean withDrawFunds(Double withdrawAmount) {
		boolean success = false;
		double newBal = getBalance() - withdrawAmount;
		if (newBal >= 0) {
			setBalance(newBal);
			success = true;
		}
		return success;
	}

	public boolean deposit(Double depositAmount) {
		setBalance(getBalance() + depositAmount);
		return true;
	}
}
