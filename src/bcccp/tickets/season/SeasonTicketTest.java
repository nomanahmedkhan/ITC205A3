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
		
		//Check whether UsageRecord and inUse method works.
		 seasonTicket1.recordUsage(new UsageRecord(seasonTicket1.getId(), seasonTicket1.getStartValidPeriod()));
		 
		 
		 assertTrue(seasonTicket1.inUse());
		 
		 //create new object with random values and record usage
		 SeasonTicket seasonTicket2 = new SeasonTicket ("S6666", "Bathurs Chase",1505220598689L,1505223288889L);
		 seasonTicket2.recordUsage(new UsageRecord(seasonTicket2.getId(), seasonTicket2.getStartValidPeriod()));
		 
		
		 //Check endUsage method and print both objects information with toString
		 
		 seasonTicket1.endUsage(seasonTicket1.getEndValidPeriod());
		 seasonTicket2.endUsage(seasonTicket2.getEndValidPeriod());
		 
		 
		 
		 //Check whether endUsage Method worked with inUse method
		 //if endUsage worked, both tickets will no longer be in use
		 // inUse method will return false
		 
		 assertTrue(!seasonTicket1.inUse());
		 assertTrue(!seasonTicket2.inUse());
		 
		 
		 
		 //record new usage for seasonTicket1
		 seasonTicket1.recordUsage(new UsageRecord(seasonTicket1.getId(),1505223221078L ));
		 seasonTicket1.endUsage(1505223288889L);
		 
		 //List all the usage records of seasonTicket1
		 List list = seasonTicket1.getUsageRecords();
		 
		 for(int i = 0; i < list.size(); i++){
			 System.out.println(list.get(i));
		 }
		 
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
