package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.AdresaController;
import daoImpl.AdresaDao;
import helper.DatabaseHelper;
import menu.MenuClass;
import model.Adresa;

public class Test {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
/*		AdresaController adr = new AdresaController();
		//adr.create(2, "Brasov", "Brasov", "Soarelui", 12);
		//adr.update(2, "Sibiu", "Sibiu", "Verii", 14);
		adr.delete(2);
		adr.printList();*/
		
		MenuClass ob = new MenuClass();
		ob.menu();

	}

}
