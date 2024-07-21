## Prerequisites
- Java Development Kit (JDK) 8 or higher
- SQL Database (MySQL)
- JDBC Driver for your SQL Database

## Installation

1. *Clone the repository:*

   bash

   git clone https://github.com/yourusername/event-management-app.git
   cd EventManagementApp

   windows 

   git clone https://github.com/yourusername/event-management-app.git
   cd EventManagementApp
   

2. *Set up the SQL database:*
   - Create a new database for the application.
   - Execute the provided SQL script (schema.sql) to create the necessary tables.

3. *Configure the database connection:*
   - Open the src/DBconn.java file 
   - Inside the ConnectDB() function
   - Update the database URL, username, and password as per your setup:
     
     url=jdbc:mysql://localhost:3306/your_database_name
     username=your_username
     password=your_password

4.*Download the MySQL Connector jar file*
  - copy the file path of the jar file      

5. *Compile and run the application:*
   bash
   For Compilation javac -cp .:path/to/your/jdbc/mysql-connector-driver.jar     src/*.java
   For Running the Application java -cp :path/to/your/jdbc/driver.jar  src.Mainfilename(The filename  where the main method exists)
   windows 
   For Compilation javac -cp .:path/to/your/jdbc/mysql-connector-driver.jar     src/*.java
   For Running the Application java -cp :path/to/your/jdbc/driver.jar  
src.Mainfilename(The filename  where the main method exists)
   

## Usage



### Event Creation
- Fill in the event details to create a new event.

### Participant Creation
- Participants can register for events through the participant registration.

### Event registeration

- Enter the event ID and participant details to register.
- View the list of created events and participants through the event tracking page.
- Generate reports as needed.

## Database Schema

sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE events (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    date DATE NOT NULL,
    location VARCHAR(100) NOT NULL
);

CREATE TABLE participants (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    FOREIGN KEY (event_id) REFERENCES events(id)
);
