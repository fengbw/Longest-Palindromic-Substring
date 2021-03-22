package com.derek.palindromic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "palin")
public class Palin {
    @Id
    private String origin;
    private String longestpalin;

    public Palin() {}

    public Palin(String origin, String longestpalin) {
        this.origin = origin;
        this.longestpalin = longestpalin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLongestpalin() {
        return longestpalin;
    }

    public void setLongestpalin(String longestpalin) {
        this.longestpalin = longestpalin;
    }

    @Override
    public String toString() {
        return "Palin{" +
                "origin='" + origin + '\'' +
                ", longestPalin='" + longestpalin + '\'' +
                '}';
    }
}
