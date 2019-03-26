
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
       
    Kassapaate paate;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
    }
    
    @Test
    public void uudenPaattenSaldoOikein() {
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void uudenPaatteenMyydytEdullisetOikein() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void uudenPaatteenMyydytMaukkaatOikein() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenKateismaksuLisaaSaldoa() {
        paate.syoEdullisesti(1000);
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void edullisestaOikeaVaihtoraha() {
        assertEquals(760, paate.syoEdullisesti(1000));
    }
    
    @Test
    public void edullisenKateismaksuKasvattaaMyytyja() {
        paate.syoEdullisesti(1000);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisenVajaaMaksuEiMuutaSaldoa() {
        paate.syoEdullisesti(200);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void edullisenVajaaMaksuPalauttaaRahat() {
        assertEquals(200, paate.syoEdullisesti(200));
    }
    
    @Test
    public void edullisenVajaaMaksuEiKasvataMyytyja() {
        paate.syoEdullisesti(200);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
        
    @Test
    public void maukkaanKateismaksuLisaaSaldoa() {
        paate.syoMaukkaasti(1000);
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void maukkaastaOikeaVaihtoraha() {
        assertEquals(600, paate.syoMaukkaasti(1000));
    }
    
    @Test
    public void maukkaanKateismaksuKasvattaaMyytyja() {
        paate.syoMaukkaasti(1000);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanVajaaMaksuEiMuutaSaldoa() {
        paate.syoMaukkaasti(200);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void maukkaanVajaaMaksuPalauttaaRahat() {
        assertEquals(200, paate.syoMaukkaasti(200));
    }
    
    @Test
    public void maukkaanVajaaMaksuEiKasvataMyytyja() {
        paate.syoMaukkaasti(200);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksuVelottaaEdullisetOikein() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(paate.syoEdullisesti(kortti));        
    }
    
    @Test 
    public void korttimaksuLisaaMyydynEdullisen() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisenKorttimaksuEiMuutaSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void korttimaksuVelottaaMaukkaatOikein() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(paate.syoMaukkaasti(kortti));        
    }
    
    @Test 
    public void korttimaksuLisaaMyydynMaukkaan() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanKorttimaksuEiMuutaSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void korttillaEiRahaaEdulliseen() {
        Maksukortti kortti = new Maksukortti(200);
        assertTrue(!paate.syoEdullisesti(kortti));        
    }
    
    @Test 
    public void edullisenVajaaKorttimaksuEiMuutaMyytyja() {
        Maksukortti kortti = new Maksukortti(200);
        paate.syoEdullisesti(kortti);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisenVajaaKorttimaksuEiMuutaSaldoa() {
        Maksukortti kortti = new Maksukortti(200);
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void korttillaEiRahaaMaukkaaseen() {
        Maksukortti kortti = new Maksukortti(200);
        assertTrue(!paate.syoMaukkaasti(kortti));        
    }
    
    @Test 
    public void maukkaanVajaaKorttimaksuEiMuutaMyytyja() {
        Maksukortti kortti = new Maksukortti(200);
        paate.syoMaukkaasti(kortti);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanVajaaKorttimaksuEiMuutaSaldoa() {
        Maksukortti kortti = new Maksukortti(200);
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void latausKasvattaaKassanSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, paate.kassassaRahaa());
    }
    
    @Test
    public void latausKasvattaaKortinSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }
    
    @Test
    public void laitonLatausKortilleEiMuutaKortinSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, -1000);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void laitonLatausKortilleEiMuutaKassanSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, -1000);
        assertEquals(100000, paate.kassassaRahaa());
    }

}
