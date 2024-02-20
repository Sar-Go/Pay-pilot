public class Main {
    public static void main(String[] args) {
        // Example usage
        PaymentMethod axisBank = new PaymentMethod("AxisBank");
        axisBank.addRewardCriteria("Dining", 150);
        axisBank.addRewardCriteria("FuelRefilling", 100);
        axisBank.addRewardCriteria("Travelling", 500);

        PaymentMethod hdfcBank = new PaymentMethod("HDFCBank");
        hdfcBank.addRewardCriteria("Dining", 150);
        hdfcBank.addRewardCriteria("FuelRefilling", 10);
        hdfcBank.addRewardCriteria("Travelling", 5001);

        // Add more payment methods and categories as needed

        PaymentSystem paymentSystem = new PaymentSystem();
        paymentSystem.addPaymentMethod(axisBank);
        paymentSystem.addPaymentMethod(hdfcBank);
        // Add more payment methods

        PaymentCategory dining = new PaymentCategory("Dining");
        PaymentCategory fuelRefilling = new PaymentCategory("FuelRefilling");
        PaymentCategory travelling = new PaymentCategory("Travelling");
        // Add more payment categories

        paymentSystem.addPaymentCategory(dining);
        paymentSystem.addPaymentCategory(fuelRefilling);
        paymentSystem.addPaymentCategory(travelling);

        // Example usage to find the best payment method
        String userCategory = "Dining";
        int userAmount = 300;

        String bestMethod = paymentSystem.getBestPaymentMethod(userCategory, userAmount);

        if (bestMethod != null) {
            System.out.println("The best payment method for " + userCategory + " with $" + userAmount + " spent is: " + bestMethod);
        } else {
            System.out.println("No eligible payment methods for the given amount and category.");
        }
    }
}