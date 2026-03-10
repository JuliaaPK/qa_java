package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatClassTest {
    Cat cat;

    @Mock
    Feline feline;

    @BeforeEach
    public void createCatObject() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsSoundMyau() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception{
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

    }
}
