package com.mycompany.integrationlab4.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemberDatabase extends Database {

    public MemberDatabase(String x) throws FileNotFoundException
    {
        filename=x;
        readFromFile();
    }
    @Override
    protected void readFromFile() throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        Member m1;
        String temp;      
        while(s.hasNextLine())
        {
            temp=s.nextLine();
            String[] k=temp.split(",");
            m1=new Member(k[0],k[1],k[2],k[3],k[4],k[5]);
            records.add(m1);
        }        
    }
    @Override
    protected Member createRecordFrom (String line)
    {
        String[] k=line.split(",");
        var x=new Member(k[0],k[1],k[2],k[3],k[4],k[5]);
        return x;
    }


}
