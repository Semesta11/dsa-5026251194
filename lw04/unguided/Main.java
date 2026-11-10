import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] targets = new int[m];
        
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();
        
        int[] arr2Pass = new int[n];
        for (int i = 0; i < n; i++) {
            arr2Pass[i] = arr[i];
        }
        bubbleSort(arr2Pass, 2);
        
        int[] sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArr[i] = arr[i];
        }
        bubbleSort(sortedArr, n - 1);
        
        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2Pass[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println();
        
        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < n; i++) {
            System.out.print(sortedArr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println();
        
        System.out.println("==== Search Results ====");
        for (int t : targets) {
            int[] res = binarySearch(sortedArr, t);
            int idx = res[0];
            int steps = res[1];
            
            if (idx != -1) {
                System.out.println(t + ": FOUND at index " + idx + " (steps: " + steps + ")");
            } else {
                System.out.println(t + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }

    static void bubbleSort(int[] a, int passes) {
        int n = a.length;
        for (int i = 0; i < passes && i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    static int[] binarySearch(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int steps = 0;
        
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            
            if (a[mid] == target) {
                return new int[] { mid, steps };
            } else if (a[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return new int[] { -1, steps };
    }
}