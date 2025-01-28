package com.mycompany.integrationlab4.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRole {

    /*I removed static and I make assignment in constructor*/
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() throws FileNotFoundException {
        memberDatabase = new MemberDatabase("member.txt");
        classDatabase = new ClassDatabase("class.txt");
        registrationDatabase = new MemberClassRegistrationDatabase("regis.txt");

    }

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        memberDatabase.insertRecord(member);
    }

    public ArrayList<general> getListOfMembers() {
        return memberDatabase.returnAllRecords();

    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class temp = new Class(classID, className, trainerID, duration, maxParticipants);
        //Class class1=classDatabase.createRecordFrom(temp.lineRepresentation());
        classDatabase.insertRecord(temp);
    }

    public ArrayList<general> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {

        int adel = 0;
        for (general member : memberDatabase.records) {
            if (member.getSearchKey().equals(memberID)) {
                adel = 1;
            }

        }
        if (adel == 0) {
            return false;
        }
        int flag = 0;
        for (general member_registered : registrationDatabase.records) {
            if (member_registered.getSearchKey().equals(memberID + classID)) {
                MemberClassRegistration u = (MemberClassRegistration) member_registered;
                if ("Cancelled".equals(u.getstatus())) {
                    registrationDatabase.records.remove(member_registered);
                    break;
                }
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            int flagforout = 0;
            for (general c1 : classDatabase.records) {
                if (c1.getSearchKey().equals(classID)) {
                    flagforout = 1;
                    Class temp5 = (Class) c1;
                    if (temp5.getAvailableSeats() > 0) {
                        temp5.setAvailableSeats(temp5.getAvailableSeats() - 1);
                    } else {
                        return false;
                    }
                }

            }
            if (flagforout == 0) {
                return false;
            }
            var y = registrationDatabase.createRecordFrom(memberID + "," + classID + "," + "active" + "," + registrationDate);
            registrationDatabase.insertRecord(y);
            return true;
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        LocalDate l = LocalDate.now();
        for (general member_registered : registrationDatabase.records) {
            MemberClassRegistration temp = (MemberClassRegistration) member_registered;
            String temp2 = memberID + classID;
            if (temp.getSearchKey().equals(temp2)) {
                for (general c1 : classDatabase.records) {
                    if (c1.getSearchKey().equals(classID)) {
                        Class temp5 = (Class) c1;
                        temp5.setAvailableSeats(temp5.getAvailableSeats() + 1);
                    }
                }
                if (-temp.getRegistrationDate().getDayOfMonth() + l.getDayOfMonth() <= 3) {
                    //System.out.println(temp.getRegistrationDate().getDayOfMonth());
                    System.out.println("Refunded");
                } else {
                    return false;
                }
                registrationDatabase.records.remove(member_registered);
                temp = new MemberClassRegistration(temp.getMemberID(), temp.getClassID(), "Cancelled", temp.getRegistrationDate());
                registrationDatabase.records.add(temp);
                return true;
            }
        }
        return false;
    }

    public ArrayList<general> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();

    }

    public void logout() throws IOException {
        classDatabase.saveToFile();
        memberDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }
}
