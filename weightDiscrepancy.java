//Daniel Adebisi UCID: 30179418
//Adrian Aure UCID: 30164498
//Nathaniel D'Orazio UCID: 30118713
//Arian Popal UCID: 30189384
//Zhenhui Ren UCID: 30139966
package com.thelocalmarketplace.software;

import com.jjjwelectronics.scale.ElectronicScale;
import java.math.BigDecimal;
import java.util.Scanner;

BigDecimal currentWeight = electronicScale.getCurrentMassOnTheScale().inGrams();
BigDecimal expectedWeight = BigDecimal.valueOf(product.getExpectedWeight());

public class weightDiscrepancy{
  
	public int attandentPin;
  public boolean blockSystem;
	public boolean customerSelectsDoNotBagItem;
	
	public notifyCustomer() {
    system.out.println("Weight discrepancy detected. Please check the item and try again.")
	}
  
	public notifyAttendant() {
		
	}
  
  public boolean attendantOverride() {
    Scanner Sc = new Scanner(System.in);
		if(blockSystem == true){
        system.out.println("Please enter attendant pin");
        Pin = myObj.nextInt(); 
          if(attandentPin == Pin){
            return true;
          }else{
            system.out.println("Pin Incorrect, please enter correct pin");
            attendantOverride();
          }      
      }
    
	public weightDiscrepancy() {
		blockSystem = true;
		
		notifyCustomer();
		notifyAttendant();
		
		if(currentWeight.equals(expectedWeight)) {
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
