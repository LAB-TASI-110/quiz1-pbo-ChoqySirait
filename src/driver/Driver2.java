import java.util.Scanner;

public class Driver2  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input jumlah data
        int N = sc.nextInt();

        // Array untuk menyimpan nilai
        int[] nilai = new int[N];

        // Input deret nilai
        for (int i = 0; i < N; i++) {
            nilai[i] = sc.nextInt();
        }

        // Input kode kelompok
        String kode = sc.next();

        int total = 0;

        for (int i = 0; i < N; i++) {
            if (kode.equalsIgnoreCase("P") && i % 2 == 0) {
                total += nilai[i];
            } 
            else if (kode.equalsIgnoreCase("L") && i % 2 == 1) {
                total += nilai[i];
            }
        }
        System.out.print("\n");
        System.out.println("Total : " + total);
        System.out.print("\n");

        sc.close();
    }
}