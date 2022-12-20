package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class VendingMachineCLI {



	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS,
					MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_EXIT };

	// added purchase menu options
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY,
					PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

	private Menu menu;
	private Transaction transaction;

	public VendingMachineCLI(Menu menu, Inventory inventory) {
		this.inventory = inventory;
		this.menu = menu;
	}
	private Inventory inventory;
	private LinkedHashMap<String, Snack>products = inventory.InventoryStock();
	public String displayInventory() {
		for (Snack i : products.values()){
			System.out.println(i.toString());
		}
		// look into Linked Hashmap, or Tree Map to order results
		return "\r\n Back to main menu.";
	}


	public void run() {
		inventory.InventoryStock();
		// add load or restock method

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			String nextChoice = null;
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayInventory();
				System.out.println(System.lineSeparator());
				// display vending machine items (Currently returning gibberish)
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				Scanner scanner;
				while (true) {
					// displays purchase menu options with 0 starting balance
					nextChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (nextChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						Transaction.feedMoney(100);
						// feed money method, updates balance, logs
						VMLog.logTransactions("FEED MONEY: $");
					}
					if (nextChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						displayInventory();

						//user input scanner
						Scanner userInput = new Scanner(System.in);
						System.out.print("Enter a string: ");
						String str = userInput.next();
						if (products.containsKey(str)) {
							products.get(str).getMessage();
							products.get(str).updateQty();
						}

							// Extracts the data for the snack from the values array


						}
					}

				// Closes the Scanner object



			} else if (nextChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
				Transaction.coinsReturned();

			} else if (choice.equals(MAIN_MENU_EXIT)) {
				System.out.println("Thank you, please come again.");
				System.exit(0);
			}
		}

	/*	private double balance;
		private double currentBalance;
		private double fedMoney;
		private double change;

		public double getBalance() {
			String balanceFormatter = String.format("%.2f", balance);
			balance += fedMoney;
			return balance;
		}

		public double getCurrentBalance() {
			return currentBalance;
		}
		String balanceFormatter = String.format("%.2f", ) */
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		VendingMachineCLI cli = new VendingMachineCLI(menu, inventory);
		cli.run();
	}
}
