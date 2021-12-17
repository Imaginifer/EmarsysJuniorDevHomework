/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emarsysjuniordevhomework;

import java.time.*;
import java.util.*;

/**
 *
 * @author imaginifer
 */
public class DeadlineCalculator {
    private final int workingHoursBegin, workingHoursEnd, offHours, weekendHours;
    private final Set<DayOfWeek> weekend;

    public DeadlineCalculator() {
        this.workingHoursBegin = 9;
        this.workingHoursEnd = 17;
        this.offHours = 16;
        this.weekendHours = 48;
        this.weekend = new HashSet<>(Arrays.asList(new DayOfWeek[]{DayOfWeek.SATURDAY, DayOfWeek.SUNDAY}));
    }
    
    public LocalDateTime calculateDeadline(LocalDateTime submissionDate, int turnaroundHours) throws Exception{
        
        if(weekend.contains(submissionDate.getDayOfWeek()) 
                || submissionDate.getHour()<workingHoursBegin 
                || submissionDate.getHour()>workingHoursEnd){
            throw new Exception("Report can only be submitted during working hours!");
        }
        
        LocalDateTime deadline = submissionDate;
        
        while(turnaroundHours > 0){
            deadline = deadline.plusHours(1);
            turnaroundHours--;
            
            if(deadline.getHour() > workingHoursEnd){
                deadline = deadline.plusHours(offHours);
            }
            if(weekend.contains(deadline.getDayOfWeek())){
                deadline = deadline.plusHours(weekendHours);
            }
        }
        
        return deadline;
    }
    
    
}
