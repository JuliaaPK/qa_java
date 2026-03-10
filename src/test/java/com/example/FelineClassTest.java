package com.example;

import com.example.parameterized.FelineParameterized;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FelineClassTest {
    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnString() {
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

   @Test
    public void getKittensCountOne() {
        int actual = feline.getKittens(1);
        assertEquals(1, actual);
   }

   @Test
    public void getKittensWithoutParams() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
   }

    @ParameterizedTest
    @ArgumentsSource(FelineParameterized.class)
    public void getFoodAssert(String animalType, List<String> expected) throws Exception {
        List<String> animalFood = feline.getFood(animalType);
        assertEquals(expected, animalFood);
   }

   @Test
    public void getFoodException() {
       Executable executable = () -> feline.getFood("Что-то");
       assertThrows(Exception.class, executable);
   }

}
