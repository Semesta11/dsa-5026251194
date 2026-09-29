import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> transactions = new LinkedList<>();
        Linkedlist<String[]> foods = new Linkedlist<>();
        Linkedlist<String[]> drinks = new Linkedlist<>();
        Linkedlist<String[]> success = new Linkedlist<>();

        Queue<String[]> queue = new Linkedlist<>();
        
        Stack<String[]> failed = new Stack<>();

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        
        while(scanner.hasNext()) {
            String[] transaction = new String[4];
            transaction[0] = scanner.next();
            transaction[1] = scanner.next();
            transaction[2] = scanner.next();
            transaction[3] = scanner.next();
            transactions.add(transaction);
        }
        scanner.close();

        String [] foods = {2, 1, 2};
        String [] drinks = {4, 2};
        String [] success = null;
        
        queue.addAll(transactions);

        Stack<String[]> failedTransactions = new Stack<>();

        while(!queue.isEmpty()) {
            String[] transaction = queue.poll();

            String name = transaction[0];
            String side_dish = transaction[1];
            String drink = transaction[2];
            int table = Integer.parseInt(transaction[3]);

            Stack<String[]> failed = new Stack<>();

            for (String[] food : foods) {
                if (transaction[1].equals("Bakso" || "Sate" || "Soto")) {
                    int stock = Integer.parseInt(food[1]);
                    if (quantity > 0) {
                        food[1] = String.valueOf(quantity - 1);
                        success.add(transaction);
                    } else {
                        failed.push(transaction);
                    }
                } else if (transaction[2].equals("-")){
                    
                }
            }

            for (String[] drinkItem : drinks) {
                if (transaction[2].equals("EsTeh" || "EsJeruk")) {
                    int quantity = Integer.parseInt(drinkItem[1]);
                    if (quantity > 0) {
                        drinkItem[1] = String.valueOf(quantity - 1);
                        success.add(transaction);
                    } else {
                        failedTransactions.push(transaction);
                    }
                } else if (transaction[2].equals("-")){
                    
                }
            }

            System.out.println("=== Successfully Processed Orders ===");

            for (String[] success : success) {
                System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2] + " " + transaction[3]);       
            }

            System.out.println("=== Remaining Food Stock ===");

            for (String[] foods : food) {
                System.out.println (transaction[1] + " : " + stock);
            }

            System.out.println("=== Remaining Drink Stock  ===");

            for (String[] drinks : drink) {
                System.out.println(transaction[2] + " : " + stock);
            }

            System.out.println("=== Failed Orders ===");

            while (!failed.isEmpty()) {
                String[] failed = failedTransactions.pop();

                System.out.println(
                failed[0] + " "
                + failed[1] + " "
                + failed[2] + " "
                + failed[3]
            );
            }
   
        }
    }
}
