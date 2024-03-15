package se.iths;

import java.time.*;


public class Trailrun {

    public double distance;

    public Duration duration;

    public LocalDate date;

    public double averageRunningSpeed;

    public double kilometerSpeed;

    public static int idCounter = 1000;
    private final int idNumber;
    private  String id;



    public String getID(){

      return id;
    }


  



    public Trailrun (double distance, Duration seconds, LocalDate date){

     this.distance = distance;
     duration = seconds;

     this.date = date;

     idNumber = idCounter++;

     id = String.valueOf(idNumber);


   }

   public Trailrun ( double distance, Duration seconds){

    this.distance = distance;
    duration = seconds;
    date = LocalDate.now();

    idNumber = idCounter++;

    id = String.valueOf(idNumber);

  
   }

   public void calculateAverageSpeed(){

    averageRunningSpeed = distance / duration.toHours();
    
   }

   public void calculateKilometerSpeed(){

    kilometerSpeed = duration.toMinutes() / distance;

   }


   public int getIdNumber(){

    return idNumber;
   }












    
}
