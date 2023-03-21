package hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hashing {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("dizi kac boyutlu olsun");
		int boyut = input.nextInt();

		table hashTable = new table(boyut);
		File dosya = new File("dosya2.txt");
		Scanner d = new Scanner(dosya);
		Scanner scan = new Scanner(System.in);

		if (!dosya.exists()) {
			System.out.println("dosya bulunamadı!!");
			return;
		}

		while (d.hasNextLine()) {
			int no = d.nextInt();
			String ad = d.next();
			String soyad = d.next();
			hashTable.ekle(no, ad, soyad);
		}
		d.close();
		hashTable.print();

		System.out.println("\n-----------------------");

		System.out.println("tabloda aranan personel numarasını girin..");
		int aranan = input.nextInt();
		hashTable.arama(aranan);

		System.out.println("\n-----------------------");

		System.out.println("silinecek personel numarasını gir..");
		int silinen = input.nextInt();
		hashTable.silme(silinen);
		hashTable.print();

	}
}
