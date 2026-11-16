public class LaporanBank {

    public void cetakDaftar(Rekening[] semua) {
        cetakDaftar("REKENING", semua);
    }

    public void cetakDaftar(String judul, Rekening[] semua) {
        System.out.println("========== " + judul + " ==========");
        for (Rekening r : semua) {
            System.out.println(r.getNomor() + " | " + r.getPemilik() + " | "
                    + Rekening.rp(r.getSaldo()));
            System.out.println("    " + r.ringkasan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        double total = 0;
        for (Rekening r : semua) total += r.getSaldo();
        System.out.println("------------------------------------");
        System.out.println("Total dana bank: " + Rekening.rp(total));
    }
}