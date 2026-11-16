public class ProsesAkhirBulan {

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            double biaya = r.biayaAdmin();
            r.kurangiSaldo(biaya);
            System.out.println(r.getNomor() + " biaya admin : " + Rekening.rp(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            double bunga = b.hitungBunga();
            b.terapkanBunga();
            System.out.println(b.getNomor() + " bunga : " + Rekening.rp(bunga));
        }
    }

    public void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening r : semua) {
            boolean ok = r.tarik(jumlah);
            System.out.println(r.getNomor() + " autodebet : " + (ok ? Rekening.rp(jumlah) : "gagal"));
        }
    }
}