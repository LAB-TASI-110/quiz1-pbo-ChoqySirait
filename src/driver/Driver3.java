import java.util.*;

public class Driver3 {

    static class DetailPakaian {
        String nama;
        int jumlah;
        int jumlahLuntur;

        DetailPakaian(String nama, int jumlah) {
            this.nama = nama;
            this.jumlah = jumlah;
            this.jumlahLuntur = 0; // default tidak ada luntur
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("pakaian : ");
        String inputPakaian = sc.nextLine();

        System.out.print("luntur  : ");
        String inputLuntur = sc.nextLine();

        System.out.print("gambar(opsional)  : ");
        String inputGambar = sc.nextLine();

        ArrayList<DetailPakaian> daftar = new ArrayList<>();

        // ==============================
        // Parsing pakaian
        // ==============================
        String[] tokens = inputPakaian.split(" ");

        for (int i = 0; i < tokens.length; i += 2) {
            String nama = tokens[i];
            int jumlah = Integer.parseInt(tokens[i + 1]);

            daftar.add(new DetailPakaian(nama, jumlah));
        }

        // ==============================
        // Parsing luntur (nama jumlah)
        // ==============================
        if (!inputLuntur.trim().isEmpty()) {

            String[] lunturTokens = inputLuntur.split(" ");

            for (int i = 0; i < lunturTokens.length; i += 2) {
                String namaLuntur = lunturTokens[i];
                int jumlahLuntur = Integer.parseInt(lunturTokens[i + 1]);

                for (DetailPakaian p : daftar) {
                    if (p.nama.equals(namaLuntur)) {
                        p.jumlahLuntur = jumlahLuntur;
                    }
                }
            }
        }

        // ==============================
        // OUTPUT
        // ==============================

        int total = 0;

        System.out.println("\n=== Detail ===");

        for (DetailPakaian p : daftar) {

            if (p.jumlahLuntur > 0) {
                System.out.println(p.nama + " " + p.jumlah +
                        " (Luntur " + p.jumlahLuntur + ")");
            } else {
                System.out.println(p.nama + " " + p.jumlah);
            }

            total += p.jumlah;
        }

        System.out.println("Total Pakaian " + total);

        if (!inputGambar.trim().isEmpty()) {
            System.out.println("gambar : " + inputGambar);
        }

        System.out.println("Segera Diproses");
        System.out.println("\nTerimakasih :)\n");

        sc.close();
    }
}