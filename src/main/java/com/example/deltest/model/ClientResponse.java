package com.example.deltest.model;

import java.time.Instant;

public class ClientResponse {
    private Long id;
    private String fullName;
    private String gender;
    private ClientStatus status;
    private Instant createDttm;
    private Instant modifyDttm;

    public ClientResponse(Long id,
                          String fullName,
                          String gender,
                          ClientStatus status,
                          Instant createDttm,
                          Instant modifyDttm) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.status = status;
        this.createDttm = createDttm;
        this.modifyDttm = modifyDttm;
    }

    public static ClientResponse fromClientAccount(ClientAccount c) {
        return new ClientResponse(c.getId(),
                c.getFullName(),
                c.getGender(),
                c.getStatus(),
                c.getCreateDttm(),
                c.getModifyDttm());
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
