public class Tabungan extends Rekening implements BerBunga {
    private final double bunga; // persen per bulan

    public Tabungan(int nomor, String pemilik, double saldo, double bunga) {
        super(nomor, pemilik, saldo);
        this.bunga = bunga;
    }

    @Override
    public boolean tarik(double jumlah) {
        if (jumlah <= 0 || jumlah > saldo) return false;
        saldo -= jumlah;
        return true;
    }

    // Asumsi dari Bab 11: gratis admin jika saldo >= Rp500.000, selain itu Rp5.000
    @Override
    public double biayaAdmin() { return saldo >= 500_000 ? 0 : 5_000; }

    @Override
    public double hitungBunga() { return saldo * bunga / 100; }

    @Override
    public void terapkanBunga() { saldo += hitungBunga(); }

    @Override
    public String ringkasan() {
        return "Tabungan, bunga " + String.valueOf(bunga).replace('.', ',') + "% per bulan";
    }
}