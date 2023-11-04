import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.thelocalmarketplace.software.startSession;

public class startSessionTest() {

	private startSession session;
  
    	@Before 
    	public void setUp() {

		// Initializes a startSession object before  each test
        	session = new startSession(false);    
   
    	 }

	@Test 
	public void testSessionNotInProgress() {

		// Verify a session is not in Progress by default
		assertFalse(session.sessionInProgress)

   	 }  

	@Test
	public void testStartSessionTouch() {

		// Stimulates a customer touching the screen
		session.customerTouchesScreen();

		// Verifies if session is in progress
		assertTrue(session.sessionInProgress);
      
   	 }
	
	@Test 
	public void testStartSessionAlreadyInProgress() {

		// Stimulates a customer touching the screen and verifying if its running
		session.customerTouchesScreen();
		assertTrue(session.sessionInProgress);

		// Starts a new session in the middle of a session
        	startSession newSession = new startSession(true);

		// Verifies the session did not start again
        	assertFalse(newSession.sessionInProgress);

   	 }
}
