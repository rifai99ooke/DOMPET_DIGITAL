public class PaymentTransaction extends Transaction {

    private String namaMerchant;

    public PaymentTransaction(String transactionid,double jumlah, String namaMerchant ){
        super(transactionid, "PEMBAYARAN",jumlah, "bayar ke" + namaMerchant);
        this.namaMerchant = namaMerchant;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Merchant :" + namaMerchant);
    }
}
