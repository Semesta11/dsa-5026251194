package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(Main.class.getResourceAsStream("washes.txt"));
            int n = sc.nextInt();

            WashService[] washes = new WashService[n];

            for (int i = 0; i < n; i++) {

                String type = sc.next();
                String id = sc.next();
                int days = sc.nextInt();
                int units = sc.nextInt();

                if (type.equals("CAR")) {
                    washes[i] = new CarWash(id, days, units);
                } else if (type.equals("MOTORCYCLE")) {
                    washes[i] = new MotorcycleWash(id, days, units);
                }
            }

                for (WashService wash : washes) {
                    System.out.println(wash.summary());
                    }
           }
}
