/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrationlab4.backend;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class TrainerDatabase extends Database {    
    public TrainerDatabase(String x) throws FileNotFoundException
    {
        filename=x;
        readFromFile();
    }
    @Override
    protected void readFromFile() throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        Trainer t1;
        String temp;      
        while(s.hasNextLine())
        {
            temp=s.nextLine();
            String[] k=temp.split(",");
            t1=new Trainer(k[0],k[1],k[2],k[3],k[4]);
            records.add(t1);
        }        
    }
    @Override
    protected Trainer createRecordFrom (String line)
    {
        String[] k=line.split(",");
        var x=new Trainer(k[0],k[1],k[2],k[3],k[4]);
        return x;
    }
}
