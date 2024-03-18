package com.example.test_task.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long isbn;

    private String title;

    @Column(name = "series_title")
    private String seriesTitle;

    @Column(name = "series_release_number")
    private Integer seriesReleaseNumber;

    private String authors;

    private String publisher;

    private String language;

    @Column(length = 5000)
    private String description;

    @Column(name = "num_pages")
    private Integer numPages;

    private String format;

    private String genres;


    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "rating_score")
    private Double ratingScore;

    @Column(name = "num_ratings")
    private Double numRatings;

    @Column(name = "num_reviews")
    private Double numReviews;

    @Column(name = "current_readers")
    private Double currentReaders;

    @Column(name = "want_to_read")
    private Double wantToRead;

    private Double price;

    private String url;
}
