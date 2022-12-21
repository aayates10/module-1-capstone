package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

public class VendingMachineCLI {
	public static void main (String[]args){
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenu purchaseMenu = new PurchaseMenu(System.in, System.out);
		Transaction transaction = new Transaction();
		Inventory inventory = new Inventory();
		VendingMachineCLI cli = new VendingMachineCLI(menu, inventory, purchaseMenu, transaction);
		cli.run();
	}

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
						VMLog.logTransactions("FEED MONEY: $" +purchaseMenu.getNonpreBalance() +" $"+ purchaseMenu.getPrevBalance());

					} else if (nextChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						//display products
						inventory.displayInventory();
						//allow input of which 'key' to buy
						transaction.transaction();

						if (!inventory.getSnacks().containsKey(transaction.getTempkey())) {

							//catches if key does not exist and returns to menu
							System.out.println("Item UNAVAILABLE, returning to purchase menu: ");
						} else if((inventory.getSnacks().get(transaction.getTempkey()).getQty() == 0)){
							//catches if that item is sold out and informs customer, returning to menu
							System.out.println("\r\n******* SOLD OUT *******: ");
						}else{
							//dispenses item, adjusts inventory and balances, then logs
							System.out.println("\r\nItem purchased, dispensing " + inventory.getSnacks().get(transaction.getTempkey()).getName() + ": " + inventory.getSnacks().get(transaction.getTempkey()).getMessage() + System.lineSeparator());
							purchaseMenu.removeBalance(inventory.getSnacks().get(transaction.getTempkey()).getPrice());
							inventory.getSnacks().get(transaction.getTempkey()).getInventoryTakeAway(true);
							VMLog.logTransactions(inventory.getSnacks().get(transaction.getTempkey()).getName() + " " + inventory.getSnacks().get(transaction.getTempkey()).getSnackType() + " $" + purchaseMenu.getNonpreBalance() + " $" + purchaseMenu.getPrevBalance());
						}
						} else if (nextChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
							purchaseMenu.returnChange();
							purchaseMenu.feedMoney();
						} else if (choice.equals(MAIN_MENU_EXIT)) {
							System.out.println("Thanks, ENJOY.");
							System.exit(0);
					} else if (choice.equals(MAIN_MENU_EXIT)) {
						System.out.println("Thanks, ENJOY.");
					}
				}

			}
		}
	}
}