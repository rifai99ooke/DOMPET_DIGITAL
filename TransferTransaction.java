public class TransferTransaction extends Transaction {

    private String nomorTujuan;
    
    public TransferTransaction(String transactionid, double jumlah, String nomorTujuan) {
        super(transactionid, "TRANSFER", jumlah, "Transfer ke" + nomorTujuan);
        this.nomorTujuan = nomorTujuan;
    } 

    @Override
    public void display(){
        super.display();
        System.out.println("Tujuan :" + nomorTujuan);
    }
}

