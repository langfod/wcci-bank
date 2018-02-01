package bank;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

	Map<String, BankAccount> accounts = new HashMap<>();

	public Bank() {

	}

	public Collection<BankAccount> accounts() {
		return accounts.values();
	}

	public void addAccount(BankAccount account) {
		accounts.put(account.getAccountNum(), account);
	}

	public BankAccount getAaccountById(String accountId) {
		return accounts.get(accountId);
	}

	public void closeAccountbyId(String accountId) {
		accounts.remove(accountId);
	}

	public void closeAccount(BankAccount account) {
		closeAccountbyId(account.getAccountNum());
	}

	public boolean hasAccount(String accountStr) {
		return accounts.containsKey(accountStr);
	}
}
