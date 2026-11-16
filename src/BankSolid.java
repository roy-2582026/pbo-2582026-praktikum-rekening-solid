public class BankSolid {
    public static void main(String[] args) {
        Tabungan t1 = new Tabungan(101, "Ani", 1_000_000, 2.5);
        Tabungan t2 = new Tabungan(102, "Citra", 300_000, 2.0);
        Giro g = new Giro(201, "Budi", 200_000, 500_000);
        Deposito d = new Deposito(301, "Dewi", 5_000_000, 4.0);

        Rekening[] semua = { t1, t2, g, d };
        BerBunga[] berbunga = { t1, t2, d };

        LaporanBank laporan = new LaporanBank();
        ProsesAkhirBulan proses = new ProsesAkhirBulan();

        laporan.cetakDaftar("REKENING AWAL", semua);
        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(semua, 50_000);
        System.out.println();
        laporan.cetakDaftar("REKENING AKHIR", semua);
        laporan.cetakTotal(semua);
    }
}