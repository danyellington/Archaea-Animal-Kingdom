package models;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


public class Sql2oArchaeaDomainDaoTest {

    private Connection conn;
    private Sql2oArchaeaDomainDao archaeaDomainDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        archaeaDomainDao = new Sql2oArchaeaDomainDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

//    @Test
//    public void addingFoodSetsId() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        int originalRestaurantId = testRestaurant.getId();
//        restaurantDao.add(testRestaurant);
//        assertNotEquals(originalRestaurantId,testRestaurant.getId());
//    }

}