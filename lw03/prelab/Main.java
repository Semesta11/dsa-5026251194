import java.util.*;

public class Main {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }


    static void problem1() {
        
        List<String> playlist = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] bagian = line.split(" ", 3);
            String operasi = bagian[0];

            if (operasi.equals("ADD")) {
                String lagu = bagian[1];
                playlist.add(lagu);
            }
            else if (operasi.equals("INSERT")) {
                int index = Integer.parseInt(bagian[1]);
                String lagu = bagian[2];

                playlist.add(index, lagu);
            }
            else if (operasi.equals("REMOVE")) {
                String lagu = bagian[1];
                playlist.remove(lagu);
            }
        }
        sc.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i+1) + ": " + playlist.get(i));
        }
    }

    static void problem2() {

        Set<String> participants = new LinkedHashSet<>();

        int duplicateRegistrations = 0;

        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (sc.hasNextLine()) {
            String name = sc.nextLine();

            if (!participants.add(name)) {
                duplicateRegistrations++;
            }
        }
        sc.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int nomor = 1;

        for (String name : participants) {
            System.out.println(nomor + ". " + name);
            nomor++;
        }

        System.out.println("Duplicate registrations: " + duplicateRegistrations);
    }

    static void problem3() {

        Map<String, Integer> inventory = new LinkedHashMap<>();

    int failedSales = 0;

    Scanner sc = new Scanner(
        Main.class.getResourceAsStream("inventory.txt")
    );

    while (sc.hasNextLine()) {
        String line = sc.nextLine();

        String[] bagian = line.split(" ");

        String tipe = bagian[0];
        String produk = bagian[1];
        int jumlah = Integer.parseInt(bagian[2]);

        if (tipe.equals("ADD")) {

            if (!inventory.containsKey(produk)) {
                inventory.put(produk, jumlah);
            }
            else {
                inventory.put(
                    produk,
                    inventory.get(produk) + jumlah
                );
            }

        }

        else if (tipe.equals("SELL")) {

            if (inventory.containsKey(produk)
                    && inventory.get(produk) >= jumlah) {

                inventory.put(
                    produk,
                    inventory.get(produk) - jumlah
                );

            }
            else {
                failedSales++;
            }
        }
    }

    sc.close();

    System.out.println("===== Problem 3 =====");

    for (String produk : inventory.keySet()) {
        System.out.println(produk + ": " + inventory.get(produk));
    }

    System.out.println("Failed sales: " + failedSales);
    }
}