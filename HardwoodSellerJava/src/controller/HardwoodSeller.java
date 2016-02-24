/**
 * 
 */
package controller;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.WoodItem;

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
                double amount;
                ArrayList<WoodItem> woodItems = new ArrayList<WoodItem>();
                                
		try{in = new Scanner(new File(inputFilePath));}
                catch(IOException i){
			System.out.println("Incorrectly input filename/"
                                + "formatted file");
			System.out.println("Could not open");
			return;
		}//error handling over
		
                
                if(in.hasNext()){//while there are more input tokens
                    buyerName = in.next();addr = in.next();in.next();//skip date
                    
                    while(in.hasNext()){//get type and amount repeatedly
                        woodType = in.next();amount = in.nextInt();
                        woodItems.add(new WoodItem(woodType, amount,))
                    }//adding each new type to woodItems
                    
                }
	}
	
	public static Double deliveryTime(){
		Double deliveryETA = 0.0;
		
		return deliveryETA;
	}
        
        public static double getWoodTypePrice(String woodType){
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
	
}
