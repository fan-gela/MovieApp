package com.javaunit3.springmvc;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "maturity rating")
    private String maturityRating;
    
    @Column(name = "genre")
    private String genre;

    public Integer getMovieId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getMaturityRating() {
        return maturityRating;
    }
    public String getGenre() {
        return genre;
    }

    public void setMovieId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

}
