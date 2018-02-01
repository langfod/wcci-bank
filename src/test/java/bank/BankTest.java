package bank;

 import org.junit.Assert;
import org.junit.Test;

public class BankTest {

	@Test
	public void createBankClass() {
		Bank underTest = new Bank();
		Assert.assertNotNull(underTest);
	}
	// @Test public void returnAccountCollections() {
	// Bank underTest = new Bank();
	// Collection<BankAccount> accountList = underTest.accounts();
	// Collection<BankAccount> col = new ArrayList<BankAccount>();
	//
	// Assert.assertSame(col.getClass(), accountList.getClass());
	// }

	@Test
	public void addBankAccountToBank() {
		Bank underTest = new Bank();
		BankAccount account1 = new BankAccount("1111", "Checking", 23.47);
		underTest.addAccount(account1);
		BankAccount accountFromBank = (BankAccount) underTest.accounts().toArray()[0];
		Assert.assertSame(account1, accountFromBank);		
	}

	@Test
	public void getBankAccountByAccountNum() {
		Bank underTest = new Bank();
		BankAccount account1 = new BankAccount("1111", "Checking", 23.47);
		underTest.addAccount(account1);
		BankAccount accountFromBank = underTest.getAaccountById("1111");
		Assert.assertSame(account1, accountFromBank);
	}

	@Test
	public void nukeBankAccount() {
		Bank underTest = new Bank();
		BankAccount account1 = new BankAccount("1111", "Checking", 23.47);
		underTest.addAccount(account1);
		underTest.closeAccountbyId("1111");
		BankAccount accountFromBank = underTest.getAaccountById("1111");
		Assert.assertNull(accountFromBank);
	}

	@Test
	public void closeAccountUsingId() throws Exception {
		Bank underTest = new Bank();
		BankAccount account1 = new BankAccount("1111", "Checking", 23.47);
		underTest.addAccount(account1);
		underTest.closeAccount(account1);
		BankAccount accountFromBank = underTest.getAaccountById("1111");
		Assert.assertNull(accountFromBank);
	}
}
