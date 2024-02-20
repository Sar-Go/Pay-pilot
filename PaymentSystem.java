import java.util.*;
class PaymentSystem {
    private Map<String, PaymentMethod> paymentMethods;
    private Map<String, PaymentCategory> paymentCategories;

    public PaymentSystem() {
        this.paymentMethods = new HashMap<>();
        this.paymentCategories = new HashMap<>();
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethod.getName(), paymentMethod);
    }

    public void addPaymentCategory(PaymentCategory paymentCategory) {
        paymentCategories.put(paymentCategory.getName(), paymentCategory);
    }

    public String getBestPaymentMethod(String category, int amount) {
        Map<String, Integer> rewards = new HashMap<>();

        for (PaymentMethod method : paymentMethods.values()) {
            rewards.put(method.getName(), method.calculateRewards(category, amount));
        }

        String bestMethod = rewards.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return bestMethod;
    }
}