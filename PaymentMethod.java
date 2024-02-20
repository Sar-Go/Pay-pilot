import java.util.*;
class PaymentMethod {
    private String name;
    private Map<String, Integer> rewardCriteria;

    public PaymentMethod(String name) {
        this.name = name;
        this.rewardCriteria = new HashMap<>();
    }

    public void addRewardCriteria(String category, int threshold) {
        rewardCriteria.put(category, threshold);
    }

    public int calculateRewards(String category, int amount) {
        if (rewardCriteria.containsKey(category) && amount % rewardCriteria.get(category) == 0) {
            return amount / rewardCriteria.get(category);
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }
}