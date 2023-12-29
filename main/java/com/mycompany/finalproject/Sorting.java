/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.Scanner;

/**
 *
 * @author Ilhamstxr
 */
public class Sorting {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] abjad = {"a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",};
        char huruf_awal, huruf_selanjutnya;
        int idx_h_awal = 0, idx_h_selanjutnya = 0;
        String[] produk = {"mouse", "tws", "keyboard", "mouspead", "earphone", "lanyard"};
        int[] harga = {400000, 150000, 250000, 30000, 50000, 25000};
        int var_sementara_int, pilih;
        String var_sementara, cek;

        do {
            System.out.println("1. sorting harga tertinggi ke terendah");
            System.out.println("2. sorting abjad a-z");
            System.out.println("3. keluar");
            System.out.print("pilih : ");
            pilih = s.nextInt();
            System.out.println("=============================");
            switch (pilih) {
                case 1:

//        harga tertinggi ke terendah
                    for (int i = 0; i < harga.length; i++) {
                        for (int j = 0; j < harga.length - 1; j++) {
                            if (harga[i] > harga[j]) {
                                var_sementara_int = harga[i];
                                var_sementara = produk[i];
                                harga[i] = harga[j];
                                produk[i] = produk[j];
                                harga[j] = var_sementara_int;
                                produk[j] = var_sementara;
                            }
                        }
                    }

                    for (int i = 0; i < harga.length; i++) {
                        System.out.println(produk[i] + ": " + harga[i]);
                    }

                    System.out.println("=============================");
                    System.out.println("apakah ingin sorting ulang?? ");
                    System.out.println("ya / tidak");
                    System.out.println("=============================");
                    System.out.print("pilihan anda: ");
                    cek = s.next();
                    System.out.println("=============================");
                    if (cek.equals("ya")) {
                        pilih = 0;
                    }
                    break;
                case 2:
//                    sorting abjad a - z

                    for (int i = 0; i < produk.length; i++) {
                        for (int j = 0; j < produk.length - 1; j++) {
//                            pencocokan abjad
                            for (int k = 0; k < abjad.length; k++) {
                                huruf_awal = produk[i].charAt(0);
                                huruf_selanjutnya = produk[j].charAt(0);
                                if (abjad[k].equals(String.valueOf(huruf_awal))) {
                                    idx_h_awal = k;
                                }
                                if (abjad[k].equals(String.valueOf(huruf_selanjutnya))) {
                                    idx_h_selanjutnya = k;
                                }
                            }
//                            sorting antar abjad
                            if (idx_h_awal < idx_h_selanjutnya) {
                                var_sementara_int = harga[i];
                                var_sementara = produk[i];
                                harga[i] = harga[j];
                                produk[i] = produk[j];
                                harga[j] = var_sementara_int;
                                produk[j] = var_sementara;
                            }

                        }
                    }

                    for (int i = 0; i < harga.length; i++) {
                        System.out.println(produk[i] + ": " + harga[i]);
                    }
                    System.out.println("=============================");
                    System.out.println("apakah ingin sorting ulang?? ");
                    System.out.println("ya / tidak");
                    System.out.println("=============================");
                    System.out.print("pilihan anda: ");
                    cek = s.next();
                    System.out.println("=============================");
                    if (cek.equals("ya")) {
                        pilih = 0;
                    }
                    break;
            }
        } while (pilih < 1|| pilih > 2);
    }
}
