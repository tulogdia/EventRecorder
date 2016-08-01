package com.epam.training.eventrecorder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tulogdi.aron
 */
@Entity
@Table(name = "user", catalog = "eventrecorder")
public class User implements java.io.Serializable {

    public static final int NAME_MAX_LENGTH = 40;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = NAME_MAX_LENGTH, name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Keyset> keysets = new HashSet<>(0);
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Experiment> experiments = new HashSet<>(0);

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

    public Set<Keyset> getKeysets() {
        return keysets;
    }

    public void setKeysets(Set<Keyset> keysets) {
        this.keysets = keysets;
    }

    public Set<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }

    public List<Keyset> getKeysetList() {
        if (getKeysets() == null) {
            return null;
        }
        List<Keyset> keysetList = new ArrayList(getKeysets());
        Collections.sort(keysetList, new Comparator<Keyset>() {
            @Override
            public int compare(Keyset ks1, Keyset ks2) {
                return ks1.getName().compareToIgnoreCase(ks2.getName());
            }
        });
        return keysetList;
    }

    public List<Experiment> getExpList() {
        if (getExperiments() == null) {
            return null;
        }
        List<Experiment> expList = new ArrayList(getExperiments());
        Collections.sort(expList, new Comparator<Experiment>() {
            @Override
            public int compare(Experiment e1, Experiment e2) {
                return e1.getName().compareToIgnoreCase(e2.getName());
            }
        });
        return expList;
    }

    @Override
    public String toString() {
        return name;
    }

}
