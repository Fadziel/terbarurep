package com.skripsi23.appubblik.Kelas;

/**
 * Created by Glory on 10/26/2017.
 */

public class UserModel {
    String nama;
    String email;
    String pass;
    String nope;

    public String getNope() {
        return nope;
    }

    public void setNope(String nope) {
        this.nope = nope;
    }

    public UserModel(String nama, String email, String pass, String nope ) {
        this.nama = nama;
        this.email = email;
        this.pass = pass;
        this.nope = nope;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
