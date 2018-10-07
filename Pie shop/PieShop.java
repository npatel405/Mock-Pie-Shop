import java.util.Scanner;
/**
*Pie shopping menu
*
* @author 903079664 Niket Patel
* @version 1.0
*/
public class PieShop {
    private static int n = 3;
    private static Pie[] cart = new Pie[n];
    private static int numPies = 0;
    /**
    *
    * @param p Pie object holding flavor, slice , and price
    */
    public static void addToCart(Pie p) {
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) {
                cart[i] = p;
                numPies++;
                break;
            }
        }
        if (numPies == cart.length) {
            n = n * 2;
            Pie[] carttemp = new Pie[n];
            for (int i = 0; i < cart.length; i++) {
                carttemp[i] = cart[i];
            }
            cart = carttemp;
        }
    }
    /**
    * @return total value of the sum of each pie within the array
    */
    public static double sum() {
        double total = 0;
        for (int i = 0; i < numPies; i++) {
            total += cart[i].price();
        }
        return total;
    }
    /**
    * creates the main shopping menu
    *
    * @param args user input arguments
    */
    @Test
    public static void main(String[] args) {
        String flavor = "";
        int holder = 0;
        int choice = 0;
        boolean slice;
        System.out.println("Welcome to the Pie Shop!");
        while (holder == 0) {
            System.out.println("Please choose an option:");
            System.out.println("1. Buy a slice\n2. Buy a whole pie");
            System.out.println("3. View cart\n4. Check out");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            slice = (choice == 1) ? true : false;
            if (choice == 1) {
                flavor = flavor();
                Pie p = new Pie(flavor, slice);
                addToCart(p);
            }   else if (choice == 2) {
                flavor = flavor();
                Pie p = new Pie(flavor, slice);
                addToCart(p);
            }   else if (numPies != 0 && choice == 3) {
                System.out.print("Cart Contents: ");
                for (int i = 0; i < numPies; i++) {
                    System.out.print(cart[i] + ", ");
                }
            }   else if (numPies != 0 && choice == 4) {
                System.out.println("Thank you! Your Total is ");
                System.out.printf("$%.2f\n", sum());
                System.out.print("Please proceed to the counter ");
                System.out.print("to pick up your order");
                holder = 1;
            }   else {
                System.out.println("Please enter a valid choice");
            }
            System.out.println(" ");
        }
    }
    /**
    *promts user to choose the flavor of chosen pie
    *
    *
    * @return flavor the flavor of the current pie being evalutated
    */
    public static String flavor() {
        String flavor = "";
        int choice2;
        System.out.println("Please enter the number for the flavor of pie");
        System.out.println("1. Pecan\n2. Blueberry\n3. Apple\n4. Pumpkin");
        System.out.println("5. Strawberry\n6. Special");
        Scanner input = new Scanner(System.in);
        choice2 = input.nextInt();
        switch (choice2) {
        case 1:
            flavor = "Pecan";
            break;
        case 2:
            flavor = "Blueberry";
            break;
        case 3:
            flavor = "Apple";
            break;
        case 4:
            flavor = "Pumpkin";
            break;
        case 5:
            flavor = "Strawberry";
            break;
        case 6:
            flavor = "Special";
            break;
        default:
            System.out.println("Please enter a valid choice");
            flavor();
        }
        return flavor;
    }

}