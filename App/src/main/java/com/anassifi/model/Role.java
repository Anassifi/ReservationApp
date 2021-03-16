package com.anassifi.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "public", catalog = "reservationYoucode")
public class Role {
    private Long idRole;
    private String rolename;
    private Collection<User> usersByIdRole;

    @Id
    @GeneratedValue
    @Column(name = "id_role", nullable = false)
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "rolename", nullable = true, length = 254)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role that = (Role) o;

        if (!Objects.equals(idRole, that.idRole)) return false;
        if (!Objects.equals(rolename, that.rolename)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRole != null ? idRole.hashCode() : 0;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByIdRole")
    public Collection<User> getUsersByIdRole() {
        return usersByIdRole;
    }

    public void setUsersByIdRole(Collection<User> usersByIdRole) {
        this.usersByIdRole = usersByIdRole;
    }
}
