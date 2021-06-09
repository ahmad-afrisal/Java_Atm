/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isal;

import java.util.Scanner;

/**
 *
 * @author Asus Gc
 */
public class Main {

    Scanner input = new Scanner(System.in);
    double saldo = 5_000_000;

    public static void main(String[] args) {
        Main atm = new Main();
        System.out.println("\tSelamat Datang ");
        System.out.println("\tDi ATM Bank Isal");
        System.out.println();

        atm.login();
        atm.menu();
    }

    public void login() {
//        Membuat Sistem Login

//
        int statusLogin = 6;

        int counter = 1;
        do {
            System.out.println("============| Login |============");
            System.out.print("No Rek : ");
            String noRek = input.next();
            System.out.print("Pin : ");
            int pin = input.nextInt();
            System.out.println("===========|------------|==========");

            if (noRek.equals("085341995516") && pin == 123456) {
                System.out.println("Login Berhasil....");
                statusLogin = 0;
            } else if (counter == 3) {
                System.out.println("Anda telah salah memasukan Pin \ndan Norek sebanyak 3 kali");
                System.out.println("-ATM Anda Terblokir-");
                keluar();
                System.exit(0);
            } else {
                System.out.println("Mungkin No Rek atau Pin Anda Salah");
                statusLogin = 1;
            }
            counter++;
        } while (statusLogin != 0);
        System.out.println();
    }

    public void menu() {

        System.out.println("=============| Menu |==============");
        System.out.println("|\t[1] Cek Saldo    |");
        System.out.println("|\t[2] Penarikan    |");
        System.out.println("|\t[3] Transfer     |");
        System.out.println("|\t[4] Pembayaran   |");
        System.out.println("|\t[5] Keluar       |");
        System.out.println("===========|------------|==========");

        System.out.print("Pilihan : ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                System.out.println("===========| Sisa Saldo |==========");
                System.out.println("Sisa Saldo  ");
                System.out.println("Rp : " + saldo);
                System.out.println("===========|------------|==========");
                transaksiLagi();
                break;
            case 2:
                penarikan();
                break;
            case 3:
                transfer();
                break;
            case 4:
                pembayaran();
                break;
            case 5:
                keluar();
                break;
            default:
                System.out.println("Maaf yang anda inputkan salah");
                break;
        }

    }

    public void pembayaran() {
        Scanner scan = new Scanner(System.in);
        System.out.println("===========| Pembayaran |============");
        System.out.println("         <Pilih Pembayaran>          ");
        System.out.println("[1] Pulsa 10K          [2] Pulsa 50K");
        System.out.println("[3] Pulsa 25K          [4] Pulsa 100K");
        System.out.println("===========|------------|============");
        System.out.print("Masukan Pilihan : ");
        int pilihan = scan.nextInt();
        switch (pilihan) {
            case 1:
                pulsa(10000);
                break;
            case 2:
                pulsa(25000);
                break;
            case 3:
                pulsa(50000);
                break;
            case 4:
                pulsa(100000);
                break;
            default:
                System.out.println("Inputan Anda salah");
                pembayaran();
                break;
        }

    }

    public void pulsa(int nominalPulsa) {
        Scanner sc = new Scanner(System.in);
        if (nominalPulsa < saldo) {
            System.out.print("Masukan No Telp : ");
            String noTelp = sc.nextLine();
            saldo -= nominalPulsa;
            System.out.println("=========| Status Pembayaran |=======");
            System.out.println("Masukan No Telp : " + nominalPulsa + " Berhasil..");
            System.out.println("Sisa Saldo " + saldo);
            System.out.println("=========| --------------- |=======");
            transaksiLagi();
        } else {
            System.out.println("Salda Ando Tidak Mencukupi");
            transaksiLagi();
        }
    }

    public void penarikan() {
        System.out.println("===========| Tarik Tunai |===========");
        System.out.println("           <Pilih Nominal>           ");
        System.out.println("[1] Rp. 100.000     [2] Rp. 200.000");
        System.out.println("[3] Rp. 500.000     [3] Rp. 1.000.000");
        System.out.println("[4] Rp. 2.000.000   [6] Jumlah Lain");
        System.out.println("===========|------------|============");
        System.out.print("Masukan Pilihan : ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                tarikTunai(100000);
                break;
            case 2:
                tarikTunai(200000);
                break;
            case 3:
                tarikTunai(500000);
                break;
            case 4:
                tarikTunai(1000000);
                break;
            case 5:
                tarikTunai(2000000);
                break;
            case 6:
                System.out.print("Masukan Nominal : ");
                int nominal = input.nextInt();
                tarikTunai(nominal);
                break;
            default:
                penarikan();
                break;
        }
    }

    public void tarikTunai(int nominal) {
        if (nominal > saldo) {
            System.out.println("Maaf, Saldo Anda tidak mencukupi");
        } else if (nominal % 100_000 != 0 || nominal < 100_000) {
            System.out.println("Maaf, harus Kelipatan Rp. 100.000");
        } else if (nominal >= 2_500_000) {
            System.out.println("Maaf, Maksimal Penarikan Rp. 2.500.000");
        } else {
            saldo -= nominal;
            System.out.println("Memproses.....");
            System.out.println("Telah Melakukan Penarikan sebesar : " + nominal);
            System.out.println("Sisa Saldo : " + saldo);
        }
        transaksiLagi();
    }

    public void transfer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("===========| Transfer |===========");
        System.out.print("Masukan No rekening : ");
        String noRek = scan.nextLine();
        System.out.print("Masukan Nominal Transfer : ");
        int transfer = scan.nextInt();
        System.out.println("==========|------------|==========");

        System.out.print("Transfer ? (Y/N) :");
        String check = scan.next();

        if (check.equalsIgnoreCase("Y")) {
            if (transfer > saldo) {
                saldo -= transfer;
                System.out.println("========| Status Transfer |=======");
                System.out.println("Transfer Ke No Rekening : " + noRek + " Berhasil..");
                System.out.println("Sisa Saldo " + saldo);
                System.out.println("========| --------------- |=======");
                transaksiLagi();
            } else {
                System.out.println("Saldo Anda Tidak Mencukupi");
            }
        } else if (check.equalsIgnoreCase("N")) {
            System.out.println("Membatalkan...");
            menu();
        } else {
            System.out.println("Yang anda Inputkan salah");
            transfer();
        }

    }

    public void transaksiLagi() {
        System.out.print("Transaksi Lagi ? [Y/N] ");
        String trans = input.next();
        if (trans.equalsIgnoreCase("Y")) {
            menu();
        } else if (trans.equalsIgnoreCase("N")) {
            keluar();
        } else {
//            Fungsi Rekursif | Memangil Fungsi ini trus menerus
            System.out.println("Maaf, Yang Anda inputkan salah");
            transaksiLagi();
        }
    }

    public void keluar() {
        System.out.println();
        System.out.println("\tTerimakasih telah menggunakan layanan kami.");
        System.out.println("\t      Silahkan Ambil kartu Anda.");
    }
}
