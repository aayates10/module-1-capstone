package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

public class VendingMachineCLI {


	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT};

	// added purchase menu options
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY,
			PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

	private Menu menu;
	private PurchaseMenu purchaseMenu;

	private Transaction transaction;


	public VendingMachineCLI(Menu menu, Inventory inventory, PurchaseMenu purchaseMenu, Transaction transaction) {
		this.inventory = inventory;
		this.menu = menu;
		this.purchaseMenu = purchaseMenu;
		this.transaction = transaction;

	}

	private Inventory inventory = new Inventory();


	public void run() {
		inventory.InventoryStock();
		// add load or restock method

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayInventory();
				System.out.println(System.lineSeparator());
				// display vending machine items (Currently returning gibberish)
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while (true) {
					// displays purchase menu options with 0 starting balance
					String nextChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (nextChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						purchaseMenu.feedMoney();
						// feed money method, updates balance, logs
						VMLog.logTransactions("FEED MONEY: $");
					}
					else if (nextChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						inventory.displayInventory();
						transaction.transaction();

						if (!inventory.getSnacks().containsKey(transaction.getTempkey())) {

							//catches if key does not exist and returns to menu
							System.out.println("That item does not exist, returning to purchase menu: ");

						}else IF ((nextChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
							purchaseMenu.returnChange();
							purchaseMenu.feedMoney();
						}else if (choice.equals(MAIN_MENU_EXIT)) {
							System.out.println("Thank you, please come again.");
							System.exit(0);
						}

				} else if (choice.equals(MAIN_MENU_EXIT)) {
						System.out.println("Thank you, please come again.");
				}
			}

		}

		public static void main (String[]args){
			Menu menu = new Menu(System.in, System.out);
			PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
			Transaction transaction = new Transaction();
			Inventory inventory = new Inventory();

			VendingMachineCLI cli = new VendingMachineCLI(menu, inventory, purchaseMenu, transaction);
			cli.run();
		}
	}