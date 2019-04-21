package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

import controller.AdresaController;
import controller.BonFiscalController;
import controller.ClientController;

public class MenuClass {

	public void menu() throws NumberFormatException, IOException, SQLException {

		AdresaController adresaController = new AdresaController();
		BonFiscalController bfController = new BonFiscalController();
		ClientController clientController = new ClientController();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("---Optiuni principale---");
			System.out.println("1. CRUD adresa.");
			System.out.println("2. CRUD client.");
			System.out.println("3. CRUD bon fiscal.");
			System.out.println("4. Exemple JOIN.");

			int option = Integer.parseInt(reader.readLine());
			switch (option) {

			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.println("Alegeti o optiune: ");
				System.out.println("1.Add.");
				System.out.println("2.Update.");
				System.out.println("3.Delete.");
				System.out.println("4.Print.");

				int optAdresa = Integer.parseInt(reader.readLine());
				switch (optAdresa) {

				case 0:
					break;
				case 1:
					System.out.println("Zip: ");
					int zip = Integer.parseInt(reader.readLine());
					System.out.println("Judet: ");
					String judet = reader.readLine();
					System.out.println("Oras: ");
					String oras = reader.readLine();
					System.out.println("Strada: ");
					String strada = reader.readLine();
					System.out.println("Numar: ");
					int numar = Integer.parseInt(reader.readLine());
					adresaController.create(zip, judet, oras, strada, numar);
					break;
				case 2:
					System.out.println("Datele: ");

					System.out.println("Zip: ");
					int zipToUpdate = Integer.parseInt(reader.readLine());
					System.out.println("Judet: ");
					String judetToUpdate = reader.readLine();
					System.out.println("Oras: ");
					String orasToUpdate = reader.readLine();
					System.out.println("Strada: ");
					String stradaToUpdate = reader.readLine();
					System.out.println("Numar: ");
					int numarToUpdate = Integer.parseInt(reader.readLine());
					adresaController.update(zipToUpdate, judetToUpdate, orasToUpdate, stradaToUpdate, numarToUpdate);
					break;

				case 3:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int zipToDelete = Integer.parseInt(reader.readLine());
					adresaController.delete(zipToDelete);
					break;
				case 4:
					adresaController.printList();
				}

				break;
			case 2:
				System.out.println("Alegeti o optiune: ");
				System.out.println("1.Add.");
				System.out.println("2.Update.");
				System.out.println("3.Delete.");
				System.out.println("4.Print.");
				int optClient = Integer.parseInt(reader.readLine());
				switch (optClient) {

				case 0:
					break;
				case 1:
					System.out.println("Id: ");
					int idClient = Integer.parseInt(reader.readLine());
					System.out.println("Nume: ");
					String numeClient = reader.readLine();
					System.out.println("Prenume: ");
					String prenumeClient = reader.readLine();
					System.out.println("Pet Shop: ");
					int idPetShopClient = Integer.parseInt(reader.readLine());

					clientController.create(idClient, numeClient, prenumeClient, idPetShopClient);

					System.out.println("Doriti sa setati si un bon fiscal? ");
					String chooseBonFiscal = reader.readLine();
					switch (chooseBonFiscal) {

					case "Nu":
						break;
					case "Da":
						System.out.println("Id bon fiscal: ");
						int idBonFiscal = Integer.parseInt(reader.readLine());
						System.out.println("Data: ");
						Date data = Date.valueOf(reader.readLine());
						System.out.println("Suma: ");
						float suma = Float.parseFloat(reader.readLine());
						bfController.create(idBonFiscal, data, suma, idClient);
						break;
					}
					break;
				case 2:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int idClientToUpdate = Integer.parseInt(reader.readLine());
					System.out.println("Nume: ");
					String numeNouClient = reader.readLine();
					System.out.println("Prenume: ");
					String prenumeNouClient = reader.readLine();
					clientController.update(idClientToUpdate, numeNouClient, prenumeNouClient);
					break;

				case 3:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int idClientToDelete = Integer.parseInt(reader.readLine());
					clientController.delete(idClientToDelete);
					break;

				case 4:
					clientController.printList();
				}

				break;
			case 3:
				System.out.println("Alegeti o optiune: ");
				System.out.println("1.Add.");
				System.out.println("2.Update.");
				System.out.println("3.Delete.");
				System.out.println("4.Print.");

				int optBonFiscal = Integer.parseInt(reader.readLine());
				switch (optBonFiscal) {

				case 0:
					break;
				case 1:
					System.out.println("Id bon fiscal: ");
					int idBonFiscal = Integer.parseInt(reader.readLine());
					System.out.println("Data: ");
					Date data = Date.valueOf(reader.readLine());
					System.out.println("Suma: ");
					float suma = Float.parseFloat(reader.readLine());
					System.out.println("Alegeti un client: ");
					int idClient = Integer.parseInt(reader.readLine());
					bfController.create(idBonFiscal, data, suma, idClient);
					break;
				case 2:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int idBonFiscalToUpdate = Integer.parseInt(reader.readLine());
					System.out.println("Data: ");
					Date dataToUpdate = Date.valueOf(reader.readLine());
					System.out.println("Suma: ");
					Float sumaToUpdate = Float.parseFloat(reader.readLine());
					bfController.update(idBonFiscalToUpdate, dataToUpdate, sumaToUpdate);
					break;

				case 3:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int idBonFiscalToDelete = Integer.parseInt(reader.readLine());
					bfController.delete(idBonFiscalToDelete);
					break;
				case 4:
					bfController.printList();
				}
				break;
			}
		}

	}
}
