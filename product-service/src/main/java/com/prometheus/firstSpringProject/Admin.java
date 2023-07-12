package com.prometheus.firstSpringProject;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name="admin", schema = "public")
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_id_sequence",
            sequenceName = "admin_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_id_sequence"
    )
    private int id;
    private String name;
    private String email;
    private int age;

    public Admin(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Admin(){

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id && age == admin.age && Objects.equals(name, admin.name) && Objects.equals(email, admin.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age);
    }
}
