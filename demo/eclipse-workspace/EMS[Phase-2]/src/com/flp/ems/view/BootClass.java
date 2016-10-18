package com.flp.ems.view;

import java.util.Scanner;
import static com.flp.ems.view.UserInteraction.*;

 public class BootClass {
private static Scanner scan;
	
	public static void main(String[] args){
		
		scan=new Scanner(System.in);
		
		System.out.println("Welcome to Employee Management System");
		menuSelection();
		
		
		
	}

	private static void menuSelection() {
		
		int option=0;
		do{
		
			System.out.println("Please Select an option:.\n1.Create an Employee\n2.Modify an Employee\n3.Remove an Employee\n4.Search an Employee\n5.Display All Employee\n6. Exit");
			option=scan.nextInt();
			
			switch(option){
			
					case 1:
						addEmployee();
						break;
					
					case 2:
						modifyEmployee();
						break;
						
					case 3:
						removeEmployee();
						break;
						
					case 4:
						searchEmployee();
						break;
						
					case 5:
						getAllEmployee();
						break;
						
					case 6:
						System.out.println("Thank you for using EMS");
						break;
	
			}	
				
		}while(option!=6);
	
		
		
	}
	
}
