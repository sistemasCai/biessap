package com.biessap.biessap.models;

public class DataSession {

    int id;
    String name;
    String email;
    String avatar;
    String es_premium;
    String dio_psa;

    public DataSession(int id, String name, String email, String avatar, String es_premium, String dio_psa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.es_premium = es_premium;
        this.dio_psa = dio_psa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEs_premium() {
        return es_premium;
    }

    public void setEs_premium(String es_premium) {
        this.es_premium = es_premium;
    }

    public String getDio_psa() {
        return dio_psa;
    }

    public void setDio_psa(String dio_psa) {
        this.dio_psa = dio_psa;
    }

    @Override
    public String toString() {
        return "DataSession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", es_premium='" + es_premium + '\'' +
                ", dio_psa='" + dio_psa + '\'' +
                '}';
    }
}
