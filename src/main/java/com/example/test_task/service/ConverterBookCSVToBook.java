package com.example.test_task.service;

import com.example.test_task.model.Book;
import com.example.test_task.model.BookCSV;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class ConverterBookCSVToBook {
    public static Book toBook(BookCSV bookCSV){
        Book book = new Book();
        book.setIsbn(bookCSV.getIsbn());
        book.setTitle(bookCSV.getTitle());
        book.setSeriesTitle(bookCSV.getSeriesTitle());
        try {
            book.setSeriesReleaseNumber(Integer.parseInt(bookCSV.getSeriesReleaseNumber()));
        }
        catch (NumberFormatException e){
            book.setSeriesReleaseNumber(0);
        }
        book.setAuthors(bookCSV.getAuthors());
        book.setLanguage(bookCSV.getLanguage());
        book.setDescription(bookCSV.getDescription());
        book.setNumPages(bookCSV.getNumPages());
        book.setFormat(bookCSV.getFormat());
        book.setGenres(bookCSV.getGenres());

        SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        try {
            Date docDate= format.parse(bookCSV.getPublicationDate());
            book.setPublicationDate(docDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        book.setRatingScore(bookCSV.getRatingScore());
        book.setNumRatings(bookCSV.getNumRatings());
        book.setCurrentReaders(bookCSV.getCurrentReaders());
        book.setWantToRead(bookCSV.getWantToRead());
        book.setPrice(bookCSV.getPrice());
        book.setUrl(bookCSV.getUrl());
        return book;
    }
}
