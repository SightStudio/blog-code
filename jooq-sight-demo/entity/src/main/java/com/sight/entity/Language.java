package com.sight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Language {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "language")
    private Set<Film> languageFilms;

    @OneToMany(mappedBy = "originalLanguage")
    private Set<Film> originalLanguageFilms;

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(final Integer languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getLanguageFilms() {
        return languageFilms;
    }

    public void setLanguageFilms(final Set<Film> languageFilms) {
        this.languageFilms = languageFilms;
    }

    public Set<Film> getOriginalLanguageFilms() {
        return originalLanguageFilms;
    }

    public void setOriginalLanguageFilms(final Set<Film> originalLanguageFilms) {
        this.originalLanguageFilms = originalLanguageFilms;
    }

}
