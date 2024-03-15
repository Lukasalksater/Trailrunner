package se.iths;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.*;
import static org.mockito.Mockito.*;


public class TestUserDatabaseInterface {


    @Mock
    private  DatabaseAPI databaseAPI;


    @BeforeEach
    public void setup(){

        databaseAPI = mock(DatabaseAPI.class);
    }



    @Test

    public void testSavingTrailrunToDatabase(){

        User bob = new User("bob", databaseAPI);

        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(3600));

       when(databaseAPI.createRecord(trailrun.getID(), trailrun.distance, (int)trailrun.duration.getSeconds(), trailrun.date)).thenReturn(true);

       
       
      assertTrue(bob.addRun(trailrun));


    }

    @Test

    public void testSavingSameRunToDatabase(){


        User bob = new User("bob", databaseAPI);

        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(3600));

       when(databaseAPI.createRecord(trailrun.getID(), trailrun.distance, (int)trailrun.duration.getSeconds(), trailrun.date)).thenReturn(false);
 
       List<String> testList = new ArrayList<>();
       testList.add("1000");
       when(databaseAPI.getRecordIDs()).thenReturn( testList);

       assertFalse(bob.addRun(trailrun));



    }



    
    @Test

    public void testReadingRunFromDatabase(){


        User bob = new User("bob", databaseAPI);

        Trailrun trailrun = new Trailrun(5, Duration.ofSeconds(3600));

        when(databaseAPI.readRecord("1000")).thenReturn(trailrun);




    }







    
}
