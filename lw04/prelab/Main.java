import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int M = sc.nextInt();
        int[] targets = new int[M];
        for (int k = 0; k < M; k++) {
            targets[k] = sc.nextInt();
        }
        
        for (int i = 1; i < N && i <= 3; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        for (int k = 0; k < M; k++) {
            int target = targets[k];
            int foundIdx = -1;
            
            for (int i = 0; i < N; i++) {
                if (arr[i] == target) {
                    foundIdx = i;
                    break;
                }
            }
            
            if (foundIdx != -1) {
                System.out.println(target + ": FOUND at index " + foundIdx);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
        sc.close();
    }
}