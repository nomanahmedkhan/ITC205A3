package bcccp.tickets.season;

import java.util.ArrayList;
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
		
		//Methods to check that the object is being initiated with assigned values
		assertTrue(seasonTicket1.getId() == getId(ticketId));
		assertTrue(seasonTicket1.getCarparkId() == getCarparkId(carparkId));
		assertTrue(seasonTicket1.getStartValidPeriod() == getStartValidPeriod(startValidPeriod));
		assertTrue(seasonTicket1.getEndValidPeriod() == getEndValidPeriod(endValidPeriod));
		
		
		
	}
	  //Returns ticketId
      public String getId(String ticketId) {
		
    	  return ticketId;
	}
	
  	//Returns carparkId
  	public String getCarparkId(String carparkId) {
  		return carparkId;
  	}


  	//Returns valid start period
  	public long getStartValidPeriod(Long startValidPeriod) {
  		return startValidPeriod;
  	}


  	//Returns valid end period
  	public long getEndValidPeriod(Long endValidPeriod) {
  		return endValidPeriod;
  	}


	
}
