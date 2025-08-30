/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrationlab4.backend;

/**
 *
 * @author Dell
 */import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ClassDatabase extends Database {
   
    public ClassDatabase(String x) throws FileNotFoundException
    {
        filename=x;
        File f = new File(x);
        Scanner s = new Scanner(f);
        Class c1;
        String temp;      
        while(s.hasNextLine())
        {
            temp=s.nextLine();
            String[] k=temp.split(",");
            c1=new Class(k[0],k[1],k[2],Integer.parseInt(k[3]),Integer.parseInt(k[4]));
            records.add(c1);
        }
    }
    protected void readFromFile() throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        Class c1;
        String temp;      
        while(s.hasNextLine())
        {
            temp=s.nextLine();
            String[] k=temp.split(",");
            c1=new Class(k[0],k[1],k[2],Integer.parseInt(k[3]),Integer.parseInt(k[4]));
            records.add(c1);
        }        
    }
    @Override
    public Class createRecordFrom (String line)
    {
        String[] k=line.split(",");
        var x=new Class(k[0],k[1],k[2],Integer.parseInt(k[3]),Integer.parseInt(k[4]));
        return x;
    }
}
