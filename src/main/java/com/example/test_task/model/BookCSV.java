package com.example.test_task.model;



import com.opencsv.bean.CsvBindByName;

import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookCSV {


    @CsvBindByName
    private Long isbn;

    @CsvBindByName
    private String title;

    @CsvBindByName(column = "series_title")
    private String seriesTitle;

    @CsvBindByName(column = "series_release_number")
    private String seriesReleaseNumber;

    @CsvBindByName
    private String authors;

    @CsvBindByName
    private String publisher;

    @CsvBindByName
    private String language;

    @CsvBindByName
    private String description;

    @CsvBindByName(column = "num_pages")
    private Integer numPages;

    @CsvBindByName
    private String format;

//    @CsvBindAndSplitByName(elementType = String.class, collectionType = Set.class, splitOn = ",")
    @CsvBindByName
    private String genres;

    //    "MMMM dd, yyyy"
    @CsvBindByName(column = "publication_date")
//    @CsvDate
    private String publicationDate;


    @CsvBindByName(column = "rating_score")
    private Double ratingScore;


    @CsvBindByName(column = "num_ratings")
    private Double numRatings;


    @CsvBindByName(column = "num_reviews")
    private Double numReviews;


    @CsvBindByName(column = "current_readers")
    private Double currentReaders;


    @CsvBindByName(column = "want_to_read")
    private Double wantToRead;

    @CsvBindByName
    private Double price;

    @CsvBindByName
    private String url;
}
