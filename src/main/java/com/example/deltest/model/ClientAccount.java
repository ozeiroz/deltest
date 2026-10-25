package com.example.deltest.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "client_account")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "gender", length = 1)
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private ClientStatus status;

    @CreationTimestamp
    @Column(name = "create_dttm", nullable = false)
    private Instant createDttm;

    @UpdateTimestamp
    @Column(name = "modify_dttm", nullable = false)
    private Instant modifyDttm;

    public ClientAccount(String fullName, String gender) {
        this.fullName = fullName;
        this.gender = gender;
        this.status = ClientStatus.ACTIVE;
    }

    protected ClientAccount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public Instant getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(Instant createDttm) {
        this.createDttm = createDttm;
    }

    public Instant getModifyDttm() {
        return modifyDttm;
    }

    public void setModifyDttm(Instant modifyDttm) {
        this.modifyDttm = modifyDttm;
    }
}
