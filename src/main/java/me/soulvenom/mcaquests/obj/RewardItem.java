package me.soulvenom.mcaquests.obj;

public class RewardItem {

    private int minAmount;
    private int maxAmount;
    private int possibility;
    private String item;

    public RewardItem(int minAmount, int maxAmount, String item, int possibility) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.possibility = possibility;
        this.item = item;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public String getItem() {
        return item;
    }

    public int getPossibility() {
        return possibility;
    }
}
