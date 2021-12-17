/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emarsysjuniordevhomework;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author imaginifer
 */
public class EmarsysJuniorDevHomework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DeadlineCalculator dc = new DeadlineCalculator();
        
        System.out.println("Please type in task turnaround time:");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();
        try{
            int turnaroundTime = Integer.parseInt(response);
            System.out.println("Deadline is: "+dc.calculateDeadline(LocalDateTime.now(), turnaroundTime));
        }catch (NumberFormatException e){
            System.out.println("Wrong time format!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
