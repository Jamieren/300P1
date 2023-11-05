package com.thelocalmarketplace.software;

import com.jjjwelectronics.scale.ElectronicScale;
import java.math.BigDecimal;

BigDecimal currentWeight = electronicScale.getCurrentMassOnTheScale().inGrams();
BigDecimal expectedWeight = BigDecimal.valueOf(product.getExpectedWeight());

public class weightDiscrepancy{
  
	public boolean blockSystem;
	public boolean attendantOverride;
	public boolean customerSelectsDoNotBagItem;
	
	public notifyCustomer() {
		
	}
	public notifyAttendant() {
		
	}
	
	public weightDiscrepancy() {
		blockSystem = true;
		
		notifyCustomer();
		notifyAttendant();
		
		if(currentWeight == expectedWeight) {
			blockSystem = false;
		}
		else if(attendantOverride == true) {
			blockSystem = false;
		}
		else if(customerSelectsDoNotBagItem == true) {
			blockSystem = false;
		}
		else {
			blockSystem = true;
		}
		
	}
}
