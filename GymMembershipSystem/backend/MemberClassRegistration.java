/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrationlab4.backend;

import java.time.LocalDate;

/**
 *
 * @author Etijah
 */
public class MemberClassRegistration implements general {
 private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;
    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public String getstatus()
    {
        return status;
    }
public String getSearchKey()
{
    return this.memberID+this.classID;
}
  public String lineRepresentation()
    {
        String all;
        all=memberID+","+classID+","+status+","+registrationDate;
        return all;
    }
    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

   
}
