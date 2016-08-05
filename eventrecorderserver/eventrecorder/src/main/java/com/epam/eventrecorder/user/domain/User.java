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

/**
 *
 * @author tulogdi.aron
 */
@Entity
public class User implements java.io.Serializable {

    public static final int NAME_MAX_LENGTH = 60;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = NAME_MAX_LENGTH, name = "name")
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Keyset> keysets;
    @OneToMany
    private List<Experiment> experiments;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
