public class Deposito extends Rekening implements BerBunga {
    private final double bunga;

    public Deposito(int nomor, String pemilik, double saldo, double bunga) {
        super(nomor, pemilik, saldo);
        this.bunga = bunga;
    }

    @Override
    public boolean tarik(double jumlah) {
        return false;
    }

    @Override
    public double biayaAdmin() { return 0; }

    @Override
    public double hitungBunga() { return saldo * bunga / 100; }

    @Override
    public void terapkanBunga() { saldo += hitungBunga(); }

    @Override
    public String ringkasan() {
        return "Deposito, bunga " + String.valueOf(bunga).replace('.', ',') + "% per bulan";
    }
}