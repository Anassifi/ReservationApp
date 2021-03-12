package com.anassifi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "public", catalog = "reservationYoucode")
public class UserEntity {
    private Long idUser;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private Long idRole;
    private RoleEntity roleByIdRole;
    private AdminEntity adminByIdUser;
    private StudentEntity studentByIdUser;


    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 254)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, length = 254)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 254)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 254)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 254)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "id_role", nullable = true)
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (!Objects.equals(idUser, that.idUser)) return false;
        if (!Objects.equals(firstname, that.firstname)) return false;
        if (!Objects.equals(lastname, that.lastname)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(phone, that.phone)) return false;
        if (!Objects.equals(idRole, that.idRole)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (idRole != null ? idRole.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    public RoleEntity getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(RoleEntity roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }

    @OneToOne(mappedBy = "userByIdUser")
    public AdminEntity getAdminByIdUser() {
        return adminByIdUser;
    }

    public void setAdminByIdUser(AdminEntity adminByIdUser) {
        this.adminByIdUser = adminByIdUser;
    }

    @OneToOne(mappedBy = "userByIdUser")
    public StudentEntity getStudentByIdUser() {
        return studentByIdUser;
    }

    public void setStudentByIdUser(StudentEntity studentByIdUser) {
        this.studentByIdUser = studentByIdUser;
    }
}
