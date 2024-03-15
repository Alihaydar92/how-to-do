package com.alinem.howtodo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean status;

    @Column(columnDefinition = "TEXT")
    private  String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private Topic topic;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Audio> audio=new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Video> video=new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Photo> photo=new HashSet<>();

}
