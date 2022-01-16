package com.acm.backend.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "acm_user")
public class User  extends Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double score;

    @OneToOne(cascade=CascadeType.REMOVE)
    @JsonIgnore
    private SerialNumber serialNumber;

    @JsonIgnore
    @OneToMany
    private List<User> followers;
    @JsonIgnore
    @OneToMany
    private  List<User> following;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Reaction> reactions;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany
    private List<Event> event;
}
