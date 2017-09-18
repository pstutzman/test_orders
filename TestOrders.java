import java.text.DecimalFormat;
    //Paula Stutzman

    //Program to order widgets or gizmos, calculate costs, output a detail and summary report.

public class TestOrders
 {
 public static char validateProduct(char product)
 {
 //prod in the main is now product
 while (product != 'W' && product != 'G')
 {
 System.out.print
 ("ERROR in your input. You must select either W for widgets or G for gizmos (W/G): ");
 System.out.print("\nPlease re-enter either W for widgets or G for gizmos (W/G): ");
 product = GetInput.readLineNonwhiteChar();
 product = Character.toUpperCase(product);
 }//end of while loop
 return (product);
 }//end of method productType / must enter W or G or get error message

 public static char validateShipping(char deliveryType)
 {
 while (deliveryType != 'F' && deliveryType != 'U')
 {
 System.out.print
 ("ERROR in your input. You must select either F for Fredcost or U for USPS (F/U): ");
 System.out.print("\nPlease re-enter either F for Fredcost or U for USPS (F/U): ");
 deliveryType = GetInput.readLineNonwhiteChar();
 deliveryType = Character.toUpperCase(deliveryType);

 }//end of while loop
 return (deliveryType);
 }//end of method productType / must enter F or U or get error message

 public static int widgetQty(int qty)
 {
 while ((qty % 12) != 0 || (qty > 144 ))
 {
 System.out.print
 ("ERROR in input data. Must enter quantity that is divisible by 12 for Widgets");
 System.out.print("\nPlease re-enter Widget quantity that is divisible by 12: ");
 qty=GetInput.readLineInt();
 }
 return qty;

}//end of widgetQty - must enter multiples of 12 upto 144 / error message

 public static int gizmoQty(int qty)
 {
 while ((qty % 8) != 0 )
 {
 System.out.print
 ("ERROR in input data. Must enter quantity that is divisible by 8 for Gizmos"); System.out.print("\nPlease re-enter Gizmo quantity that is divisible by 8: ");
 qty=GetInput.readLineInt();
 }
 return qty;
 }//end of gizmoQty - - must enter multiples of 8 w/ no limit / error message

 public static void main (String [] args)
 {
    DecimalFormat mine = new DecimalFormat("$#,##0.00");
    String name = "" ;
    String product = " ";
    char choice = ' ';
    char prod;
    int qty = 0;
    int count = 0;
    double cost_of_product=0.0;
    double cost_of_shipment = 0.0;
    char deliveryType;
    double total_cost_of_product = 0.0;
    int total_Gizmo = 0;
    int total_Widget = 0;
    double total_Cost = 0;
    double total_Gizmo_Cost = 0;
    double total_Widget_Cost = 0; // list of variables

    System.out.print("Please enter your name: ");
    name = GetInput.readLine(); //customer enters name

 do {
      System.out.print("What product would you like to order (W/G): ");
      product =GetInput.readLine();
      prod = Character.toUpperCase(product.charAt(0));
      prod = validateProduct(prod); //validate W or G
      if(prod == 'W')
          {
              System.out.print("What quantity of Widgets do you want to order?: ");
              qty = GetInput.readLineInt();
              qty = widgetQty(qty);

          }
      else
          {
              System.out.print("What quantity of Gizmos do you want to order?: ");
              qty = GetInput.readLineInt();
              qty = gizmoQty(qty);
          } //qty of widgets/gizmos

      cost_of_product = Orders.productCost(qty, prod); //connecting TestOrders and Orders

      System.out.print("What shipping method would you like (F/U)?: ");
      deliveryType = Character.toUpperCase(GetInput.readLineNonwhiteChar());
      deliveryType = validateShipping(deliveryType); //selecting F or U shipping

      cost_of_shipment = Orders.shippingCost(qty, prod, deliveryType);
      //connecting TestOrders and Orders

      System.out.println("\nCustomer: " + name );//Detail report
      System.out.println("Ordered " + qty +" "
      +(prod == 'W' ? "Widgets ":"Gizmos ") + "costing " + mine.format(cost_of_product) + ".");
      System.out.println("Shipped via "+ (deliveryType =='F' ? "Fred ":"USPS ")
      + "costing " + mine.format(cost_of_shipment) + ".");

      total_cost_of_product = Orders.totalCost(cost_of_product, cost_of_shipment);
      //connecting TestOrders and Orders

      System.out.println("Total order cost is " + mine.format(total_cost_of_product));

      count = count + 1; // order counter

      if(prod =='G')
            {
            total_Gizmo = total_Gizmo + qty;
            total_Gizmo_Cost = total_Gizmo_Cost + total_cost_of_product;
           }
      else
          {
            total_Widget = total_Widget + qty;
            total_Widget_Cost = total_Widget_Cost + total_cost_of_product;
          }

      total_Cost = total_Cost + total_cost_of_product;

      System.out.println("\nDo you wish to make another order?: ");
      choice = GetInput.readLineNonwhiteChar(); //user enters Y/N to continue
      }while ((choice == 'Y') || (choice == 'y')); // end of do/while loop

      System.out.println("\nSummary Report"); //summary report
      System.out.println(count + " Total Orders");
      System.out.print("Total quantity of Gizmos ordered: " + total_Gizmo
      + " at a cost of " + mine.format(total_Gizmo_Cost) );
      System.out.print("\nTotal quantity of Widgets ordered: " + total_Widget
      + " at a cost of " + mine.format(total_Widget_Cost));
      System.out.println("\nTotal sales amount: " + mine.format(total_Cost));
   }//end main method
 }//end of class TestOrders (try for less than 40 lines)
