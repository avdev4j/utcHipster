package com.avdev.utchipster.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * A DTO representing a user, with his authorities.
 */
public class MyDataDTO {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyDataDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
