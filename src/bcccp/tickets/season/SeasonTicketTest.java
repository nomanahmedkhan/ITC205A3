package bcccp.tickets.season;

import java.util.List;

import junit.framework.TestCase;

public class SeasonTicketTest extends TestCase {

	@Test
	//unit testing for SeasonTicket class by noman
	public void testSeasonTicketMethods(){
		List<IUsageRecord> usages;
		IUsageRecord currentUsage = null;
		
		String ticketId = "S5555"; 
		String carparkId = "Bathurst Chase";
		long startValidPeriod = 1505220596574L;
		long endValidPeriod = 1505223221078L;
		
		SeasonTicket seasonTicket1 = new SeasonTicket (ticketId, carparkId, startValidPeriod, endValidPeriod);
		
	     
		
	}
	
	
}
