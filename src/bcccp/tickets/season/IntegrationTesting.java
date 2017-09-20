/*This class is created By Noman Ahmed Khan to test the integration of all the 4 classes within the
season ticket package. The 4 classes include SeasonTicket, SeasonTicketDAO
UsageRecord and UsageRecordFactory. */

package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;



public class IntegrationTesting {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
       
		//Initiate the entity class
		
		//SeasonTicket firstTicket = new SeasonTicket ("S4567", "Church Lane", System.currentTimeMillis(), 0L);
		
		//Test whether the entity class was initiated
		//System.out.println("Entity Class initiated with ticket below: \n");
		//System.out.println(firstTicket);
		
		
		
		/*Test Whether Entity Class SeasonTicket is Integrated with 
		 * Service Class UsageRecord. 
		  
		 */
		//integrateWithUsageRecord();
	
		
		
	    /* Test whether the entity class can integrate with
	     * its Data Access Object class SeasonTicketDAO
	     */
		//integrateWithSeasonTicketDAO();
		
		integrateWithAllFourClasses();
	}
	
	
	
	
	
	
	
	
	
	//Method checks integration of Entity class SeasonTicket
	//with service class UsageRecord
	// It checks whether the service class works correctly with entity class
	public static void integrateWithUsageRecord(){
		System.out.println("Integration Testing with UsageRecord class \n");
		
		ISeasonTicket ticket = new SeasonTicket ("S1234", "Church Lane", System.currentTimeMillis(), 0L);
		//print firstTicket startValidPeriod
		System.out.println("The start Valid Period for Ticket is: " + ticket.getStartValidPeriod());
		
		UsageRecord testVariable1 = new UsageRecord(ticket.getId(),ticket.getStartValidPeriod());
		
        System.out.println("\nThe recorded usage for ticket is before ending usage: \n" + testVariable1);
       
		ticket.recordUsage(testVariable1);
		
		boolean isTicketInUse = ticket.inUse();
		
		if(isTicketInUse == true){
			System.out.println("UsageRecord worked, Ticket is currently in Use " +
					"The Details are as follows\n" + ticket);
		}
		else if(isTicketInUse == false){
		    System.out.println("UsageRecord worked, Ticket is not in Use");
		}
		else{
			System.out.println("UsageRecord did not work");
		}
		
       ticket.endUsage(System.currentTimeMillis());
		
		System.out.println("\nThe details recorded within UsageRecord class after ending usage: \n" + testVariable1);
		System.out.println("");
		System.out.println("The details recorded within SeasonTicket class after ending usage: \n" + ticket);
		
	}
	
	
	
	
	
	//Method checks integration of Entity class SeasonTicket
	//with service class SeasonTicketDAO
	// It checks whether the service class works correctly with entity class
	public static void integrateWithSeasonTicketDAO(){
		System.out.println("Integration Testing with SeasonTicketDAO class \n");
		IUsageRecordFactory factory = new UsageRecordFactory();
		SeasonTicketDAO sTicketDAO = new SeasonTicketDAO(factory);
		ISeasonTicket t1 = new SeasonTicket ("S1111", "Church Lane", System.currentTimeMillis(), 0L);
		ISeasonTicket t2 = new SeasonTicket ("S2222", "Church Lane", System.currentTimeMillis(), 0L);
		ISeasonTicket t3 = new SeasonTicket ("S3333", "Melbourne CBD", System.currentTimeMillis(), 0L);
		ISeasonTicket t4 = new SeasonTicket ("S4444", "Sydney CBD", System.currentTimeMillis(), 0L);
		ISeasonTicket t5 = new SeasonTicket ("S5555", "Brisbane CBD", System.currentTimeMillis(), 0L);
		
		//test SeasonTicketDAO's registerTicket method with the SeasonTickets created.
		sTicketDAO.registerTicket(t1);
		sTicketDAO.registerTicket(t2);
		sTicketDAO.registerTicket(t3);
		sTicketDAO.registerTicket(t4);
		sTicketDAO.registerTicket(t5);
		
		
		//test getNumberOfTickets method by displaying how many tickets are
		//registered
		System.out.println("\nThe number of tickets registered are: \n" 
		+ sTicketDAO.getNumberOfTickets());
		
		//print the currentTickets Map where the tickets are stored to
		//whether the tickets were registered or not.
		System.out.println("The Five Registered Tickets are Below: \n");
		System.out.println(Arrays.asList(sTicketDAO.currentTickets));
	
		//test SeasonTicketDAO's deregisterTicket method.
		sTicketDAO.deregisterTicket(t1);
		sTicketDAO.deregisterTicket(t5);
		
		
		//confirm getNumberOfTickets method by displaying how many tickets are
		//left after using deregister method
		System.out.println("\nThe number of tickets left registered are: \n" 
				+ sTicketDAO.getNumberOfTickets());
				
		
		//print the currentTickets Map where the tickets are stored to
		//whether the tickets were deregistered or not.
		System.out.println("\nThe Two Registered Tickets S1111 and S5555 have been removed: \n");
		System.out.println(Arrays.asList(sTicketDAO.currentTickets));
		
		//Test method findTicketById
		System.out.println("\nThe ticket with id S2222 should be displayed below\n");
		System.out.println(sTicketDAO.findTicketById("S2222"));
	}
	
	
	/*This method is called to test integration of all four classes of
	 * Season Tickets Package
	 * SeasonTicket (Entity) SeasonTicketDAO(Service) UsageRecord(Service)
	 * UsageRecordFactory (Service) with the class IntegrationTesting (Controller) 
	 */
	 public static void integrateWithAllFourClasses(){
		 System.out.println("Integration Testing with All the classes within Season Tickets package \n");
			//initiate classes for testing
		    IUsageRecordFactory factory = new UsageRecordFactory();
			SeasonTicketDAO sTicketDAO = new SeasonTicketDAO(factory);
			
			//create tickets to test with all classes within SeasonTicket class
			ISeasonTicket t1 = new SeasonTicket ("S1111", "Church Lane", System.currentTimeMillis(), 0L);
			ISeasonTicket t2 = new SeasonTicket ("S2222", "Church Lane", System.currentTimeMillis(), 0L);
			ISeasonTicket t3 = new SeasonTicket ("S3333", "Melbourne CBD", System.currentTimeMillis(), 0L);
			ISeasonTicket t4 = new SeasonTicket ("S4444", "Sydney CBD", System.currentTimeMillis(), 0L);
			ISeasonTicket t5 = new SeasonTicket ("S5555", "Brisbane CBD", System.currentTimeMillis(), 0L);
			
			//register tickets with SeasonTicketDAO class
			sTicketDAO.registerTicket(t1);
			sTicketDAO.registerTicket(t2);
			sTicketDAO.registerTicket(t3);
			sTicketDAO.registerTicket(t4);
			sTicketDAO.registerTicket(t5);
			
			//record ticket entry which will further use UsageRecord and UsageRecordFactory
			//classes. This will ensure that all four classes are working together perfectly,
			//passing arguments and receiving parameters correctly.
			sTicketDAO.recordTicketEntry(t1.getId());
			sTicketDAO.recordTicketEntry(t2.getId());
			sTicketDAO.recordTicketEntry(t3.getId());
			sTicketDAO.recordTicketEntry(t4.getId());
			sTicketDAO.recordTicketEntry(t5.getId());
			
			System.out.println(t1);
			System.out.println(t2);
			System.out.println(t3);
			System.out.println(t4);
			System.out.println(t5);
	 }

}

