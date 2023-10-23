package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager manager = new Manager();

    private String movie1 = "Джентельмены";
    private String movie2 = "Бладшот";
    private String movie3 = "Вперёд";
    private String movie4 = "Отель \"Белград\"";
    private String movie5 = "Челове-Невидимка";
    private String movie6 = "Тролли. Мировой тур";
    private String movie7 = "Номер один";

    @BeforeEach
    public void setUp() {
        manager.addNewMovie(movie1);
        manager.addNewMovie(movie2);
        manager.addNewMovie(movie3);
        manager.addNewMovie(movie4);
        manager.addNewMovie(movie5);
        manager.addNewMovie(movie6);
        manager.addNewMovie(movie7);
    }

    @Test
    public void shouldFindAllMovies() {
        String[] expected = { movie1, movie2, movie3, movie4, movie5, movie6, movie7 };
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastMoviesWithDefaultLimit() {
        String[] expected = { movie7, movie6, movie5, movie4, movie3 };
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMoviesWithCustomSmallLimit() {
        Manager customManager = new Manager(3);
        customManager.addNewMovie(movie1);
        customManager.addNewMovie(movie2);
        customManager.addNewMovie(movie3);
        customManager.addNewMovie(movie4);
        customManager.addNewMovie(movie5);
        customManager.addNewMovie(movie6);
        customManager.addNewMovie(movie7);

        String[] expected = { movie7, movie6, movie5 };
        assertArrayEquals(expected, customManager.findLast());
    }

    @Test
    public void shouldFindLastMoviesWithCustomBigLimit() {
        Manager customManager = new Manager(8);
        customManager.addNewMovie(movie1);
        customManager.addNewMovie(movie2);
        customManager.addNewMovie(movie3);
        customManager.addNewMovie(movie4);
        customManager.addNewMovie(movie5);
        customManager.addNewMovie(movie6);
        customManager.addNewMovie(movie7);

        String[] expected = { movie7, movie6, movie5, movie4, movie3, movie2, movie1 };
        assertArrayEquals(expected, customManager.findLast());
    }

}