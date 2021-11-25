package no.ntnu.iaklaest.IDATT2001.Oblig2;

public class SilverMembership extends Membership{
    private final float Points_Scaling_Factor = 1.2f;

    @Override
    public int registerPoints(int bonusPointsBalance, int newPoints) {
        bonusPointsBalance += Points_Scaling_Factor*newPoints;
        return Math.round(bonusPointsBalance);
    }

    @Override
    public String getMambershipName() {
        return "Silver";
    }

    public String toString(){
        return getMambershipName();
    }
}
