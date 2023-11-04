package com.thelocalmarketplace.software;

import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.scale.ElectronicScale;

import java.math.BigDecimal;

import com.jjjwelectronics.OverloadedDevice;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.external.ProductDatabases;

public class addItem {

    private ElectronicScale electronicScale;

    public addItem(ElectronicScale electronicScale) {
        this.electronicScale = electronicScale;
    }


 public void addItemViaBarcodeScanner(Barcode barcode) {
     try {
         if (ProductDatabases.BARCODED_PRODUCT_DATABASE.containsKey(barcode)) {
             BarcodedProduct product = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(barcode);

             try {
                 BigDecimal currentWeight = electronicScale.getCurrentMassOnTheScale().inGrams();
                 BigDecimal expectedWeight = BigDecimal.valueOf(product.getExpectedWeight());

                 if (currentWeight.compareTo(expectedWeight) >= 0) {
                     // Update inventory and other necessary actions here
                 } else {
                     System.out.println("Weight discrepancy detected. Please check the item and try again.");
                 }
             } catch (OverloadedDevice e) {
                 System.out.println("Error: The scale is overloaded. Please remove some items and try again.");
             }
         } else {
             System.out.println("Error: Barcode not found in the database.");
         }
     } catch (Exception e) {
         System.out.println("An unexpected error occurred: " + e.getMessage());
     }
 }

}
