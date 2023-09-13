package com.smk.cashier.service;

import com.smk.cashier.model.Barang;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BarangServiceTest {

    @org.junit.jupiter.api.Test
    @Order(2)
    void addBarang() {
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop");
        laptop.setHargaBarang(5000000);
        BarangService.getInstance()
                .addBarang(laptop);
        List<Barang> barangList
                = BarangService
                .getInstance()
                .getBarangList();
        assertEquals(barangList.size(),1);
    }
    @org.junit.jupiter.api.Test
    @Order(100)
    void getBarangList() {
        List<Barang> barangList
            = BarangService
                .getInstance()
                .getBarangList();
        assertEquals(barangList.size()
        ,2);
    }


}