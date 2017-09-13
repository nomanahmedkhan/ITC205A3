package bcccp.tickets.season;

import java.util.List;

import junit.framework.TestCase;
import org.junit.*;


public class SeasonTicketTest extends TestCase {
	
	//unit testing for SeasonTicket class by noman
	
	@Test 
	
	 public void testSeasonTicketMethods(){
		
		
		String ticketId = "S5555"; 
		String carparkId = "Bathurst Chase";
		long startValidPeriod = 1505220596574L;
		long endValidPeriod = 1505223221078L;
		
		SeasonTicket seasonTicket1 = new SeasonTicket (ticketId, carparkId, startValidPeriod, endValidPeriod);
		
		//Methods to check that the class is being initiated with assigned values
		assertTrue(seasonTicket1.getId() == getId(ticketId));
	     
		
	}
	
	
      public String getId(String ticketId) {
		return ticketId;
	}
	

	
}
