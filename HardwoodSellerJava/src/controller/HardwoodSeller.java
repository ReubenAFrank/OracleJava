/**
 * 
 */
//package controller;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

        
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{//file input data
            Scanner temp = new Scanner(System.in);
            System.out.println("Please enter the name of the file:"
                        + "\n>>");
            
            readInputFile(temp.nextLine());
            
            temp.close();
	}
	
	public static void readInputFile(String inputFilePath){
                Scanner in;
                String buyerName, addr, woodType;
                //date not needed to print out
                double amount, deliTime =0.0, totalPrice =0.0;
                                
		try{in = new Scanner(new File(inputFilePath));}
                
                catch(IOException i){
			System.out.println("Incorrectly input filename/"
                                + "formatted file");
			System.out.println("Could not open");
			return;
		}//error handling over
		
                
                if(in.hasNext()){//while there are more input tokens
                    buyerName = in.next();addr = in.next();in.next();//skip date
                    in.next(); //gets rid of date
                    System.out.println(buyerName);System.out.println(addr);
                    
                    while(in.hasNext()){//get type and amount repeatedly
                        woodType = in.next();amount = in.nextInt();
                        
                        System.out.println(woodType);
                        System.out.println(amount);
                        WoodItem w = new WoodItem(woodType,
                                getBaseDeliveryTime(woodType),
                        getPrice(woodType));
                        
                        //add this wood's cost to totalPrice
                        totalPrice +=w.getPrice()*amount;
                        //set deliTime to the max of itself and deliveryTime for this 
                        //amount of wood w
                        deliTime = Math.max(deliTime, deliveryTime(amount, w));
                        
                        System.out.println(w.getType()+" | BF:"+amount+" | Price:"
                                + (w.getPrice()*amount) + ", ");
                        
                        
                    }//adding each new type to woodItems
                    System.out.println("ETA:"+deliTime);
                    System.out.println("Total Price:"+totalPrice);
                }
                
                
	}
	
        /*
         *Calculates base delivery time by a wood's type
        */
        public static Double getBaseDeliveryTime(String woodType){
            switch(woodType){
                case "Cherry":return 2.5;
                case "Curly Maple": return 1.5;
                case "Genuine Mahogany": return 3.0;
                case "Wenge": return 5.0;
                case "White Oak": return 2.3;
                case "Sawdust": return 1.0;
                default: return -1.0;
            }
        }
        
        /*
         *calculates the price of a certain woodType's name
        */
        public static Double getPrice(String woodType){
            switch(woodType){
                case "Cherry":return 5.95;
                case "Curly Maple": return 6.00;
                case "Genuine Mahogany": return 9.60;
                case "Wenge": return 22.35;
                case "White Oak": return 6.70;
                case "Sawdust": return 1.5;
                default: return -1.0;
            }
        }
        
        /*
         *calculates the delivery time of a amount board feet of 
         *WoodItem w
        */
	public static Double deliveryTime(double amount, WoodItem w){
		Double deliveryETA = 0.0;
		if(1<=amount && amount <=100){
                    deliveryETA = 1*w.getDaseDeliveryTime();
                }
                else if(101<=amount && amount <=200){
                    deliveryETA = 2*w.getDaseDeliveryTime();
                }
                else if(201<=amount && amount <=300){
                    deliveryETA = 3*w.getDaseDeliveryTime();
                }
                else if(301<=amount && amount <=400){
                    deliveryETA = 4*w.getDaseDeliveryTime();
                }
                else if(401<=amount && amount <=500){
                    deliveryETA = 5*w.getDaseDeliveryTime();
                }
                else if(501<=amount && amount <=1000){
                    deliveryETA = 5.5*w.getDaseDeliveryTime();
                }
                
		return deliveryETA;
	}
        
	
}

class WoodItem {

	String type;
	Double baseDeliveryTime;
	Double price;
	
	/**
	 * Default constructor 
	 */
	public WoodItem(){
		this.type = "Empty";
		this.baseDeliveryTime = 0.0;
		this.price = 0.0;
	}
	
	/**
	 * Constructor of a WoodItem element with parameters
	 * @param type Name of the wood type
	 * @param daseDeliveryTime base delivery time
	 * @param price price per Bare Foot
	 */
	public WoodItem(String type, Double daseDeliveryTime, Double price) {
		this.type = type;
		this.baseDeliveryTime = daseDeliveryTime;
		this.price = price;
	}

	/**
	 * Get the type of Wood
	 * 
	 * @return Name of the WoodItem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the base delivery time
	 * 
	 * @return the baseDeliverytime
	 */
	public Double getDaseDeliveryTime() {
		return baseDeliveryTime;
	}

	/**
	 * 
	 * Get the price per Bare Foot
	 * 
	 * @return the price for 1 Bare Foot of this WoodItem
	 */
	public Double getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * You may implement this method to fit your needs
	 */
	@Override
	public String toString() {	
		return "";
	}
	
}
