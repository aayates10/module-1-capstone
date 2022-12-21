package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	//used to output the menu options to the user
	private PrintWriter out;
	//reads the user's input.
	private Scanner in;

	/*A constructor that takes in an InputStream and an
	OutputStream as arguments.
	These streams are used to create the Scanner and PrintWriter
	objects, respectively.
	 */
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	/*Takes an array of objects as an argument and returns an object.
	Displays the menu options to the user and waits for their input.
	It continues to do so until the user provides a valid input.
	 */
	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	/*takes an array of objects as an argument and returns an object.
	It reads the user's input, converts it to an integer,
	and checks if it is a valid menu option. If it is,
	it returns the corresponding object from the options array.
	If it is not a valid option, it prints an error message and returns
	null.
	 */
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}
	/*The method displayMenuOptions takes an array of objects as an
	argument and displays the options to the user. It loops through
	the options array and prints each option with a number
	preceding it. It then prompts the user to make a choice.
	 */
	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println("**************************************");
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
}
