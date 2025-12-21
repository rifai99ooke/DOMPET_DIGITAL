import java.util.ArrayList;
public class Wallet {
    private String pemilik;
    private double saldo;
    private String pin;
    private ArrayList<Transaction> riwayatTransaksi;
    private int TransactionCounter;

    public Wallet(String pemilik, String pin){
        this.pemilik = pemilik;
        this.pin = pin;
        this.saldo = 0;
        this.riwayatTransaksi = new ArrayList<>();
        this.TransactionCounter = 1;
    }

    public boolean validatePin(String inputPin){
        return this.pin.equals(inputPin);
    }

    public boolean gantiPin(String pinLama, String pinBaru){
        if(validatePin(pinLama)){
            this.pin = pinBaru;
            System.out.println("\nPin Berhasil Di Ganti");
            return true;
        }
        System.out.println("\nPin Lama Salah");
        return false;
    }

    public boolean topUp(double jumlah, String inputPin){
        if(!validatePin(inputPin)){
            System.out.println("PIN Salah");
            return false;
        }
        if(jumlah <=0) return false;

        this.saldo += jumlah;
        String transid = "TRX" + TransactionCounter++;
        Transaction trx = new Transaction(transid,"TOP_UP", jumlah,"Top Up Saldo");
        riwayatTransaksi.add(trx);
        return true;
    }

    public boolean tarikTunai(double jumlah, String inputPin){
        if (!validatePin(inputPin)){
            System.out.println("\nPIN Salah");
            return false;
        }
        if (jumlah <=0 || jumlah > saldo){

            System.out.println("\nSaldo Tidak Cukup atau Jumlah Tidak Valid");
            return false;
        }
        this.saldo -= jumlah;
        String transid = "TRX" + TransactionCounter++;
        Transaction trx = new Transaction(transid,"TARIK_TUNAI", jumlah, "Tarik Tunai");
        riwayatTransaksi.add(trx);
        return true;
    }

    public boolean transfer(String nomorRekening, double jumlah, String inputPin){
        if (!validatePin(inputPin) || jumlah <=0 || jumlah > saldo) {
            System.out.println("\nTransfer Gagal");
            return false;
        }
        this.saldo -= jumlah;
        String transid = "TRX" + TransactionCounter++;
        TransferTransaction trx = new TransferTransaction(transid, jumlah, nomorRekening);
        riwayatTransaksi.add(trx);
        return true;
    }

    public boolean bayar(String namaMerchant, double jumlah,String inputPin){
        if(!validatePin(inputPin)){
            System.out.println("\nPembayaran Gagal");
            return false;
        }
        this.saldo -= jumlah;
        String transid = "TRX" + TransactionCounter++;
        PaymentTransaction trx = new PaymentTransaction(transid, jumlah , namaMerchant);
        riwayatTransaksi.add(trx);
        return true;
    }

    public void cekSaldo(){
        System.out.println("\n   INFORMASI SALDO   ");
        System.out.println("========================");
        System.out.println("Pemilik :" + pemilik);
        System.out.println("Saldo :" + saldo);
    }

    public void lihatRiwayat(){
        System.out.println("\n   RIWAYAT TRANSAKSI   ");
        if (riwayatTransaksi.isEmpty()){
            System.out.println("Belum ada transaksi");
        } else {
            for(Transaction trx : riwayatTransaksi){
                trx.display();
            }
        }
    }

    public void displayInfo(){
        System.out.println("\n====================");
        System.out.println("     INFO DOMPET     ");
        System.out.println("Pemilik :" + pemilik);
        System.out.println("Saldo :" + saldo);
        System.out.println("Total Transaksi :" + riwayatTransaksi.size());
    }
}
 