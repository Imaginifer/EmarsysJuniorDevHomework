
import emarsysjuniordevhomework.DeadlineCalculator;
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imaginifer
 */
public class EmarsysJuniorDevHomeworkTests {
    private DeadlineCalculator dc;
    
    @Before
    public void setUp(){
        dc = new DeadlineCalculator();
    }
    
    @Test(expected = Exception.class)
    public void testOffHoursException() throws Exception{
        LocalDateTime submissionTime = LocalDateTime.of(2021, 12, 17, 6, 30);
        LocalDateTime result = dc.calculateDeadline(submissionTime, 3);
    }
    
    @Test(expected = Exception.class)
    public void testWeekendException() throws Exception{
        LocalDateTime submissionTime = LocalDateTime.of(2021, 12, 19, 10, 30);
        LocalDateTime result = dc.calculateDeadline(submissionTime, 3);
    }
    
    private LocalDateTime getDeadline(LocalDateTime submissionTime, int turnaround){
        
        try{
            return dc.calculateDeadline(submissionTime, turnaround);
        } catch (Exception e){
            return null;
        }
    }
    
    @Test
    public void testOrdinaryOutput(){
        
        LocalDateTime submissionTime = LocalDateTime.of(2021, 12, 17, 10, 30);
        int turnaround = 5;
        LocalDateTime expectedDeadline = LocalDateTime.of(2021, 12, 17, 15, 30);
        
        assertTrue(expectedDeadline.isEqual(getDeadline(submissionTime, turnaround)));
    }
    
    @Test
    public void testDelayFromOffHours(){
        
        LocalDateTime submissionTime = LocalDateTime.of(2021, 12, 16, 10, 30);
        int turnaround = 10;
        LocalDateTime expectedDeadline = LocalDateTime.of(2021, 12, 17, 12, 30);
        
        assertTrue(expectedDeadline.isEqual(getDeadline(submissionTime, turnaround)));
    }
    
    @Test
    public void testDelayFromWeekend(){
        
        LocalDateTime submissionTime = LocalDateTime.of(2021, 12, 17, 10, 30);
        int turnaround = 10;
        LocalDateTime expectedDeadline = LocalDateTime.of(2021, 12, 20, 12, 30);
        
        assertTrue(expectedDeadline.isEqual(getDeadline(submissionTime, turnaround)));
    }
}
