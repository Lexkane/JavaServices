package com.flower_shop.factory.builder.director;

import com.flower_shop.factory.product.FlowerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FlowerDirectorTest {

    private static FlowerDirector flowerDirector;

    @BeforeAll
    static void init() {
        flowerDirector = new FlowerDirector();
    }

    @Test
    void createRose() {
        FlowerImpl rose = (FlowerImpl) flowerDirector.createRose();
        assertNotNull(rose);
        assertThat(rose.getName().toLowerCase(), containsString("rose"));
        assertThat(rose.getPrice(), anyOf(equalTo(20d), greaterThan(0d)));
    }

    @Test
    void createChamomile() {
        FlowerImpl chamomile = (FlowerImpl) flowerDirector.createChamomile();
        assertNotNull(chamomile);
        assertThat(chamomile.getName().toLowerCase(), containsString("chamomile"));
        assertThat(chamomile.getPrice(), anyOf(equalTo(17d), greaterThan(0d)));
    }

    @Test
    void createTulip() {
        FlowerImpl tulip = (FlowerImpl) flowerDirector.createTulip();
        assertNotNull(tulip);
        assertThat(tulip.getName().toLowerCase(), containsString("tulip"));
        assertThat(tulip.getPrice(), anyOf(equalTo(18d), greaterThan(0d)));
    }
}