package no.ntnu.iaklaest.IDATT2001.Oblig2;

import java.time.LocalDate;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsbalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;
    private static final int Silver_Limit = 25000;
    private static final int Gold_Limit = 75000;

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsbalance, String name, String eMailAddress, String password) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsbalance = bonusPointsbalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        this.password = password;
        this.membership = null;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsbalance() {
        return bonusPointsbalance;
    }

    public String getName() {
        return name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Membership getMembership() {
        return membership;
    }

    public static int getSilver_Limit() {
        return Silver_Limit;
    }

    public static int getGold_Limit() {
        return Gold_Limit;
    }

    public boolean checkPassword(String password){
        if(getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public void checkAndSetMembership(){
        if(bonusPointsbalance < Silver_Limit){
            membership = new BasicMembership();
        }else if(bonusPointsbalance < Gold_Limit){
            membership = new SilverMembership();
        }else{
            membership = new GoldMembership();
        }
    }

    public void registerBonusPoints(int newPoints){
        checkAndSetMembership();
        bonusPointsbalance += membership.registerPoints(bonusPointsbalance, newPoints);
        checkAndSetMembership();
    }

    public String getMembershipLevel(){
        return "";
    }

    @Override
    public String toString() {
        return  " memberNumber:" + memberNumber +
                "\n enrolledDate:" + enrolledDate +
                "\n bonusPointsbalance:" + bonusPointsbalance +
                "\n name:" + name +
                "\n eMailAddress:" + eMailAddress +
                "\n password:" + password +
                "\n membership:" + membership;
    }
}
