package com.example;

import com.example.parameterized.LionParameterized;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionClassTest {

    Lion lion;

    @Mock
    Feline feline;

    @BeforeEach
    public void createObjectLion() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @ParameterizedTest
    @ArgumentsSource(LionParameterized.class)
    public void doesHaveManeAssert(String gender, boolean expected) throws Exception {
        Lion lion = new Lion(gender, feline);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void getKittensCalls() throws Exception {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodCalls() throws Exception {
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void haveManeException() throws Exception {
        Executable executable = () -> new Lion("Что-то", feline);
        assertThrows(Exception.class, executable);
    }

}


