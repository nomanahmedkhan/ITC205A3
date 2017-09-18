/*This class is created By Noman Ahmed Khan to test the integration of all the 4 classes within the
season ticket package. The 4 classes include SeasonTicket, SeasonTicketDAO
UsageRecord and UsageRecordFactory. */

package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;



public class IntegrationTesting {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
       
		//Initiate the entity class
		
		ISeasonTicket firstTicket = new SeasonTicket ("S1234", "Church Lane", System.currentTimeMillis(), 0L);
		
		//print firstTicket startValidPeriod
		//System.out.println("The start Valid Period for Ticket is: " + firstTicket.getStartValidPeriod());
		
		//SeasonTicket secondTicket = new SeasonTicket ("S4567", "Church Lane", System.currentTimeMillis(), 0L);
		
		//Test whether the entity class was initiated
		//System.out.println(firstTicket);
		
		/*Test Whether Entity Class SeasonTicket is Integrated with 
		 * Service Class UsageRecord. 
		  
		 */
		//integrateWithUsageRecord(firstTicket);
		
	    /* Test whether the entity class can integrate with
	     * its Data Access Object class SeasonTicketDAO
	     */
		integrateWithSeasonTicketDAO();
	}
	
	//Method takes an entity class parameter and then passes it onto Service class
	// It checks whether the service class works correctly with entity class
	public static void integrateWithUsageRecord(ISeasonTicket ticket){
		
		UsageRecord testVariable1 = new UsageRecord(ticket.getId(),ticket.getStartValidPeriod());
		
        System.out.println("\nThe recorded usage for ticket is before ending usage: \n" + testVariable1);
       
		ticket.recordUsage(testVariable1);
		
		/*boolean isTicketInUse = ticket.inUse();
		
		if(isTicketInUse == true){
			System.out.println("UsageRecord worked, Ticket is currently in Use " +
					"The Details are as follows\n" + ticket);
		}
		else if(isTicketInUse == false){
		    System.out.println("UsageRecord worked, Ticket is not in Use");
		}
		else{
			System.out.println("UsageRecord did not work");
		}*/
		
       ticket.endUsage(System.currentTimeMillis());
		
		System.out.println("\nThe details recorded within UsageRecord class after ending usage: \n" + testVariable1);
		System.out.println("");
		System.out.println("The details recorded within SeasonTicket class after ending usage: \n" + ticket);
		
	}
	
	public static void integrateWithSeasonTicketDAO(){
		IUsageRecordFactory factory = new UsageRecordFactory();
		SeasonTicketDAO sTicketDAO = new SeasonTicketDAO(factory);
		
	}

}
