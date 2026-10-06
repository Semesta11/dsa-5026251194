import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        
        Set<String> register = new LinkedHashSet<>();
        
        while (sc1.hasNextLine()) {
            String id = sc1.nextLine();
            register.add(id);
        }
        sc1.close();

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        System.out.println("===== Event Check-In Results =====");

        List<String> checkin = new ArrayList<>();

        int rejectedAttempts = 0;

        while (sc2.hasNextLine()) {
            String id = sc2.nextLine();
            if (register.contains(id) && !checkin.contains(id)) {
                System.out.println(id + ": Checked in");
                checkin.add(id);
            }
            else if (register.contains(id) && checkin.contains(id)) {
                System.out.println(id + ": Rejected (already checked in)");
                rejectedAttempts++;
            }
            else if (!register.contains(id)) {
                System.out.println(id + ": Rejected (not registered)");
                rejectedAttempts++;
            }
        }
        sc2.close();
        
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + register.size());
        System.out.println("Successful check-ins: " + checkin.size());
        System.out.println("Absent students: " + (register.size() - checkin.size()));
        System.out.println("Rejected attempts: " + rejectedAttempts);
    }
}
