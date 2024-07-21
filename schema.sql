CREATE TABLE participants (
     participant_id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255),     email VARCHAR(50), 
     phone_number VARCHAR(255)     )

CREATE TABLE events (
     event_id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255),     date VARCHAR(50), 
     location VARCHAR(255),     
     capacity INT )

CREATE TABLE registration(
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT NOT NULL,
    participant_id INT NOT NULL,
    date Varchar(255) NOT NULL,
    FOREIGN KEY (event_id) REFERENCES events(event_id),
    FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
);