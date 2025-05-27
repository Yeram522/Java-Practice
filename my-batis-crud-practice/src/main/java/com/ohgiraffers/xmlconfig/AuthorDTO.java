package com.ohgiraffers.xmlconfig;

public class AuthorDTO {
    private int id;
    private String name;
    private String awarded;

    public AuthorDTO(){}

    public AuthorDTO(int id, String name, String awarded) {
        this.id = id;
        this.name = name;
        this.awarded = awarded;
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

    public String getAwarded() {
        return awarded;
    }

    public void setAwarded(String awarded) {
        this.awarded = awarded;
    }


    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", awarded='" + awarded + '\'' +
                '}';
    }
}
