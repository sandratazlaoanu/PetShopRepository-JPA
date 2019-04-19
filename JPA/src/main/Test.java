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
		
		MenuClass ob = new MenuClass();
		ob.menu();

	}

}
