import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("   APLIKASI DOMPET DIGITAL   ");
        System.out.println("\n---SETUP DOMPET BARU---");
        System.out.println("Masukkan Nama Anda: ");
        String nama = scanner.nextLine();
        System.out.println("Buat PIN (6 Digit): ");
        String pin = scanner.nextLine();

        Wallet dompet = new Wallet(nama,pin);
        System.out.println("\nDompet Digital Anda Berhasil Dibuat");
        System.out.println("Selamat Datang," + nama + "!");

        boolean running = true;
        while(running){
            System.out.println("\n   MENU UTAMA   ");
            System.out.println("===================");
            System.out.println("1.Cek Saldo");
            System.out.println("2.Top Up");
            System.out.println("3.Tarik Tunai");
            System.out.println("4.Transfer (Inheritance)");
            System.out.println("5.Bayar/ Pembayaran (Inheritance)");
            System.out.println("6.Riwayat Transaksi");
            System.out.println("7.Info Dompet");
            System.out.println("0.Keluar");
            System.out.println("====================");
            System.out.println("Pilih Menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    dompet.cekSaldo();
                    break;
                case 2:
                    System.out.println("\n-----TOP UP SALDO-----");
                    System.out.println("Jumlah top up: Rp");
                    double jumlahTopup = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("MAsukkah PIN: ");
                    String pinTopUP = scanner.nextLine();
                    dompet.topUp(jumlahTopup, pinTopUP);
                    break;
                case 3:
                    System.out.println("\n-----TARIK TUNAI----");
                    System.out.println("Jumlah Tarik Tunai: Rp");
                    double jumlahTarik = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Masukkan PIN: ");
                    String pinTarik = scanner.nextLine();
                    dompet.tarikTunai(jumlahTarik, pinTarik);
                    break;
                case 4:
                    System.out.println("\n-----TRANSFER-----");
                    System.out.println("Nomor Rekening Tujuan: ");
                    String noRek = scanner.nextLine();
                    System.out.println("Jumlah Trasfer: Rp ");
                    double jumlahTransfer = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Masukkan PIN: ");
                    String pinTransfer = scanner.nextLine();
                    dompet.transfer(noRek, jumlahTransfer, pinTransfer);
                    break; 
                case 5:
                    System.out.println("\n-----PEMBAYARAN-----");
                    System.out.println("Nama Toko: ");
                    String merchant = scanner.nextLine();
                    System.out.println("Jumlah Bayar: Rp ");
                    double jumlahbayar = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Masukkan PIN: ");
                    String pinBayar = scanner.nextLine();
                    dompet.bayar(merchant, jumlahbayar, pinBayar);
break;
                case 6:
                    dompet.lihatRiwayat();
                    break;
                case 7:
                    dompet.displayInfo();
                    break;
                case 8:
                    System.out.println("\n-----GANTI PIN-----");
                    System.out.println("PIN Lama: ");
                    String pinLama = scanner.nextLine();
                    System.out.println("PIN Baru: ");
                    String pinBaru = scanner.nextLine();
                    dompet.gantiPin(pinLama, pinBaru);
                    break;
                case 0:
                    System.out.println("\nTERIMA KASIH TELAH MENGGUNAKAN DOMPET DIGITAL");
                    running = false;
                    break;
                default:
                    System.out.println("\nPilihan Tidak Valid!");
                    break;
            }
        }
        scanner.close();
    }
    
}
