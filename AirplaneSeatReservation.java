
/* Name; John Gitahi
    SMU; 48116033
	Lab 4 Fall-2019
*/	



import java.util.Scanner;//program uses Scanner
import java.util.*;
public class AirplaneSeatReservation
{
static final String welcomMessage ="Reserve seats for your upcoming flight";//welcome message
static final double taxPercentage =8.25/100;
  
public static void display(String[] rowOneSeats,String[] rowTwoSeats,String[] rowThreeSeats,
double[] rowOnePrices,double[] rowTwoPrices,double[] rowThreePrices)
{//display AirplaneSeat
System.out.println("\n SEATING CHART \n");
System.out.println("   ----------------- ");
System.out.println("  /                   \\ ");
System.out.println(" /                     \\ ");
System.out.println("/                       \\");
System.out.println("|                        |");
System.out.println("|                        |");
System.out.println("|                        |");
printRowSeats(rowOneSeats);
printRowPrices(rowOnePrices);
System.out.println(String.format("|%24s|"," "));
printRowSeats(rowTwoSeats);
printRowPrices(rowTwoPrices);
System.out.println(String.format("|%24s|"," "));
printRowSeats(rowThreeSeats);
printRowPrices(rowThreePrices);
System.out.println(String.format("|%24s|"," "));
}
  
public static void printRowSeats(String[] rowSeat)
{
System.out.println(String.format("|%7s%8s%8s |",rowSeat[0],rowSeat[1],rowSeat[2]));
}
  
public static void printRowPrices(double[] rowPrice)//print rowPrice
{
String firstPrice =String.format("%.2f",rowPrice[0]);
String secondPrice =String.format("%.2f",rowPrice[1]);
String thirdPrice =String.format("%.2f",rowPrice[2]);
System.out.println(String.format("|%7s%8s%8s |","$"+firstPrice,"$"+secondPrice,"$"+thirdPrice));
}//end printRowPrices
  
public static int getRow()
{
Scanner sc = new Scanner(System.in);
System.out.print("\nEnter the row for the seat you want to reserve: (One/Two/Three) ");
String str =sc.nextLine().toLowerCase();
//if and if else statement  
if(str.equals("one"))
{
return 1;
}
else if(str.equals("two"))
{
return 2;
}
else if(str.equals("three"))
{
return 3;
}
return 0;
}//end getRow
  
public static double makeReservation(String[] rowSeats, double[] prices, int row)
{
Scanner sc = new Scanner(System.in);//take user input
char[] fill = new char[26];
Arrays.fill(fill, '=');
String character = new String(fill);
System.out.println(character);
printRowSeats(rowSeats);
printRowPrices(prices);
System.out.println(character);
System.out.print("Which seats do you want? (A/B/C) ");
String seatLetter = sc.nextLine().toUpperCase();
int seatNum=0;
if(seatLetter.equals("A"))
{
seatNum=0;
System.out.println("The seat you selected is: "+row+seatLetter.toUpperCase());
System.out.println(String.format("The price of the seat is: $%.2f",prices[0]));
}
else if(seatLetter.equals("B"))
{
seatNum=1;
System.out.println("The seat you selected is: "+row+seatLetter.toUpperCase());
System.out.println(String.format("The price of the seat is: $%.2f",prices[1]));
}
else if(seatLetter.equals("C"))
{
seatNum=2;
System.out.println("The seat you selected is: "+row+seatLetter.toUpperCase());
System.out.println(String.format("The price of the seat is: $%.2f",prices[2]));
}
System.out.println("Updated row chart:");
updateSeatingChart(rowSeats,seatNum);
System.out.println(character);
printRowSeats(rowSeats);
printRowPrices(prices);
System.out.println(character);

return prices[seatNum];
}//end makeReservation
  
public static void updateSeatingChart(String[] rowSeats, int seatNum)
{
rowSeats[seatNum]="X";
}
  
public static void printReceipt(int numSeats,double total)
{//tax calculation
double taxes = total*taxPercentage;
System.out.println("\nHere's your receipt:");
char[] fill = new char[20];
Arrays.fill(fill, '~');
String character = new String(fill);
System.out.println(character);
System.out.println(String.format("Subtotal: $%.2f",total));
System.out.println(String.format("Taxes: $%.2f",taxes));
Arrays.fill(fill, '=');
character = new String(fill);
System.out.println(character);
System.out.println(String.format("Total: $%.2f",(total+taxes)));
Arrays.fill(fill, '~');
character = new String(fill);
System.out.println(character);
}//end printReceipt
  
   public static void main(String[] args)
   {
   Scanner sc = new Scanner(System.in);// take user input
String rowOneSeats[] = new String[]{"1A","1B","1C"};
String rowTwoSeats[] = new String[]{"2A","2B","2C"};
String rowThreeSeats[] = new String[]{"3A","3B","3C"};
double rowOnePrices[] = new double[]{35,15,45};
double rowTwoPrices[] = new double[]{30,12,40};
double rowThreePrices[] = new double[]{25,10,35};
  
double total=0;
  
System.out.println(welcomMessage);
display(rowOneSeats,rowTwoSeats,rowThreeSeats,rowOnePrices,rowTwoPrices,rowThreePrices);

System.out.print("\nHow many seats do you want to reserve? ");
int numSeats = sc.nextInt();
while(numSeats>0)
{
int row =getRow();
if(row==1)
{
total+=makeReservation(rowOneSeats,rowOnePrices,row);
}
else if(row==2)
{
total+=makeReservation(rowTwoSeats,rowTwoPrices,row);
}
else if(row==3)
{
total+=makeReservation(rowThreeSeats,rowThreePrices,row);
}
System.out.println(String.format("Your subtotal is: $%.2f",total));
System.out.println("-----");
numSeats--;
}//end while loop
display(rowOneSeats,rowTwoSeats,rowThreeSeats,rowOnePrices,rowTwoPrices,rowThreePrices);
printReceipt(numSeats,total);
   }//end main method
}//end class AirplaneSeatReservation