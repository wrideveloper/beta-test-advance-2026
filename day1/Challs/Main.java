/**
 * -- WRI Post Finder --
 * 
 * Ini adalah sebuah sistem untuk mencari data postingan.
 * Namun karena masih dalam fase "Beta Testing" kode ini 
 * memiliki keterbatasan:
 * 
 * 1. Tidak dapat menghandle error dengan baik ketika 
 *    keyword tidak ditemukan.
 * 2. Hanya dapat mengambil 1 data pertama saja. Data
 *    yang ditampilkan juga tidak lengkap 
 *    (lihat Posts.java).
 * 
 * Tugas kalian sederhana:
 * 
 * 1. Tambahkan pesan "Postingan tidak ditemukan" jika
 *    hasil search kosong.
 * 2. Tampilkan semua data menggunakan nested loop.
 *    Format bebas.
 * 
 * Tips & Catatan:
 * 
 * 1. No AI:)
 * 2. Fokus ke Main.java saja untuk modifikasi source.
 * 3. Utamakan task 1 (handle the error), task 2 opsional.
 * 
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan keyword pencarian: ");
        String keyword = scanner.nextLine();
    
        Posts result = Handler.fetch(keyword);
    
		// TODO: Modifikasi mulai dari sini
        Post post = result.posts.get(0);
        String uppercaseTitle = post.title.toUpperCase();
        String primaryTag = post.tags.get(0).toLowerCase();
		
        System.out.println("-> Judul Post : " + uppercaseTitle);
        System.out.println("-> Kategori   : #" + primaryTag);
    }
}