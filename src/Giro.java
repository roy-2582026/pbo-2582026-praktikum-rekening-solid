public class Giro extends Rekening {
    private final double batasOverdraft;

    public Giro(int nomor, String pemilik, double saldo, double batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public boolean tarik(double jumlah) {
        if (jumlah <= 0 || saldo - jumlah < -batasOverdraft) return false;
        saldo -= jumlah;
        return true;
    }

    @Override
    public double biayaAdmin() { return 15_000; }

    @Override
    public String ringkasan() {
        return "Giro, batas overdraft " + rp(batasOverdraft);
    }
}