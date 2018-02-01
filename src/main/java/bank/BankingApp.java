package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApp {

	static Scanner input = new Scanner(System.in);

	@SuppressWarnings("serial")
	public static void main(String[] args) {

		Bank myBank = new Bank();
		BankAccount account1 = new BankAccount("1111", "Checking", 500.00);
		BankAccount account2 = new BankAccount("2222", "Savings", 2500.00);

		myBank.addAccount(account1);
		myBank.addAccount(account2);

		Map<String, Runnable> userFunctions = new HashMap<String, Runnable>() {
			{
				put("1", () -> doDeposit(myBank));
				put("2", () -> doWithDraw(myBank));
				put("3", () -> doBalance(myBank));
				put("4", () -> doCloseAccount(myBank));
				put("-1", () -> goodBye());
			}
		};
		

		while (true) {
			showAccounts(myBank);
			showMenu();
			userFunctions.getOrDefault(input.nextLine(), () -> {}).run();
		}
	}

	public static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("1) Deposit       \t 2) Withdraw");
		System.out.println("3) Check Balance \t 4) Close Account");
		System.out.println("Use -1 to be a quitter.");
	}

	public static void showAccounts(Bank myBank) {
		System.out.println("\nHere are your accounts at our bank:");
		myBank.accounts().forEach(System.out::println);
	}

	private static void doDeposit(Bank myBank) {
		BankAccount account = getAccountFromUser(myBank, "Deposit into");
		if (null != account) {
			System.out.println("How much would you like to deposit into your " + account.getType() + " account?");
			try {
				Double depositAmount = Double.parseDouble(input.nextLine());
				account.deposit(depositAmount);
				System.out.printf("$%6.2f has been deposited into your " + account.getType() + " account%n",
						depositAmount);

			} catch (NumberFormatException e) {
				System.out.println("Sorry I did not understand.");
			}
		}
	}

	private static void doWithDraw(Bank myBank) {
		BankAccount account = getAccountFromUser(myBank, "Withdraw from");
		if (null != account) {
			System.out.println("How much would you like to withdraw from your " + account.getType() + " account?");
			try {
				Double withdrawAmount = Double.parseDouble(input.nextLine());
				if (account.withDrawFunds(withdrawAmount)) {
					System.out.printf("Enjoy your $%6.2f%n", withdrawAmount);
				} else {
					System.out.println("I am sorry but I can't withdraw that amount");
				}
			} catch (NumberFormatException e) {
				System.out.println("Sorry I did not understand.");
			}

		}
	}

	private static void doBalance(Bank myBank) {
		BankAccount account = getAccountFromUser(myBank, "Display the balance of");
		if (null != account) {
			System.out.printf("\nBalance of %s is %8.2f%n", account.getType(), account.getBalance());
		}
	}

	private static void doCloseAccount(Bank myBank) {
		BankAccount account = getAccountFromUser(myBank, "Close");
		if (null != account) {
			myBank.closeAccount(account);
			System.out.println("\nYour " + account.getType() + " account has been incernerated.");
		}
	}

	private static BankAccount getAccountFromUser(Bank myBank, String str) {
		BankAccount account = null;
		while (true) {
			showAccounts(myBank);
			System.out.println("\n" + str + " which account number? (or cancel)");
			String accountStr = input.nextLine();

			if ("cancel".equalsIgnoreCase(accountStr)) {
				break;
			} else if (myBank.hasAccount(accountStr)) {
				account = myBank.getAaccountById(accountStr);
				break;
			} else {
				System.out.println("\nI can't find that account number.");
				continue;
			}
		}
		return account;
	}

	private static void goodBye() {
		System.out.println("\nGoodBye!\n");
		input.close();
		System.exit(0);
	}

}
