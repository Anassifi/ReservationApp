package com.anassifi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LIMIT")
public class limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_limit;

    private long id_reservation;
    private int numbermax;
    private Date datelimit;

    public limit() {
    }

    public long getId_limit() {
        return id_limit;
    }

    public void setId_limit(long id_limit) {
        this.id_limit = id_limit;
    }

    public long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(long id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getNumbermax() {
        return numbermax;
    }

    public void setNumbermax(int numbermax) {
        this.numbermax = numbermax;
    }

    public Date getDatelimit() {
        return datelimit;
    }

    public void setDatelimit(Date datelimit) {
        this.datelimit = datelimit;
    }
}
