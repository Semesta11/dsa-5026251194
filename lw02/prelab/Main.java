import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<String[]> transactions = new LinkedList<>();

        LinkedList<String[]> customers = new LinkedList<>();

        
            Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                String[] transaction = line.split(" ");

                transactions.add(transaction);

                String customerName = transaction[0];

                boolean customerExists = false;

                for (String[] customer : customers) {

                    if (customer[0].equals(customerName)) {
                        customerExists = true;
                        break;
                    }
                }

                if (!customerExists) {

                    String[] customer = {
                        customerName,
                        "0"
                    };

                    customers.add(customer);
                }
            }

            sc.close();

        Queue<String[]> queue = new LinkedList<>();

        while (!transactions.isEmpty()) {

            queue.offer(transactions.removeFirst());
        }

        Stack<String[]> failedTransactions = new Stack<>();

        while (!queue.isEmpty()) {

            String[] transaction = queue.poll();

            String customerName = transaction[0];
            String transactionType = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (String[] customer : customers) {

                if (customer[0].equals(customerName)) {

                    int balance = Integer.parseInt(customer[1]);

                    if (transactionType.equals("DEPOSIT")) {

                        balance += amount;

                    }

                    else if (transactionType.equals("WITHDRAW")) {

                        if (amount > balance) {

                            failedTransactions.push(transaction);

                            break;

                        } else {

                            balance -= amount;
                        }
                    }

                    customer[1] = String.valueOf(balance);

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");

        for (String[] customer : customers) {

            System.out.println(
                customer[0] + " : " + customer[1]
            );
        }

        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {

            String[] failed = failedTransactions.pop();

            System.out.println(
                failed[0] + " "
                + failed[1] + " "
                + failed[2]
            );
        }
    }
}