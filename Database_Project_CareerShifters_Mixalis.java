import java.util.prefs.Preferences;


//to ekana mesw onecompiler to site // ta arxika create database / show /use
// ta egrapsa monos mou giati epairne mono create table kateutheian

public class Database_Project_CareerShifters_Mixalis {
    create database DatabaseProject_CareerShifter_Mixalis;

    show database;

    use DatabaseProject_CareerShifter_Mixalis;

    create table Property (
            Property_ID INT AUTO_INCREMENT PRIMARY KEY,
            Property_Type VARCHAR(20) NOT NULL, --office,house,apartment
    Address VARCHAR(100) ,
    City VARCHAR(50)NOT NULL,
    ZIP_Code VARCHAR(5),
    Sq_F INT,
    Rooms INT,
    Features TEXT, --parking,pool
    Availability VARCHAR(10), --sold,rented
    Price DOUBLE,
    Agent_ID INT,
    FOREIGN KEY (Agent_ID) REFERENCES Agents(Agent_ID)
            );

    create table Clients (
            Client_ID INT AUTO_INCREMENT PRIMARY KEY,
            Client_Type VARCHAR(10) NOT NULL,  -- byer,seller,renter
    Name VARCHAR(100),  --info
    Phone VARCHAR(15),
    Email VARCHAR(100),
    Address varchar(100)
    Budget_range DOUBLE, --Preferences
    Notes_On_Interaction TEXT
);

    create table Agents (
            Agent_ID INT AUTO_INCREMENT PRIMARY KEY,
            Name VARCHAR(100),
    Phone VARCHAR(15),
    Email VARCHAR(100),
    Assigned_Clients INT,
    Assigned_Properties INT,
    Properties_Sold int,
    Properties_Rented int,
    Commission DOUBLE
);


    create table Transactions (
            Transaction_ID INT AUTO_INCREMENT PRIMARY KEY,
            Transaction_Type VARCHAR(50) , --sale/rental
    Property_ID INT,
    Client_ID INT,
    Sales_Price DOUBLE,
    Rental_Fee DOUBLE,
    Commission_Amount DOUBLE,
    Payment_Schedule TEXT,
    Status VARCHAR(20), --completed,in-progress
    Agent_ID INT,
    FOREIGN KEY (Property_ID) REFERENCES Properties(Property_ID),
    FOREIGN KEY (Client_ID) REFERENCES Clients(Client_ID),
    FOREIGN KEY (Agent_ID) REFERENCES Agents(Agent_ID)
            );



}
