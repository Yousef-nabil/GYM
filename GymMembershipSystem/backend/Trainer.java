/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.integrationlab4.backend;

/**
 *
 * @author Dell
 */
public class Trainer implements general {

   String trainerId;
   String name;
   String email;
   String speciality;
   String phoneNumber;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
    }
   @Override
    public String lineRepresentation()
    {
        String all;
        all=trainerId+","+name+","+email+","+speciality+","+phoneNumber;
        return all;
    }
   @Override
    public String getSearchKey()
    {
        return trainerId;
    }

}
