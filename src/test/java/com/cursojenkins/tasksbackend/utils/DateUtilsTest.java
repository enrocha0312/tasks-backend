package com.cursojenkins.tasksbackend.utils;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateUtilsTest {
    @Test
    public void deveRetornarTrueParaDatasFuturas(){
        LocalDate date = LocalDate.of(2030,01,01);
        assertTrue(DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void deveRetornarTrueParaDatasPassadas(){
        LocalDate date = LocalDate.of(2010,01,01);
        assertTrue(!DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void deveRetornarTrueParaDatasAtual(){
        LocalDate date = LocalDate.now();
        assertTrue(!DateUtils.isEqualOrFutureDate(date));
    }
}
