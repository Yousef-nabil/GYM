package com.mycompany.integrationlab4.backend;

import static com.mycompany.integrationlab4.backend.Status.DUPLICATED;
import static com.mycompany.integrationlab4.backend.Status.NOTFOUND;
import static com.mycompany.integrationlab4.backend.Status.OK;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminRole {

    private TrainerDatabase database;

    public AdminRole() throws FileNotFoundException {
        database = new TrainerDatabase(FileNames.Trainer);
    }

    public Status addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {

        if (database.contains(trainerId)) {
            return DUPLICATED;
        }

        database.insertRecord(database.createRecordFrom(trainerId + "," + name + "," + email + "," + specialty + "," + phoneNumber));
        return OK;
    }

    public ArrayList<general> getListOfTrainers() {
        return database.returnAllRecords();
    }

    public Status removeTrainer(String key) {
        
        var x=database.contains(key);
            if (x) {
                database.deleteRecord(key);
                return OK;
            }
        return NOTFOUND;
    }

    public void logout() throws IOException {
        database.saveToFile();

    }
}
