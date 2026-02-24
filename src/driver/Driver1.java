import java.util.Scanner;
import java.util.ArrayList;

public class Driver1 {

    static class ItemPesanan {
        String nama;
        int porsiTotal;
        int hargaSatuan;
        int subTotal;

        ItemPesanan(String nama, int porsiTotal, int hargaSatuan) {
            this.nama = nama;
            this.porsiTotal = porsiTotal;
            this.hargaSatuan = hargaSatuan;
            this.subTotal = porsiTotal * hargaSatuan;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ItemPesanan> keranjang = new ArrayList<>();
        int totalBelanja = 0;

        // Input data
        while (sc.hasNext()) {
            String kode = sc.next();
            if (kode.equalsIgnoreCase("END")) {
                break;
            }

            int porsiButet = sc.nextInt();
            // Aturan spesifik: Ucok 2x porsi Butet. Total = 3 * porsi Butet.
            int totalPorsi = porsiButet * 3;

            String namaMenu = "";
            int hargaMenu = 0;

            switch (kode.toUpperCase()) {
                case "NGS": namaMenu = "Nasi Goreng Spesial"; hargaMenu = 15000; break;
                case "AP":  namaMenu = "Ayam Penyet";          hargaMenu = 20000; break;
                case "SA":  namaMenu = "Sate Ayam (10 Tusuk)"; hargaMenu = 25000; break;
                case "BU":  namaMenu = "Bakso Urat";           hargaMenu = 18000; break;
                case "MAP": namaMenu = "Mie Ayam Pangsit";     hargaMenu = 15000; break;
                case "GG":  namaMenu = "Gado-Gado";            hargaMenu = 15000; break;
                case "SAM": namaMenu = "Soto Ayam";            hargaMenu = 17000; break;
                case "RD":  namaMenu = "Rendang Daging";       hargaMenu = 25000; break;
                case "IB":  namaMenu = "Ikan Bakar";           hargaMenu = 35000; break;
                case "NUK": namaMenu = "Nasi Uduk Komplit";    hargaMenu = 20000; break;
                default: continue;
            }

            ItemPesanan item = new ItemPesanan(namaMenu, totalPorsi, hargaMenu);
            keranjang.add(item);
            totalBelanja += item.subTotal;
        }

        // Penentuan jenis kupon (tidak memotong total belanja)
        String kupon = "Tidak Mendapat Kupon";
        if (totalBelanja >= 500000) kupon = "Kupon Hitam (Diskon 25% untuk kunjungan berikutnya)";
        else if (totalBelanja >= 400000) kupon = "Kupon Hijau (Diskon 20% untuk kunjungan berikutnya)";
        else if (totalBelanja >= 300000) kupon = "Kupon Merah (Diskon 15% untuk kunjungan berikutnya)";
        else if (totalBelanja >= 200000) kupon = "Kupon Kuning (Diskon 10% untuk kunjungan berikutnya)";
        else if (totalBelanja >= 100000) kupon = "Kupon Biru (Diskon 5% untuk kunjungan berikutnya)";

        // Output Struk sesuai spesifikasi gambar
        System.out.printf("\n%-20s %-7s %-10s %-10s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("========================================================");
        
        for (ItemPesanan i : keranjang) {
            System.out.printf("%-20s %-7d %-10d %-10d\n", i.nama, i.porsiTotal, i.hargaSatuan, i.subTotal);
        }
        
        System.out.println("========================================================");
        System.out.printf("%-39s %d\n", "Total Pembayaran:", totalBelanja);
        System.out.println("\nHadiah: " + kupon );
        System.out.println("\n");

        sc.close();
    }
}