package se.iths;


import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.*;


public class TestTrailRun {


   


    @Test

    public void testCreatingTrailrunWithDistance(){

        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(0), LocalDate.of(1, 1, 1));


        assertEquals(5, trailrun.distance);


    }

    @Test


    public void testCreatingTrailrunWithDuration(){


        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(500), LocalDate.of(1, 1, 1));


        assertEquals(500, trailrun.duration.getSeconds());
    }

    @Test

    public void testCreatingTrailrunWithDate(){


        Trailrun trailrun = new Trailrun(0, Duration.ofSeconds(0), LocalDate.of(2024, 1, 10));


        assertEquals(LocalDate.of(2024, 1, 10), trailrun.date);

        
    }


    @Test

    public void testCreatingTrailrunWithOutDate(){

        Trailrun trailrun = new Trailrun(1, Duration.ofSeconds(500));


        assertEquals(LocalDate.now() , trailrun.date);
    }


    @Test

    public void testCalculatingAverageTrailRunSpeed(){

        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(36000));


        trailrun.calculateAverageSpeed();

        assertEquals(0.5, trailrun.averageRunningSpeed);


    }


    @Test

    public void testCalculatingKilometerTime(){

        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(36000));


        trailrun.calculateKilometerSpeed();

        assertEquals(120, trailrun.kilometerSpeed);
    }
}
