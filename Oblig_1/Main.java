package no.ntnu.iaklaest.IDATT2001.Oblig1;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args){
        String sekunderLest= showInputDialog("sekunder:");
        int minutter= Integer.parseInt(sekunderLest)%3600/60;
        int sekunder= Integer.parseInt(sekunderLest)%3600%60;
        int timer= Integer.parseInt(sekunderLest)/3600;
        String timestamp=String.format ("%02d:%02d:%02d", timer, minutter, sekunder);

        showMessageDialog(null, timestamp);

    }
}
