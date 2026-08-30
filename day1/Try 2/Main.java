class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private String prodi;

    public Mahasiswa(String nama, String nim, String jurusan, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.prodi = prodi;
    }

	public String getNama() {
		return nama;
	}

	public String getNim() {
		return nim;
	}

	public String getJurusan() {
		return jurusan;
	}

	public String getProdi() {
		return prodi;
	}

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                ", prodi='" + prodi + '\'' +
                '}';
    }
}

class ListMhs {
    private Mahasiswa[] data;

    public ListMhs() {
        this.data = new Mahasiswa[0];
    }

    public void add(Mahasiswa mhsBaru) {
        Mahasiswa[] newArray = new Mahasiswa[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        newArray[data.length] = mhsBaru;
        this.data = newArray;
    }

    public int size() {
        return this.data.length;
    }

    public Mahasiswa get(int index) {
        return this.data[index];
    }

    public void tampilkanData() {
        for (int i = 0; i < data.length; i++) {
            System.out.println("[" + i + "] " + data[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
		// Inisialisasi data mahasiswa
        ListMhs listMhs = new ListMhs();

        listMhs.add(new Mahasiswa("Budi Santoso", "21001", "Teknik Elektro", "Informatika"));
        listMhs.add(new Mahasiswa("Siti Rahma", "21002", "Teknik Elektro", "Sistem Informasi"));
        listMhs.add(new Mahasiswa("Andi Wijaya", "21003", "Teknik Mesin", "Teknik Mesin"));

		// Dapatkan Total Mahasiswa
        System.out.println("Total Mahasiswa: " + listMhs.size());
		System.out.println();

		// Dapatkan nama mahasiswa ke-2
		System.out.printf("Mahasiswa ke-2: %s \n", listMhs.get(1).getNama());
		System.out.println();

		// Cetak semua mahasiswa
        System.out.println("--- Daftar Mahasiswa ---");
        listMhs.tampilkanData();
    }
}