package com.epam.eventrecorder.user.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.epam.eventrecorder.experiment.domain.Experiment;
import com.epam.eventrecorder.keyset.domain.Keyset;

@Entity
public class User implements java.io.Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String name;
    @OneToMany
    private List<Keyset> keysets;
    @OneToMany
    private List<Experiment> experiments;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

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

    public List<Keyset> getKeysets() {
        return keysets;
    }

    public void setKeysets(List<Keyset> keysets) {
        this.keysets = keysets;
    }

    public List<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(List<Experiment> experiments) {
        this.experiments = experiments;
    }

    // public List<Keyset> getKeysetList() {
    // if (getKeysets() == null) {
    // return null;
    // }
    // List<Keyset> keysetList = new ArrayList(getKeysets());
    // Collections.sort(keysetList, new Comparator<Keyset>() {
    // @Override
    // public int compare(Keyset ks1, Keyset ks2) {
    // return ks1.getName().compareToIgnoreCase(ks2.getName());
    // }
    // });
    // return keysetList;
    // }
    //
    // public List<Experiment> getExpList() {
    // if (getExperiments() == null) {
    // return null;
    // }
    // List<Experiment> expList = new ArrayList(getExperiments());
    // Collections.sort(expList, new Comparator<Experiment>() {
    // @Override
    // public int compare(Experiment e1, Experiment e2) {
    // return e1.getName().compareToIgnoreCase(e2.getName());
    // }
    // });
    // return expList;
    // }

    @Override
    public String toString() {
        return name;
    }

}
