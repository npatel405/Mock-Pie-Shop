import java.util.Random;
/**
*Pie creators that assign the pie object values
*
*@author 903079664 Niket Patel
*@version 1.0
*/
public class Pie {
    private String flavor;
    private boolean isSlice;
    private double value;

    /**
     * Creates a Pie object
     * @param flavor the flavor of the pie
     * @param isSlice whether or not the pie is a slice
     */
    public Pie(String flavor, boolean isSlice) {
        this.flavor = flavor;
        this.isSlice = isSlice;
        value = setval();
    }
    /**
    * @return value the value/price of the given flavored pie
    */
    public double setval() {
        if (isSlice) {
            value = 2.50;
            return value;
        } else {
            switch (flavor) {
            case "Pecan":
                value = 14.00;
                return value;
            case "Blueberry":
                value = (11.00);
                return value;
            case "Apple":
                value = (13.50);
                return value;
            case "Special":
                Random ran = new Random();
                value = (9 + (14 - 9) * ran.nextDouble());
                return value;
            default:
                value = 12.25;
                return value;

            }
        }
    }
    public double price() {
        return value;
    }

    @Override
    public String toString() {
        String type = isSlice ? "Slice" : "Whole pie";
        return String.format("%s %s $%.2f", flavor, type, price());
    }
}