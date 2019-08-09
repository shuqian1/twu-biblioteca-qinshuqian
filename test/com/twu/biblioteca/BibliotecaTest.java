package com.twu.biblioteca;

import com.twu.biblioteca.service.BibliotecaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream printStream = System.out;

    @Before
    public void  setUpStream(){
        System.setOut((new PrintStream(outContent)));
    }

    @After
    public void restoreStream(){
        System.setOut(printStream);
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.printWelcomeMessage(),equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }
}
