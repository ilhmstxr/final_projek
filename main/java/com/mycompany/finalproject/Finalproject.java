/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.finalproject;

import java.util.Scanner;

/**
 *
 * @author Ilhamstxr
 */
public class Finalproject {

    private static int cari_barang(String[] makanan, int[] harga, String cari) {
        int index_ketemu = makanan.length;
        boolean ketemu = false;

        for (int i = 0; i < makanan.length; i++) {
            if (makanan[i].contains(cari.toLowerCase())) {
                ketemu = true;
                System.out.println((i) + " " + makanan[i] + " Rp." + harga[i]);
                index_ketemu = i;
            }
        }

        return index_ketemu;
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String makanan[] = {"a", "b", "c"};
        int harga[] = {1, 2, 3};

        int pilihan_user = 0;
        int pilihan_menu = 0;
        int jumlah_beli = 0;
        int total_bayar = 0;
        int uang_pembeli = 0;
        int kembalian = 0;
        int index_ketemu = makanan.length;

        String cari;

        System.out.println("--------------- Swsmat dwatang ---------------");
        do {
            System.out.println("1. Kasir");
            System.out.println("2. Admin");
            System.out.println("3. Owner");
            System.out.println("Masukkan Pilihan: ");
            pilihan_user = s.nextInt();
            switch (pilihan_user) {
                case 1:
                    do {
//                        menu kasir
                        System.out.println("==== menu kasir ====");
                        System.out.println("1. cari barang");
                        System.out.println("2. buat pesanan");
                        System.out.println("3. exit");
                        System.out.println("masukkan pilihan");

//                        disimpan di variable menu
                        pilihan_menu = s.nextInt();
                        switch (pilihan_menu) {
                            case 1:
                                cari = "";
                                while (!"k".equals(cari)) {
                                    System.out.println("ketik k untuk keluar");
                                    System.out.println("cari barang");
                                    s.nextLine();
                                    cari = s.nextLine();
                                    if (!"k".equals(cari)) {
                                        System.out.println("");
                                        index_ketemu = cari_barang(makanan, harga, cari);
                                        jumlah_beli = s.nextInt();
                                        total_bayar = +harga[pilihan_menu] & jumlah_beli;
                                        System.out.println("barang added");

                                    }
                                }
                                break;
                            case 2:
                                System.out.println("");
                                System.out.println("Total Bayar: " + total_bayar);
                                while (uang_pembeli < total_bayar) {
                                    System.out.println("Masukkan uang: ");
                                    uang_pembeli = s.nextInt();
                                    if (uang_pembeli < total_bayar) {
                                        System.out.println("Maaf uang yang anda masukkan kurang");
                                    } else {
                                        kembalian = total_bayar - uang_pembeli;
                                        if (kembalian == 0) {
                                            System.out.println("uang anda pas");
                                        } else {
                                            System.out.println("kembalian anda adalah: " + kembalian);
                                        }
                                    }

                                }
                                break;
                        }

                    } while (pilihan_user != 3);
            }
        } while (pilihan_user != 4);
    }
}
