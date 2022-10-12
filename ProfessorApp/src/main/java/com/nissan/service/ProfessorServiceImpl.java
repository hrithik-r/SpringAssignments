package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.CrudRepositoryImpl;
import com.nissan.repo.ICrudRepository;

public class ProfessorServiceImpl {
	// Constructor Injection
	// Repository layer
	ICrudRepository crud = new CrudRepositoryImpl();
	
	Scanner input = new Scanner(System.in);
	char choice = 'n';
	// Default Constructor -- constructor injection (DI)
	public ProfessorServiceImpl() {
	}
	
	// Menu driven
	public void menuDriven() {
		do {
			// Show choice
			System.out.println("1. Add professor\n2. List all professors"
					+ "\n3. Edit professor\n4. Delete professor\n5. Search professor\n6. Exit");
			System.out.println("Enter your choice: ");
			int option = input.nextInt();
			switch(option) {
			case 1:
				crud.insertEntity();
				break;
			case 2:
				crud.listEntity();
				break;
			case 3:
				crud.editEntity();
				break;
			case 4:
				crud.deleteEntity();
				break;
			case 5:
				System.out.println("Enter name: ");
				String name = input.nextLine();
				crud.searchEntity(name);
				break;
			case 6:
				System.exit(0);
			}
			System.out.println("Do you want to continue(y/n): ");
			choice = input.next().charAt(0);
		} while(choice == 'y' || choice == 'Y');
	}
}
