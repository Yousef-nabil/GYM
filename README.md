# Gym Membership Management System

This project is a Gym Membership Management System. The system is designed to manage gym members, trainers, classes, and registrations through a graphical user interface (GUI) built using java swing.

## Project Overview

The Gym Membership Management System allows two types of users to interact with the system:
- **Admin**: Can add, view, and remove trainers.
- **Trainer**: Can add members, view members, add classes, view classes, register members for classes, cancel registrations, and view registrations.

The system is built using Java and follows a structured approach with three main packages:
1. **backend**: Contains all the core classes and logic for managing trainers, members, classes, and registrations.
2. **frontend**: Contains the GUI components that allow users to interact with the system.
3. **constants**: Contains interfaces for file names and login credentials.

## Features

### Admin Features
- **Admin Login**: Admins can log in using predefined credentials.
- **Add Trainer**: Admins can add new trainers to the system.
- **View Trainers**: Admins can view a list of all trainers.
- **Remove Trainer**: Admins can remove trainers from the system.

### Trainer Features
- **Trainer Login**: Trainers can log in using predefined credentials.
- **Add Member**: Trainers can add new gym members.
- **View Members**: Trainers can view a list of all gym members.
- **Add Class**: Trainers can add new gym classes.
- **View Classes**: Trainers can view a list of all gym classes.
- **Register Member for Class**: Trainers can register members for specific classes.
- **Cancel Registration**: Trainers can cancel a member's registration for a class.
- **View Registrations**: Trainers can view all registrations.

### File Handling
- All data related to trainers, members, classes, and registrations are saved to and read from text files (`Trainers.txt`, `Members.txt`, `Class.txt`, `Registration.txt`).

### Validation
- The system ensures that only unique trainer IDs are added.
- Members must be registered with valid details (all fields filled).
- Class registration only occurs if there are available seats.
- Admin and Trainer login credentials are validated.

## How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/gym-membership-management-system.git
