
package com.mycompany.integrationlab4.backend;

import java.io.File;
import java.io.FileNotFoundException;

import java.time.LocalDate;

import java.util.Scanner;

public class MemberClassRegistrationDatabase extends Database {

     public MemberClassRegistrationDatabase(String x) throws FileNotFoundException
    {
        filename=x;
        readFromFile();
    }
     @Override
    protected void readFromFile() throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        MemberClassRegistration memberRegistered;
        String temp;      
        while(s.hasNextLine())
        {
            //System.out.println("lol555");
          
            temp=s.nextLine();
            String[] k=temp.split(",");
            memberRegistered=new MemberClassRegistration(k[0],k[1],k[2],LocalDate.parse(k[3]));
            records.add(memberRegistered);
        }        
    }
     @Override
    protected MemberClassRegistration createRecordFrom (String line)
    {
        String[] k=line.split(",");
        var x=new MemberClassRegistration(k[0],k[1],k[2],LocalDate.parse(k[3]));
        return x;
    }


}
