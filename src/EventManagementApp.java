//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.SQLException;
import java.util.Scanner;
public class EventManagementApp {
    public static void main(String[] args) throws SQLException {
        while (true) {
            System.out.println("\nEvent Management System");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Update Event Information");
            System.out.println("4. Delete Event");
            System.out.println("5. Register Participant");
            System.out.println("6. View Participant details");
            System.out.println("7. Update Participant Information");
            System.out.println("8. Delete a Participant");
            System.out.println("9. Register a Participant for the event ");
            System.out.println("10. View Registeration details");
            System.out.println("11. Cancel a Registeration");
            System.out.println("12. View Participants of a event");

            System.out.println("13. Exit");

            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewEvents();
                    break;
                case 3:
                    UpdateEvent();
                    break;
                case 4:
                    deleteEvent();
                    break;
                case 5:
                    RegisterParticipant();
                    break;
                case 6:
                    viewParticipants();
                    break;
                case 7:
                    Updateparticipant();
                    break;
                case 8:
                    deleteParticipant();
                    break;
                case 9:
                    RegisterParticipantforEvent();
                    break;
                case 10:
                    ViewRegisterationDetails();
                    break;
                case 11:
                    CancelRegisteration();
                    break;
                case 12:
                    ViewParticipantsofEvent();
                    break;


                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 12.");
            }
        }
    }

    private static void addEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event date: ");
        String date = scanner.nextLine();
        System.out.print("Enter event location: ");
        String location=scanner.nextLine();
        System.out.print("Enter event capacity ");
        int capacity=scanner.nextInt();
        Event newEvent = new Event(name, date, location, capacity);
        DBconn db = new DBconn();
        int event_id=(db.insertEvent(newEvent));
        System.out.println("Your event Number is "+event_id);

    }

    private static void viewEvents() throws SQLException {
        DBconn db = new DBconn();
        db.getEvents();
    }
    private static void UpdateEvent() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DBconn db = new DBconn();

        System.out.print("Enter event id: ");
        int id=scanner.nextInt();
        System.out.print("1. Event name ");
        System.out.println("2. Event date");
        System.out.println("3. Event location");
        System.out.println("4. Event capacity");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter event name to be updated: ");

                String name = scanner.nextLine();
                db.UpdateEventName(id ,name);
                break;

            case 2:
                System.out.print("Enter event date to be updated: ");

                String date = scanner.nextLine();
                db.UpdateEventDate(id,date);
                break;
            case 3:
                System.out.print("Enter event location to be updated: ");

                String location = scanner.nextLine();
                db.UpdateEventLocation(id,location);
                break;
            case 4:
                System.out.print("Enter event capacity to be updated: ");

                int capacity = scanner.nextInt();
                db.UpdateEventCapacity(id,capacity);

        }
    }

    private static void deleteEvent() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter event number to delete: ");
        int eventid = scanner.nextInt();
        DBconn db=new DBconn();
        db.removeEvent(eventid);
        System.out.println("Event deleted successfully");
    }
    private static void RegisterParticipant() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter participant name: ");
        String name = scanner.nextLine();
        System.out.print("Enter participant email: ");
        String email = scanner.nextLine();
        System.out.print("Enter participant phone number: ");
        String phone = scanner.nextLine();
        Participant newParticipant = new Participant(name, email, phone);
        DBconn db=new DBconn();
        int participant_id=(db.insertParticipant(newParticipant));
        System.out.println("Your Participant Number is "+participant_id);
    }
    private static void viewParticipants() throws SQLException {
        DBconn db = new DBconn();
        db.getParticipants();
    }
    private static void Updateparticipant() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DBconn db = new DBconn();

        System.out.print("Enter participant id: ");
        int id=scanner.nextInt();
        System.out.print("1. Participant name ");
        System.out.println("2. Participant email");
        System.out.println("3. Participant phone number");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter participant name to be updated: ");

                String name = scanner.nextLine();
                db.UpdatePartcipantName(id ,name);
                break;

            case 2:
                System.out.print("Enter event email address to be updated: ");

                String email = scanner.nextLine();
                db.UpdateParticipantEmail(id,email);
                break;
            case 3:
                System.out.print("Enter participant phone number to be updated: ");

                String phone_number = scanner.nextLine();
                db.UpdateEventLocation(id,phone_number);
                break;
        }
    }
    private static void deleteParticipant() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter participant id to delete: ");
        int participantid = scanner.nextInt();
        DBconn db=new DBconn();
        db.removeParticipant(participantid);
        System.out.println("Event deleted successfully");
    }
    private static void RegisterParticipantforEvent() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter participant id to register: ");
        int participantid = scanner.nextInt();
        System.out.println("Enter event id to be registered");
        int eventid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter date ");

        String date = scanner.nextLine();
        Registeration newReg=new Registeration(eventid,participantid,date);
        DBconn db=new DBconn();
        int reg_id=db.registerparticipantforevent(newReg);
        System.out.println("Your Registeration Number is "+reg_id);
    }
    private static void CancelRegisteration() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Registeration id to cancel registeration: ");
        int regid = scanner.nextInt();
        DBconn db=new DBconn();
        db.cancelregisteration(regid);
    }
    private static void ViewRegisterationDetails() throws SQLException
    {
        Scanner scanner=new Scanner(System.in);
        DBconn db=new DBconn();
        db.viewregisterationdetails();
    }
    private static void ViewParticipantsofEvent() throws SQLException
    {
        System.out.println("Enter event_id:");
        Scanner scanner=new Scanner(System.in);
        DBconn db=new DBconn();
        int eventid=scanner.nextInt();
        db.getParticipantsOfEvent(eventid);
    }
}

