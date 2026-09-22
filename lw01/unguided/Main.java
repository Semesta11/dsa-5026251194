package lw01.unguided;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(Main.class.getResourceAsStream("washes.txt"));
            int n = sc.nextInt();

            WashService[] washes = new WashService(n);

            while (sc.hasNext()) {
                String type = sc.next();
                String id = sc.next();
                int days = sc.nextInt();
                int units = sc.nextInt();

                if (type.equals("CAR")) {
                    washes[i].add(new CarWash(id, days));
                } else if (type.equals("MOTORCYCLE")) {
                    washes[i].add(new MotorcycleWash(id, days));
                }

                for (WashService wash : washes) {
                    System.out.println(wash.summary());
                    }
            }
    }
}
