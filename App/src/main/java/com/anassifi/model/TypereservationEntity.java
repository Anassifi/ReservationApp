package com.anassifi.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "typereservation", schema = "public", catalog = "reservationYoucode")
public class TypereservationEntity {
    private Long idLimit;
    private Long numbermax;
    private String dateoflimit;
    private String typereservation;
    private Collection<ReservationEntity> reservationsByIdLimit;

    @Id
    @GeneratedValue
    @Column(name = "id_limit", nullable = false)
    public Long getIdLimit() {
        return idLimit;
    }

    public void setIdLimit(Long idLimit) {
        this.idLimit = idLimit;
    }

    @Basic
    @Column(name = "numbermax", nullable = true)
    public Long getNumbermax() {
        return numbermax;
    }

    public void setNumbermax(Long numbermax) {
        this.numbermax = numbermax;
    }

    @Basic
    @Column(name = "dateoflimit", nullable = true, length = 254)
    public String getDateoflimit() {
        return dateoflimit;
    }

    public void setDateoflimit(String dateoflimit) {
        this.dateoflimit = dateoflimit;
    }

    @Basic
    @Column(name = "typereservation", nullable = true, length = 254)
    public String getTypereservation() {
        return typereservation;
    }

    public void setTypereservation(String typereservation) {
        this.typereservation = typereservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypereservationEntity that = (TypereservationEntity) o;

        if (!Objects.equals(idLimit, that.idLimit)) return false;
        if (!Objects.equals(numbermax, that.numbermax)) return false;
        if (!Objects.equals(dateoflimit, that.dateoflimit)) return false;
        if (!Objects.equals(typereservation, that.typereservation))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLimit != null ? idLimit.hashCode() : 0;
        result = 31 * result + (numbermax != null ? numbermax.hashCode() : 0);
        result = 31 * result + (dateoflimit != null ? dateoflimit.hashCode() : 0);
        result = 31 * result + (typereservation != null ? typereservation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typereservationByTyperes")
    public Collection<ReservationEntity> getReservationsByIdLimit() {
        return reservationsByIdLimit;
    }

    public void setReservationsByIdLimit(Collection<ReservationEntity> reservationsByIdLimit) {
        this.reservationsByIdLimit = reservationsByIdLimit;
    }
}
