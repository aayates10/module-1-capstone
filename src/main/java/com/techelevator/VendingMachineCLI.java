package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {



	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_Exit = "Exit";

	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_Exit };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	private Inventory inventory = new Inventory();

	public void run() {
		inventory.getVendingFileData();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.print(inventory.getVendingFileData());
				// display vending machine items (Currently returning gibberish)
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

/* group code before adding to CLI





 */