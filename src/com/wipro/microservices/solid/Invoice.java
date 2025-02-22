package com.wipro.microservices.solid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Invoice {
    book book;              
    int quantity;           
    double discountRate;    
    double taxRate;         
    double total;           

    
    public Invoice(book book, int quantity, double discountRate, double taxRate) {
        this.book = book;              
        this.quantity = quantity;      
        this.discountRate = discountRate;  
        this.taxRate = taxRate;        
        this.total = this.calculateTotal();  
    }

    
    public double calculateTotal() {
        
        double priceAfterDiscount = (book.price - (book.price * discountRate)) * this.quantity;
        
        
        double priceWithTaxes = priceAfterDiscount * (1 + taxRate);
        
        return priceWithTaxes;  
    }

    
    public void printInvoice() {
        
        System.out.println(quantity + "x " + book.name + " by " + book.price);
        System.out.println("Discount Rate: " + discountRate  );
        System.out.println("Tax Rate: " + taxRate );
        System.out.println("Total: $" + total);
    }

    
    public void saveToFile(String filename) {
    	
    	try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            
            
            writer.write("Invoice Details:\n");
            writer.write("Book: " + book.name + "\n");
            writer.write("Author: " + book.authorName + "\n");
            writer.write("Quantity: " + quantity + "\n");
            writer.write("Discount Rate: " + (discountRate * 100) + "%\n");
            writer.write("Tax Rate: " + (taxRate * 100) + "%\n");
            writer.write("Total: $" + total + "\n");

            
            writer.close();
            System.out.println("Invoice saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
        
}


