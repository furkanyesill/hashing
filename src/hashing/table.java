package hashing;

public class table {
	node dizi[];
	int size;

	public table(int size) {
		this.size = size;
		dizi = new node[size];
		for (int i = 0; i < size; i++) {
			dizi[i] = new node();
		}
	}

	int index(int key) {
		return key % size;
	}

	void ekle(int no, String ad, String soyad) {
		int index = index(no);
		node eleman = new node(no, ad, soyad);
		node temp = dizi[index];

		if (temp.next == null)
			temp.next = eleman;

		else {
			while (temp.next != null) {
				if (temp.next.musteri_no > eleman.musteri_no) {
					node iter;
					iter = temp.next;
					temp.next = eleman;
					eleman.next = iter;
					break;
				}

				temp = temp.next;
				if (temp.musteri_no < eleman.musteri_no) {
					temp.next = eleman;
					break;
				}

			}

		}
	}

	void arama(int no) {
		int kontrol = 0;
		for (int i = 0; i < size; i++) {
			node temp = dizi[i];
			if (temp != null) {
				while (temp.next != null) {
					temp = temp.next;
					if (temp.musteri_no == no) {
						kontrol = 1;
						System.out.println("aranan eleman dizi[" + i + "] de bulundu..");
						break;
					}

				}

			}

		}
		System.out.println();
		if (kontrol == 0) {
			System.out.println("aranan eleman yoktur..");
		}

	}

	void silme(int no) {
		node iter, iter2;
		int kontrol = 0;
		for (int i = 0; i < size; i++) {
			node temp = dizi[i];
			if (temp != null) {
				while (temp.next != null) {
					iter2 = temp;
					temp = temp.next;
					if (temp.musteri_no == no) {
						kontrol = 1;
						iter = temp.next;
						free(temp);
						iter2.next = iter;
						break;
					}

				}

			}

		}
		if (kontrol == 0) {
			System.out.println("aranan personel bulunamadı");
		}

	}

	private void free(node temp) {
		// TODO Auto-generated method stub

	}

	void print() {
		System.out.println("------------ TABLO ----------------");
		System.out.print("Dizi   Numara   Ad    Soyad" + "\n");
		for (int i = 0; i < size; i++) {
			node temp = dizi[i];
			if (temp != null) {
				System.out.print("dizi[" + i + "]  ");
				while (temp.next != null) {
					temp = temp.next;
					System.out.print(temp.musteri_no + " -> " + temp.ad + "  " + temp.soyad + "  ");

				}

			}
			System.out.println();
		}
	}
}
