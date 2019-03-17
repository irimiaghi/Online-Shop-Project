package com.github.abureala.Abureala.model;


import com.github.abureala.Abureala.auth.model.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Favorite")
public class Favorite {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String Title;

    @Column
    private String Genre;

    @Column
    private String Year;

    @Column
    private int Ranking;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public Favorite setTitle(String title) {
        Title = title;
        return this;
    }

    public String getGenre() {
        return Genre;
    }

    public Favorite setGenre(String genre) {
        Genre = genre;
        return this;
    }

    public String getYear() {
        return Year;
    }

    public Favorite setYear(String year) {
        Year = year;
        return this;
    }

    public int getRanking() {
        return Ranking;
    }

    public Favorite setRanking(int ranking) {
        Ranking = ranking;
        return this;
    }

    public Favorite setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Favorite setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Favorite)) return false;
        Favorite that = (Favorite) o;
        return getRanking() == that.getRanking() &&
               getId().equals(that.getId()) &&
               getTitle().equals(that.getTitle()) &&
               Objects.equals(getGenre(), that.getGenre()) &&
               Objects.equals(getYear(), that.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getGenre(), getYear(), getRanking());
    }
}
