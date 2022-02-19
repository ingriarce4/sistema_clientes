package main;

import vista.Menu;

import vista.MenuTemplate;

// the class that join all functions and class
//5.- Create Main with static void method in the main package
//which will use an instance to start the menu
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuTemplate menu = new Menu();
		menu.iniciarMenu();
	}

}
