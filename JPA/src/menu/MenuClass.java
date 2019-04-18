package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

import controller.AngajatController;
import controller.AngajatDepartamentController;
import controller.BonFiscalController;
import controller.ClientController;
import controller.DepartamentController;
import controller.PetShopController;

public class MenuClass {

	public void menu() throws NumberFormatException, IOException, SQLException {

		AngajatController angajatController = new AngajatController();
		AngajatDepartamentController adController = new AngajatDepartamentController();
		BonFiscalController bfController = new BonFiscalController();
		ClientController clientController = new ClientController();
		DepartamentController departamentController = new DepartamentController();
		PetShopController controller = new PetShopController();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("---Optiuni principale---");
			System.out.println("1. CRUD angajat.");
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
				int optAngajat = Integer.parseInt(reader.readLine());
				switch (optAngajat) {

				case 0:
					break;
				case 1:
					System.out.println("Id: ");
					int idAngajat = Integer.parseInt(reader.readLine());
					System.out.println("Nume: ");
					String numeAngajat = reader.readLine();
					System.out.println("Prenume: ");
					String prenumeAngajat = reader.readLine();
					System.out.println("Pet Shop: ");
					int idPetShopAngajat = Integer.parseInt(reader.readLine());
					System.out.println("Salariu: ");
					Float salariuAngajat = Float.parseFloat(reader.readLine());
					angajatController.create(idAngajat, numeAngajat, prenumeAngajat, salariuAngajat, idPetShopAngajat);

					System.out.println("Doriti sa setati si un departament? ");
					String chooseDepartament = reader.readLine();
					switch (chooseDepartament) {

					case "Nu":
						break;
					case "Da":
						System.out.println("Id departament: ");
						int idDepartament = Integer.parseInt(reader.readLine());
						System.out.println("Denumire: ");
						String denumire = reader.readLine();
						System.out.println("Numar raioane alocate: ");
						int numarRaioane = Integer.parseInt(reader.readLine());
						departamentController.create(idDepartament, denumire, numarRaioane);
						break;
					}
					break;
				case 2:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int idAngajatToUpdate = Integer.parseInt(reader.readLine());
					System.out.println("Nume: ");
					String numeNouAngajat = reader.readLine();
					System.out.println("Prenume: ");
					String prenumeNouAngajat = reader.readLine();
					System.out.println("Salariu: ");
					Float salariuNouAngajat = Float.parseFloat(reader.readLine());
					angajatController.update(idAngajatToUpdate, numeNouAngajat, prenumeNouAngajat, salariuNouAngajat);
					break;

				case 3:
					System.out.println("Datele: ");
					System.out.println("Id: ");
					int idAngajatToDelete = Integer.parseInt(reader.readLine());
					angajatController.delete(idAngajatToDelete);
					break;
				}

				break;
			case 2:
				System.out.println("Alegeti o optiune: ");
				System.out.println("1.Add.");
				System.out.println("2.Update.");
				System.out.println("3.Delete.");
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
				}

				break;
			case 3:
				System.out.println("Alegeti o optiune: ");
				System.out.println("1.Add.");
				System.out.println("2.Update.");
				System.out.println("3.Delete.");
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
				}
				break;
			}
		}
		
	}
}
