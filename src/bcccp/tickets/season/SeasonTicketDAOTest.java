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
		
		//printing the HashMap to see if the values were actually registered.
		System.out.println(Arrays.asList(currentTickets)); // method 1
	}
	
	
	
	//Method to register ticket in the Map list. 
	public void registerTicket(ISeasonTicket ticket) {
		if (!currentTickets.containsKey(ticket.getId())) {
			currentTickets.put(ticket.getId(),ticket);
		}
	}

}
