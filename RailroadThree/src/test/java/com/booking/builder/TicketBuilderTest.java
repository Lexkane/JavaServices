package com.booking.builder;

import com.booking.Application;
import com.booking.CustomStructure.BasicSchedule;
import com.booking.model.station_info.Route;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketBuilderTest {

    static TicketBuilder ticketBuilder;

    @BeforeAll
    static void init() {
        Route route = BasicSchedule.getBasicSchedule().get(0).getRoutes().get(0);
        LocalDate date = LocalDate.of(119, 1,1);
        ticketBuilder = new TicketBuilder(route, date, 1, 1);
    }

    @Test
    void getTicket() {
        assertNotEquals(ticketBuilder.getResult(), null);

        assertDoesNotThrow(ticketBuilder::getResult);
    }
}