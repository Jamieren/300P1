
public class startSession {

public boolean sessionInProgress;
	
	//method to simulate a customer touching the screen
	void customerTouchesScreen() {
		sessionInProgress = true;
	}
	
	public startSession(boolean sessionInProgress) {	
	
	if (sessionInProgress == true) {
		System.out.println("Session Already in Progress");
		return;
	}
	else {
		System.out.println("Touch Anywhere to Start");	
	}
	
	customerTouchesScreen()
	
	//add that the system is ready for further customer interaction
	
	}
	
}

