/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.integrationlab4.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Etijah
 */
public abstract class Database {
     protected ArrayList<general> records = new ArrayList<>();
     String filename ;
    abstract protected void  readFromFile() throws FileNotFoundException;

    abstract protected general createRecordFrom (String line);

    ArrayList<general>  returnAllRecords()
    {
        return records;
    }
    public boolean contains (String key)
    {
        for(int i=0;i<records.size();i++)
        {
            if(records.get(i).getSearchKey().equals(key))
            {
                return true;
            }            
        }
        return false;
    }
    
    public general getRecord (String key) 
    {
        for(int i=0;i<records.size();i++)
        {
            if(records.get(i).getSearchKey().equals(key))
            {
                return records.get(i);
            }            
        }
        return null;        
    }
    public void insertRecord (general record) 
    {
        if(this.contains(record.getSearchKey())==false)
            records.add(record);

    }
    public void deleteRecord (String key) 
    {
        var x=this.getRecord(key);
        if(x!=null)
        {
            records.remove(x);
        }
    }
    public void saveToFile() throws IOException
    {
        File f1 = new File(filename);
        FileWriter fr = new FileWriter(f1);
        for(int i=0;i<records.size();i++)
        {
            fr.write(records.get(i).lineRepresentation()+"\n");
        }
        fr.close();    
    }
}
