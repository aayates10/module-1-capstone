package com.techelevator;

import com.techelevator.view.Menu;

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

	public VendingMachineCLI(Menu menu, Inventory inventory) {
		this.inventory = inventory;
		this.menu = menu;
	}
	private Inventory inventory = new Inventory();

	public void run() {
		inventory.InvetoryStock();
		// add load or restock method

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayInventory();
				System.out.println(System.lineSeparator());
				// display vending machine items (Currently returning gibberish)
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean purchase = true;
				while (purchase) {

				}
				// do purchase
			} else if (choice.equals(MAIN_MENU_EXIT)) {
				System.out.println("Thank you, please come again.");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		VendingMachineCLI cli = new VendingMachineCLI(menu, inventory);
		cli.run();
	}
}
