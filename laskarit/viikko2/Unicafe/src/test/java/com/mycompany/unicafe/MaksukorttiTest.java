package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(1000, kortti.saldo());
    }    
    
    @Test
    public void lataaOikein() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0",  kortti.toString());
    }
    
    @Test
    public void saldoVahenee() {
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0",  kortti.toString());
    }
    
    @Test
    public void eiYlitaSaldoa() {
        kortti.otaRahaa(2000);
        assertEquals("saldo: 10.0",  kortti.toString());
    }
    
    @Test
    public void ostoOnnistuu() {
        assertTrue(kortti.otaRahaa(500));
    }
    
    @Test
    public void ostoEiOnnistu() {
        assertTrue(!kortti.otaRahaa(2000));
    }
    
}
