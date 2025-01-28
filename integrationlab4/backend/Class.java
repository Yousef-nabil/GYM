package com.mycompany.integrationlab4.backend;

//import java.time.LocalDate;

public class Class implements general {/*
   private static MemberDatabase memberDatabase;
   private static  ClassDatabase classDatabase;
   private  static MemberClassRegistrationDatabase registrationDatabase;*/
   private String classID;
   private  String className;
   private String trainerID;
   private int duration;
   private  int  availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }
   public int getAvailableSeats()
   {
       return this.availableSeats;
   }
   public void  setAvailableSeats (int availableSeats) 
   {
       this.availableSeats=availableSeats;
   }
    @Override
    public String lineRepresentation()
    {
        String all;
        all=classID+","+className+","+trainerID+","+duration+","+availableSeats;
        return all;
    }
    @Override
    public String getSearchKey()
    {
        return classID;
    }
}

