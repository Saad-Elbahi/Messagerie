package ma.projet.test;

import java.sql.Date;

import Services.EmployeService;
import Services.MessageService;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;

public class Messagerie {
	public static void main(String[] args) {
		EmployeService es = new EmployeService();
		// Création des employes
		es.create(new Employe("LACHGAR", "Mohamed"));
		es.create(new Employe("RAMI", "ALI"));
		es.create(new Employe("SAFI", "Fatima"));

		// Modification d'un employe
		Employe e = es.getById(3);
		if (e != null) {
			e.setNom("ALAOUI");
			e.setPrenom("Manale");
			es.update(e);
		}

		// Suppression d'un employe
		es.delete(es.getById(4));

		// Liste des employes
		for (Employe emp : es.getAll())
			System.out.println("" + emp.getNom());

		EmployeService es1 = new EmployeService();
		MessageService ms = new MessageService();
		ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(0), es1.getById(1), es1.getById(2)));
		ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(0), es1.getById(1), es1.getById(3)));
		ms.create(new Message("Stage", "Stage à Marrakech", new Date(0), es1.getById(2), es1.getById(1)));
		ms.create(new Message("Stage", "Stage à Marrakech", new Date(0), es1.getById(2), es1.getById(3)));
        //Les message reçus par l'employé 3
		for (Message m : ms.getAll()) {
			if (m.getEmpRecepteur().getId() == 3)
				System.out.println("" + m.getSujet());

		}

	}

}
