package cafeguii.app;

public class CoffeeShopCalculator {
    private double total;
    private int x;
    private double tax;

    public CoffeeShopCalculator() {
        total = 0.0;
        x = 0;
        tax = 0.0;
    }
    

    public double calculateTax(double subtotal) {
        return subtotal * 0.05;
    }
}
