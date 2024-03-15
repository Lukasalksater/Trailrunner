package se.iths;

import java.util.ArrayList;
import java.util.List;

public class User {

    DatabaseAPI api;
    public String name;

    public int weight;
    public int lenght;

    public int totalDistance;
    public double averageDistance;

    public List<Trailrun> trailrunList = new ArrayList<Trailrun>();
    


    public User (String name, int lenght, int weight){


        this.name = name;

        this.lenght = lenght;
        this.weight = weight;

    }


    public User (String name, DatabaseAPI api){


        this.name = name;
        this.api = api;

    }


    public boolean addRun(Trailrun run){

        if (api.getRecordIDs().contains(run.getID())) {

            return false;
            
        }

       return  api.createRecord(run.getID(), run.distance, (int) run.duration.getSeconds(), run.date);

        

    }


    public  Trailrun getTrailrunById(String id){


            for (Trailrun trailrun: trailrunList) {


                if (trailrun.getID().equals(id)) {
    
                    return trailrun;
                    
                }

            
        }

        return null;

            
        }

        public int calculateTotalDistanceOfSavedRuns(){

            for (Trailrun trailrun : trailrunList) {

                totalDistance += trailrun.distance;


                
            }

            return totalDistance;
        }


        public double calculateAverageDistanceOfSavedRuns(){


            for (Trailrun trailrun : trailrunList) {

                 averageDistance += trailrun.distance;
                
            }


            averageDistance = averageDistance / trailrunList.size();

            return averageDistance;


            
        }


     


        

        

            

        



    }
    

