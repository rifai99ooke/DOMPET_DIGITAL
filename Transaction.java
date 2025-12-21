import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
    protected String transactionid;
    protected String type;
    protected double jumlah;
    protected String keterangan;
    protected LocalDateTime waktu;

    public Transaction(String transactionid, String type, double jumlah, String keterangan) {
        this.transactionid = transactionid;
        this.type = type;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.waktu = LocalDateTime.now();
    }

    public String getFormattedWaktu(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return waktu.format(formatter);
    }

    public void display(){
        System.out.println("==========================");
        System.out.println("ID Transaksi :" + transactionid);
        System.out.println("Tipe :" + type);
        System.out.println("Rp :" + jumlah);
        System.out.println("Keterangan :" + keterangan);
        System.out.println("Waktu :" + getFormattedWaktu());
    }
}
