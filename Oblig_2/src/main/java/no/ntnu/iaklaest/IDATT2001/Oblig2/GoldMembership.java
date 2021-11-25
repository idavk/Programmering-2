package no.ntnu.iaklaest.IDATT2001.Oblig2;

public class GoldMembership extends Membership{
    private static final float Points_Scailing_Factor_level_1 = 1.3f;
    private static final float Points_Scailing_Factor_level_2 = 1.5f;

    @Override
    public int registerPoints(int bonusPointsBalance, int newPoints) {
        float GoldScalingFactor;
        if(bonusPointsBalance < 90000){
            GoldScalingFactor = Points_Scailing_Factor_level_1;
        } else {
            GoldScalingFactor = Points_Scailing_Factor_level_2;
        }
        bonusPointsBalance += GoldScalingFactor*newPoints;
        return Math.round(bonusPointsBalance);
    }

    @Override
    public String getMambershipName() {
        return "Gold";
    }

    public String toString(){
        return getMambershipName();
    }
}
