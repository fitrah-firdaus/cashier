package com.smk.cashier.service;

import com.smk.cashier.dao.BarangDao;
import com.smk.cashier.model.Barang;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BarangServiceTest {

    @org.junit.jupiter.api.Test
    @Order(1)
    void addBarang() {
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop");
        laptop.setHargaBarang(5000000);
        BarangService.getInstance()
                .addBarang(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("MO001");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(100000);
        BarangService.getInstance()
                .addBarang(mouse);

        Barang laptopGaming = new Barang();
        laptopGaming
                .setKodeBarang("LP002");
        laptopGaming
                .setNamaBarang("Laptop " +
                        "Gaming");
        laptopGaming
                .setHargaBarang(20000000);
        BarangService.getInstance()
                .addBarang(laptopGaming);
    }
    @Test
    @Order(2)
    void getBarangList() {
        List<Barang> barangList
            = BarangService
                .getInstance()
                .getBarangList();
        assertEquals(barangList.size()
        ,3);
    }

    @Test
    @Order(3)
    void findByName() {
        List<Barang> resultList =
                BarangService
                        .getInstance()
                        .findByName("Laptop");
        assertEquals(resultList.size()
        ,2);
    }

    @Test
    @Order(4)
    void saveBarangToDatabase() {
        BarangDao barangDao = new BarangDao();
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop");
        laptop.setHargaBarang(5000000);
        laptop.setDateCreated(new Date());
        laptop.setLastModified(new Date());
        barangDao.save(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("MO001");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(100000);
        mouse.setDateCreated(new Date());
        mouse.setLastModified(new Date());
        barangDao.save(mouse);

        Barang laptopGaming = new Barang();
        laptopGaming
                .setKodeBarang("LP002");
        laptopGaming
                .setNamaBarang("Laptop " +
                        "Gaming");
        laptopGaming
                .setHargaBarang(20000000);
        laptopGaming.setDateCreated(new Date());
        laptopGaming.setLastModified(new Date());
        barangDao.save(laptopGaming);
    }

    @Test
    @Order(5)
    void getDataById() {
        BarangDao barangDao = new BarangDao();
        Optional<Barang> barang1 = barangDao.get(1);
        barang1.ifPresent(new Consumer<Barang>() {
            @Override
            public void accept(Barang barang) {
                assertEquals("Laptop", barang.getNamaBarang());
                assertEquals("LP001", barang.getKodeBarang());
            }
        });

        Optional<Barang> barang2 = barangDao.get(2);
        barang2.ifPresent(new Consumer<Barang>() {
            @Override
            public void accept(Barang barang) {
                assertEquals("Mouse", barang.getNamaBarang());
                assertEquals("MO001", barang.getKodeBarang());
            }
        });
    }

    @Test
    @Order(6)
    void updateBarangByKodeBarang() {
        BarangDao barangDao = new
                BarangDao();
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop Updated");
        laptop.setHargaBarang(6000000);
        barangDao.update(laptop);

        Optional<Barang> barang1 = barangDao.get(1);
        barang1.ifPresent(new Consumer<Barang>() {
            @Override
            public void accept(Barang barang) {
                assertEquals("Laptop Updated", barang.getNamaBarang());
                assertEquals("LP001", barang.getKodeBarang());
                assertEquals(6000000,
                        barang.getHargaBarang());
            }
        });
    }





}