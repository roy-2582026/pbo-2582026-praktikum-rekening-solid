import java.text.NumberFormat;
import java.util.Locale;

public abstract class Rekening {
    protected final int nomor;
    protected final String pemilik;
    protected double saldo;

    public Rekening(int nomor, String pemilik, double saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public int getNomor() { return nomor; }
    public String getPemilik() { return pemilik; }
    public double getSaldo() { return saldo; }

    public void setor(double jumlah) { saldo += jumlah; }

    /** Kontrak: true jika berhasil, false jika gagal (tidak melempar exception). */
    public abstract boolean tarik(double jumlah);

    public abstract double biayaAdmin();

    public abstract String ringkasan();

    public void kurangiSaldo(double jumlah) { saldo -= jumlah; }

    public static String rp(double nilai) {
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.forLanguageTag("id-ID"));
        return "Rp" + nf.format(Math.round(nilai));
    }
}