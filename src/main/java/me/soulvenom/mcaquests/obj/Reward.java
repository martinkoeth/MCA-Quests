package me.soulvenom.mcaquests.obj;

import java.util.List;

public class Reward {

    private int minRelationShipGain;
    private int maxRelationShipGain;
    private List<RewardItem> rewardList;
    private int smallPouchPer;          // Not implemented -> Possibility of getting certain pouch
    private int mediumPouchPer;         // containing the reward Items
    private int largePouchPer;

    public Reward(int minRelationShipGain, int maxRelationShipGain, List<RewardItem> rewardList, int smallPouchPer, int mediumPouchPer, int largePouchPer) {
        this.minRelationShipGain = minRelationShipGain;
        this.maxRelationShipGain = maxRelationShipGain;
        this.rewardList = rewardList;
        this.smallPouchPer = smallPouchPer;
        this.mediumPouchPer = mediumPouchPer;
        this.largePouchPer = largePouchPer;
    }

    public int getMinRelationShipGain() {
        return minRelationShipGain;
    }

    public int getMaxRelationShipGain() {
        return maxRelationShipGain;
    }

    public List<RewardItem> getRewardList() {
        return rewardList;
    }

    public int getSmallPouchPer() {
        return smallPouchPer;
    }

    public int getMediumPouchPer() {
        return mediumPouchPer;
    }

    public int getLargePouchPer() {
        return largePouchPer;
    }
}
