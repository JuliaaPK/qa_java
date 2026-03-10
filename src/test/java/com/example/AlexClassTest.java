package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AlexClassTest {
    Alex alex;

    @Mock
    Feline feline;

    @BeforeEach
    public void createObjectAlex() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void getPlaceOfLivingIsNewYork() {
        String actual = alex.getPlaceOfLiving();
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnZero() {
        int actual = alex.getKittens();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void getFriendsReturnsListOfFriend() {
        List<String> actual = alex.getFriends();
        List<String> expected = List.of("Марти", "Глория","Мелман");
        assertEquals(expected, actual);
    }
}
