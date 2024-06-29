package main;


import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String islemSecenekleri = "Bakiye Görüntüleme--->1"
                + "  para çekme--->2"
                + "farklı hesaba para yatırma --->3"
                + "Çıkış için q tuşuna basınız";
        Scanner scanner = new Scanner(System.in);

        double yunusBakiye = 2450;
        String yunusIban = "Tr100000000000000000000000000";
        String yunusKullanici = "yunus12";
        String yunusSifre = "1234";

        double emreBakiye = 1200;
        String emreIban = "Tr2000000000000000000000000";
        String emreKullanici = "emre12";
        String emreSifre = "1234";

        System.out.println("ATM'ye hoşgeldiniz");
        System.out.println("Lütfen Bilgilerinizi giriniz");

        System.out.print("Kullanıcı Adı:");
        String kullaniciAdi = scanner.nextLine();

        System.out.print("Şifre:");
        String sifre = scanner.nextLine();

        if (kullaniciAdi.equals("yunus12") && sifre.equals("1234")) {
            System.out.println("Yunus'un hesabına giriş yapıldı");
            System.out.println(islemSecenekleri);

            System.out.print("Lütfen bir seçim yapınız:");
            String secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    System.out.print("Bakiyeniz:" + yunusBakiye);
                    break;
                case "2":
                    System.out.println("Çekmek istediğiniz tutarı giriniz:");
                    int cekilecekTutar = scanner.nextInt();
                    if (yunusBakiye >= cekilecekTutar) {
                        yunusBakiye -= cekilecekTutar;
                        System.out.println("Kalan tutar:" + yunusBakiye);
                    } else {
                        System.out.println("Bakiyenizden fazla para çekemezsiniz");
                    }
                    break;
                case "3":
                    System.out.print("Ne kadar yatırmak istiyorsunuz:");
                    int yatirilacakTutar = scanner.nextInt();
                    scanner.nextLine();  // Boş satırı tüket

                    if (yatirilacakTutar <= yunusBakiye) {
                        System.out.print("IBAN giriniz: ");
                        String yatirilacakIban = scanner.nextLine();

                        if (yatirilacakIban.equals(emreIban)) {
                            System.out.println("Para Emre adlı kişiye yattı");
                            yunusBakiye -= yatirilacakTutar;
                            emreBakiye += yatirilacakTutar;
                        }
                    }
                    break;
            }
        } else if (kullaniciAdi.equals("emre12") && sifre.equals("1234")) {
            System.out.println("Emre'nin hesabına giriş yapıldı..");
            System.out.println(islemSecenekleri);System.out.print("Lütfen bir seçim yapınız:");
            String secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    System.out.print("Bakiyeniz:" + emreBakiye);
                    break;
                case "2":
                    System.out.println("Çekmek istediğiniz tutarı giriniz:");
                    int cekilecekTutar = scanner.nextInt();
                    if (emreBakiye >= cekilecekTutar) {
                    	emreBakiye -= cekilecekTutar;
                        System.out.println("Kalan tutar:" + emreBakiye);
                    } else {
                        System.out.println("Bakiyenizden fazla para çekemezsiniz");
                    }
                    break;
                case "3":
                    System.out.print("Ne kadar yatırmak istiyorsunuz:");
                    int yatirilacakTutar = scanner.nextInt();
                    scanner.nextLine(); 

                    if (yatirilacakTutar <= emreBakiye) {
                        System.out.print("IBAN giriniz: ");
                        String yatirilacakIban = scanner.nextLine();

                        if (yatirilacakIban.equals(yunusIban)) {
                            System.out.println("Para Emre adlı kişiye yattı");
                            emreBakiye -= yatirilacakTutar;
                            yunusBakiye += yatirilacakTutar;
                        }
                    }
                    break;
                    }
            
        } else {
            System.out.println("Kullanıcı adınız veya şifreniz yanlış");
        }

    }
}