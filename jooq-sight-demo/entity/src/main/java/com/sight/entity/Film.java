package com.sight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Film {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

    @Column(nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "longtext")
    private String description;

    @Column
    private Integer releaseYear;

    @Column(nullable = false)
    private Integer rentalDuration;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal rentalRate;

    @Column
    private Integer length;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal replacementCost;

    @Column
    private String rating;

    @Column
    private String specialFeatures;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmFilmActors;

    @OneToMany(mappedBy = "film")
    private Set<FilmCategory> filmFilmCategorys;

    @OneToMany(mappedBy = "film")
    private Set<Inventory> filmInventorys;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(final Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(final Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(final BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(final Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(final BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(final String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(final Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Set<FilmActor> getFilmFilmActors() {
        return filmFilmActors;
    }

    public void setFilmFilmActors(final Set<FilmActor> filmFilmActors) {
        this.filmFilmActors = filmFilmActors;
    }

    public Set<FilmCategory> getFilmFilmCategorys() {
        return filmFilmCategorys;
    }

    public void setFilmFilmCategorys(final Set<FilmCategory> filmFilmCategorys) {
        this.filmFilmCategorys = filmFilmCategorys;
    }

    public Set<Inventory> getFilmInventorys() {
        return filmInventorys;
    }

    public void setFilmInventorys(final Set<Inventory> filmInventorys) {
        this.filmInventorys = filmInventorys;
    }

}
