package com.javaunit3.springmvc;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class VoteEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
