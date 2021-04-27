package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DataUtilsTest {

    @Test
    public void shouldReturnTrueWhenFutureDate() {
        LocalDate date = LocalDate.of(2030, 1, 1);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnFalseWhenPastDate() {
        LocalDate date = LocalDate.of(2010, 1, 1);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnDateWhenCurrentDate() {
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }
}
