package bank;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountTest {

	@Test
	public void createBankAccountClass() {
		//String accountNum, String type, and double balance
		BankAccount underTest = new BankAccount("1111", "Checking", 23.47);
		Assert.assertNotNull(underTest);
	}
	
//	@Test public void newBankAccountisOpen() {
//		BankAccount underTest = new BankAccount("1111", "Checking", 23.47);
//		Assert.assertTrue(underTest.isOpen());
//	}
	
//	@Test public void newBankAccountStatusisOpen() {
//		BankAccount underTest = new BankAccount("1111", "Checking", 23.47);
//		Assert.assertEquals("open",underTest.getStatus());
//	}
	
//	@Test public void newBankAccountOpenDateNowish() {
//		BankAccount underTest = new BankAccount("1111", "Checking", 23.47);
//		Date currentTime = new Date();
//		Assert.assertTrue("Dates aren't close enough to each other!", 
//		           Math.abs(currentTime.getTime() - underTest.getOpenDate().getTime()) < 1000 );
//	}

}
