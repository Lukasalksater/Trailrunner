package se.iths;

import static org.junit.jupiter.api.Assertions.*;


import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

public class TestUser {


    @Test

    public void testcreatingUserwithName(){


        User john = new User("John", null);


        assertEquals("John", john.name);


    }


    @Test

    public void testCreatingUserWithWeightandLenght(){

        User john = new User("John", 180, 80);


        assertEquals(180, john.lenght);
        assertEquals(80, john.weight);
    }




    @Test

    public void testSavingTrailrun(){

        User bob = new User("bob", 10, 0);

        Trailrun trailrun = new Trailrun(10, Duration.ofSeconds(3600), LocalDate.of(2024, 5, 10));
        Trailrun trailrun2 = new Trailrun(5, Duration.ofSeconds(300));

        bob.trailrunList.add(trailrun);
        bob.trailrunList.add(trailrun2);


        assertTrue(bob.trailrunList.contains(trailrun));
        assertTrue(bob.trailrunList.contains(trailrun2));


    }
    @Disabled
    @Test

    public void testPrintingDetailsWithID(){
        User bob = new User("bob", null);



        
        Trailrun trailrun = new Trailrun(10, Duration.ofSeconds(3600), LocalDate.of(2024, 5, 10));
        Trailrun trailrun2 = new Trailrun(5, Duration.ofSeconds(300));

        bob.trailrunList.add(trailrun);
        bob.trailrunList.add(trailrun2);

       


        assertEquals(trailrun,  bob.getTrailrunById("1000"));

        assertEquals(trailrun2, bob.getTrailrunById("1001"));



    }



    @Test

    public void testCalculatingTotalDistanceOfSavedRuns(){


        User bob = new User("bob",null);



        
        Trailrun trailrun = new Trailrun(10, Duration.ofSeconds(3600), LocalDate.of(2024, 5, 10));
        Trailrun trailrun2 = new Trailrun(5, Duration.ofSeconds(300));

        bob.trailrunList.add(trailrun);
        bob.trailrunList.add(trailrun2);


        bob.calculateTotalDistanceOfSavedRuns();


        assertEquals(15, bob.totalDistance);
    }

    @Test
    public void testCalculatingAverageDistanceOfSavedRuns(){


        
        User bob = new User("bob",null);
        
        Trailrun trailrun = new Trailrun(10, Duration.ofSeconds(3600), LocalDate.of(2024, 5, 10));
        Trailrun trailrun2 = new Trailrun(5, Duration.ofSeconds(300));

        bob.trailrunList.add(trailrun);
        bob.trailrunList.add(trailrun2);

        bob.calculateAverageDistanceOfSavedRuns();


        assertEquals(7.5, bob.averageDistance);

    }
    
}
