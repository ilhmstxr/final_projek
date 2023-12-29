/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 *
 * @author Ilhamstxr
 */
public class fpjava {

    private static final String file_path = "src/resources/";
    private static final String file_username = "username.txt";
    private static final String file_password = "password.txt";
    private static final String file_role = "role.txt";
    private static final String file_barang = "barang.txt";
    private static final String file_harga = "harga.txt";
    private static final String file_stok = "stok.txt";

    static String divider = "=====================================================";
    static String line = "-----------------------------------------------------";
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int menu = 1;
        ArrayList<String> data_username = new ArrayList<>();
        ArrayList<Integer> data_password = new ArrayList<>();
        ArrayList<String> data_role = new ArrayList<>();
        ArrayList<String> barang = new ArrayList<>();
        ArrayList<Integer> harga = new ArrayList<>();
        ArrayList<Integer> stok = new ArrayList<>();
        ArrayList<String[]> keranjang = new ArrayList<>();
        readData(data_username, data_password, data_role, barang, harga, stok);

//        login
        menu(menu, data_username, data_password, data_role, barang, harga, stok, keranjang);
//        daftar menu
        menu(menu, data_username, data_password, data_role, barang, harga, stok, keranjang);

    }

    static void menu(int menu, ArrayList<String> data_username, ArrayList<Integer> data_password,
            ArrayList<String> data_role, ArrayList<String> barang, ArrayList<Integer> harga, ArrayList<Integer> stok, ArrayList<String[]> keranjang) {
        boolean login = false;
        int user_idx = -1;
//        menu regist
        if (menu == 1) {
            boolean ulang = false;
            boolean menu_ulang = false;
            int pilih = 0;

            do {
                String username, buat;
                int password;
                boolean pass = false, found = false;
                int panjang_pass;
                if (pilih == 0) {
                    System.out.println(divider + "\n");
                    System.out.println("== login ==");
                    System.out.println(divider);
                    System.out.println("1. login");
                    System.out.println("2. register");
                    System.out.println("3. keluar");
                    System.out.print("Pilih: ");
                    pilih = s.nextInt();
                    System.out.println(divider);
                }
                switch (pilih) {
                    case 1:
                        do {
                            System.out.println("ketik 'k' untuk membatalkan login");
                            System.out.print("Username: ");
                            username = s.next();
                            if (username.equals("k")) {
                                menu_ulang = true;
                                pilih = 0;
                                break;
                            }
                            System.out.print("Password: ");
                            password = s.nextInt();

//                        mengecek panjang password
                            String cek_panjang = Integer.toString(password);
                            panjang_pass = cek_panjang.length();
                            if (panjang_pass > 5) {
                                for (int i = 0; i < data_username.size(); i++) {
                                    if (username.equals(data_username.get(i))) {

                                        if (password == data_password.get(i)) {
                                            found = true;
                                            login = true;
                                            pass = true;
                                            menu_ulang = false;
                                            user_idx = i;
                                            System.out.println(line);
                                            System.out.println("Berhasil login!");
                                            System.out.println(line);
                                            System.out.println(divider);
                                            break;
                                        } else {
                                            pass = false;
                                            System.out.println("Password salah. Silahkan coba lagi.");
                                        }
                                    }
                                }
                                if (!found) {
                                    System.out.println(line);
                                    System.out.println("not found");
                                    System.out.println("data Tidak ditemukan");
                                }
                            } else {
                                System.out.println(line);
                                System.out.println("password setidaknya 6 karakter!");
                                System.out.println(line);
                            }

                        } while (pass == false);
                        break;
                    case 2:
                        do {
                            System.out.println(divider);
                            System.out.println("== Buat akun ==");
                            System.out.print("Input new Username: ");
                            username = s.next();
                            System.out.print("input new Password: ");
                            password = s.nextInt();

//                        mengecek panjang password
                            String cek_panjang = Integer.toString(password);
                            panjang_pass = cek_panjang.length();
                            if (panjang_pass < 5) {
                                System.out.println(line);
                                System.out.println("Password setidaknya 6 karakter");
                                System.out.println(line);

                            } else {
                                System.out.print("Confirm new Password: ");
                                int cek_password = s.nextInt();
                                if (cek_password == password) {
                                    System.out.println("akun telah dibuat!");
                                    pass = true;
                                    ulang = false;
                                } else {
                                    System.out.println(line);
                                    System.out.println("konfirmasi password tidak cocok!");
                                    System.out.println(line);
                                }
                            }
                            if (pass == true) {
                                System.out.println(divider);
                                writeData(username, password);
                                readData(data_username, data_password, data_role, barang, harga, stok);
                                pilih = 0;
                            }
                        } while (pass == false);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
                

            } while (menu_ulang == true);

        }

//        jika login berhasil
        if (login == true) {
            int pilih;

            do {
                String kataKunci = "";

                System.out.println(divider);
                System.out.println("Menu");
                System.out.println(line);
                System.out.println("1. List Barang");
                System.out.println("2. Cari Barang");
                System.out.println("3. Keranjang");
                System.out.println("4. Pembayaran");
                System.out.println("5. Keluar");
                System.out.print("pilih: ");
                pilih = s.nextInt();
                System.out.println(line);
                switch (pilih) {
                    case 1:
                        System.out.println("List Barang");
                        System.out.println(line);
                        System.out.println(barang.size());
                        for (int i = 0; i < barang.size(); i++) {
                            if (stok.get(i) == 0) {
                                System.out.printf("%-20s %-10s Stok: %s%n", barang.get(i), harga.get(i), "Stok kosong");
                            } else {
                                System.out.printf("%-20s %-10s Stok: %s%n", barang.get(i), harga.get(i), stok.get(i));
                            }
                        }

                        System.out.println("Ketik nama Barang yang ingin dibeli");
                        System.out.println("Ketik 'k' untuk keluar");
                        s.nextLine();
                        kataKunci = s.nextLine();
                        if (!"k".equals(kataKunci)) {
                            System.out.println(line);
                            searchBarang(kataKunci, barang, harga, stok, keranjang);
                            System.out.println(line);
                        }
                        break;
                    case 2:
                        System.out.println("Ketik nama Barang");
                        System.out.println("Ketik 'k' untuk keluar");
                        s.nextLine();
                        kataKunci = s.nextLine();
                        if (!"k".equals(kataKunci)) {
                            System.out.println(line);
                            searchBarang(kataKunci, barang, harga, stok, keranjang);
                            System.out.println(line);
                        }
                        break;
                    case 3:
                        System.out.println("jumlah macam barang yang dibeli: " + keranjang.size());
                        for (int i = 0; i < keranjang.size(); i++) {
                            if (keranjang.isEmpty()) {
                                System.out.println("Keranjang masih kosong!");
                            } else {
                                String namaBarang = keranjang.get(i)[0];
                                int qty = Integer.parseInt(keranjang.get(i)[1]);
                                int subtotal = Integer.parseInt(keranjang.get(i)[2]);
                                System.out.printf("%-20s x%-10s Subtotal: %s%n", namaBarang, qty, subtotal);
                            }
                        }
                        break;
                    case 4:
                        int total_bayar = 0;
                        System.out.println(divider);
                        for (int i = 0; i < keranjang.size(); i++) {
                            String namaBarang = keranjang.get(i)[0];
                            int qty = Integer.parseInt(keranjang.get(i)[1]);
                            int subtotal = Integer.parseInt(keranjang.get(i)[2]);
                            total_bayar += subtotal;
                            System.out.printf("%-20s %-10s Subtotal: Rp. %s%n", namaBarang, qty, subtotal);
                        }

                        System.out.println(line);
                        System.out.println("Total Bayar: " + total_bayar);
                        int uang_pembeli = 0;
                        while (uang_pembeli < total_bayar) {
                            System.out.print("Uang anda: ");
                            uang_pembeli = s.nextInt();
                            if (uang_pembeli < total_bayar) {
                                System.out.println("Maaf uang yang anda masukkan kurang");
                            } else {
                                int kembalian = uang_pembeli - total_bayar;
                                if (kembalian == 0) {
                                    System.out.println("uang anda pas");
                                } else {
                                    System.out.println("kembalian anda adalah: " + kembalian);
                                }
                            }
                        }
                        System.out.println(divider);
                        break;
                }
                if (pilih > 5 || pilih < 1) {
                    System.out.println("pilihan tidak ada silahkan pilih ulang");
                }
            } while (pilih != 5);
        }
    }

    static void tambahBarang(ArrayList<String[]> keranjang, String namaBarang, Integer qty, Integer hargaBarang) {
        String[] infoBarang = new String[3];
        int subtotal = qty * hargaBarang;

        infoBarang[0] = namaBarang;
        infoBarang[1] = Integer.toString(qty);
        infoBarang[2] = Integer.toString(subtotal);
        keranjang.add(infoBarang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    static void searchBarang(String kataKunci, ArrayList<String> barang, ArrayList<Integer> harga, ArrayList<Integer> stok, ArrayList<String[]> keranjang) {
        int jumlahCocok = 0;
        String cek;
        for (int i = 0; i < barang.size(); i++) {
            int stokBarang = stok.get(i);
            boolean issimilar = barang.get(i).toLowerCase().contains(kataKunci.toLowerCase());
            if (issimilar) {
                jumlahCocok++;
                if (stokBarang == 0) {
                    System.out.printf("%-20s %-10s Stok: %s%n", barang.get(i), harga.get(i), "Stok kosong");
                } else {
                    System.out.printf("%-20s %-10s Stok: %s%n", barang.get(i), harga.get(i), stokBarang);
                }

                if (jumlahCocok == 1 && stokBarang != 0) {
                    System.out.println("apakah ingin membeli barang tersebut?");
                    System.out.println("ya / tidak");
                    cek = s.next();
                    if (cek.equals("ya")) {
                        System.out.println("Masukkan jumlah barang yang ingin dibeli");
                        int qty = s.nextInt();
                        int hargaBarang = harga.get(i);
                        tambahBarang(keranjang, barang.get(i), qty, hargaBarang);
                        stokBarang -= qty;
                        stok.set(i, stokBarang);
                    }
                }
            }
        }
    }

    static void writeData(String username, Integer password) {
//        menulis data username

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_path + file_username, true));
            writer.newLine();
            writer.write(username);
            writer.close();
            System.out.println(username + " telah ditambahkan! ");
        } catch (IOException e) {
        }

//        menulis data password
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_path + file_password, true));
            writer.newLine();
            writer.write(Integer.toString(password));
            writer.close();

        } catch (IOException e) {
        }

//        menulis data role
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_path + file_role, true));
            writer.newLine();
            writer.write("user");
            writer.close();

        } catch (IOException e) {

        }
    }

    static void readData(ArrayList<String> data_username, ArrayList<Integer> data_password,
            ArrayList<String> data_role, ArrayList<String> barang, ArrayList<Integer> harga, ArrayList<Integer> stok) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path + file_username))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                data_username.add(line);
            }
        } catch (IOException e) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path + file_password))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                int password = Integer.parseInt(line);
                data_password.add(password);
            }
        } catch (IOException e) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path + file_role))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                data_role.add(line);
            }
        } catch (IOException e) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path + file_barang))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                barang.add(line);
            }
        } catch (IOException e) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path + file_stok))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                int stock = Integer.parseInt(line);
                stok.add(stock);
            }
        } catch (IOException e) {
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file_path + file_harga))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                int price = Integer.parseInt(line);
                harga.add(price);
            }
        } catch (IOException e) {
        }
    }

}
