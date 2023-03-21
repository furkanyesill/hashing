package hashing;

public class node {
	int musteri_no;
	String ad, soyad;
	node next;

	public node() {
		next = null;
	}

	public node(int musteri_no, String ad, String soyad) {
		this.musteri_no = musteri_no;
		this.ad = ad;
		this.soyad = soyad;
	}

}
