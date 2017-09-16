package bcccp.tickets.season;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.IUsageRecordFactory;
import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

public class SeasonTicketDAOTest {
    
	//Create a Map list for storing tickets	
	Map<String, ISeasonTicket> currentTickets = new HashMap<>();
	
	@Test
	public void testSeasonTicketDAOMethods() {
        
		
		//Creating a ticket object for testing
		ISeasonTicket ticket1 = new SeasonTicket("S7777", "Bathurst Chase", System.currentTimeMillis(), 
				0L); 
		//creating another ticket object for testing
		ISeasonTicket ticket2 = new SeasonTicket("S8888", "Bathurst Chase", System.currentTimeMillis(), 
				0L); 
		//Register the first ticket.
		registerTicket(ticket1);
		//Register the Second Ticket.
		registerTicket(ticket2);
		
		
		//create an instance of SeasonTicketDAO class.
		SeasonTicketDAO test1 = new SeasonTicketDAO(new UsageRecordFactory());
		
		/*call registerTicket method of SeasonTicketDAO class and register ticket1
		test1.registerTicket(ticket1);
		
		//check if ticket is registered 
		//assertTrue(test1.currentTickets.containsKey(ticket1.getId()) );
		
		//check if the ticket values match for register ticket method. 
		//assertTrue(currentTickets.get(ticket1.getId()) == test1.currentTickets.get(ticket1.getId()) );
		
		
		//Check deregisterTicket method
		// Deregister ticket1 
		test1.deregisterTicket(ticket1);
		deregisterTicket(ticket1);
		
		//Check if method works by checking if ticket1 is no longer present in currentTickets
		//assertTrue(!test1.currentTickets.containsKey(ticket1.getId()) );
		*/
		
		//Create 3 more tickets 
		ISeasonTicket ticket3 = new SeasonTicket("S9999", "Sydney", System.currentTimeMillis(), 
				0L);
	  
		ISeasonTicket ticket4 = new SeasonTicket("S1111", "Melbourne", System.currentTimeMillis(), 
				0L);
		
		ISeasonTicket ticket5 = new SeasonTicket("S2222", "Brisbane", System.currentTimeMillis(), 
				0L);
		
		//register the newly created tickets
	
		
		test1.registerTicket(ticket1);
		test1.registerTicket(ticket2);
		test1.registerTicket(ticket3);
		test1.registerTicket(ticket4);
		test1.registerTicket(ticket5);
		
		//Check getNumberOfTickets method.
		//should contain 5 tickets that have been added.
		//assertTrue(test1.getNumberOfTickets() == 5);
		
		/*check findTicketById method
		ISeasonTicket testTicket = test1.findTicketById("S2222");
		System.out.println(testTicket);
		
		ISeasonTicket testTicket2 = test1.findTicketById("S9999");
		System.out.println(testTicket2);
		
		ISeasonTicket testTicket3 = test1.findTicketById("S0000");
		System.out.println(testTicket3);
		*/
		
		//Test record entry method.
		test1.recordTicketEntry(ticket3.getId());
		
		//See if ticket3's usage has been recorded.
		System.out.println(ticket3);
		
		//printing the HashMap to see if the values were actually registered/deregistered.
		//System.out.println(Arrays.asList(currentTickets)); // method 1
	}
	
	
	
	//Method to register ticket in the Map list. 
	public void registerTicket(ISeasonTicket ticket) {
		if (!currentTickets.containsKey(ticket.getId())) {
			currentTickets.put(ticket.getId(),ticket);
		}
	}

	//method to de register ticket in the Map list
	public void deregisterTicket(ISeasonTicket ticket) {
		if (currentTickets.containsKey(ticket.getId())) {
			currentTickets.remove(ticket.getId());
		}
	}
}
