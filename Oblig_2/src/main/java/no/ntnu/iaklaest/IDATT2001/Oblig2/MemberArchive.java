package no.ntnu.iaklaest.IDATT2001.Oblig2;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @author arne
 */

public class MemberArchive {
    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    public BonusMember FindPoints(int memberNumber, String password){
        BonusMember findPoints = null;
        String medlemsInfo = "" + memberNumber
                + "" + password;
        findPoints = this.members.get(medlemsInfo);
        return findPoints;
    }

    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success = false;
        if(!this.members.containsKey(bonusMember.getMemberNumber())){
            this.members.put(bonusMember.getMemberNumber(), bonusMember);
            success = true;
        }
        return success;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        for (int key: members.keySet()){
            if(memberNumber == key){
                members.get(key).registerBonusPoints(bonusPoints);
                success = true;
            }
        }

        return success;
    }


    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        for (BonusMember bonusMember: members.values()){
            System.out.println(bonusMember.toString());
            System.out.println();

        }
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "HeiVerden123");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz", "Jensen4567");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no", "LieLinda2345");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org","Linda5678");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com","FinnFloo6789");
        this.members.put(member.getMemberNumber(), member);

    }
}
