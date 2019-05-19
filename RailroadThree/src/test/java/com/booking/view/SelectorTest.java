//package com.booking.view;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ViewSelectorTest {
//
//    static Selector selector;
//
//    @BeforeAll
//    static void init() {
//        selector = new Selector();
//    }
//
//    @Test
//    void findRouts() {
//        Date date = new Date();
//        String from = "Station 1";
//        String to = "Station 2";
//        assertDoesNotThrow(() -> selector.findRouts(from, to, date));
//
//        assertNotEquals(selector.findRouts(from, to, date), null);
//        assertEquals(0, selector.findRouts(from, to, date).size(), "0=0");
//        assertNotEquals(0, selector.findRouts("Lviv", "Kyiv", new Date(119, 1,1)).size(), "0=0");
//
//
//    }
//}