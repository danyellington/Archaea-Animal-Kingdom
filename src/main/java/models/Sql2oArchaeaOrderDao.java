package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaOrderDao implements ArchaeaOrderDao{

    private final Sql2o sql2o;

    public Sql2oArchaeaOrderDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(ArchaeaOrder archaeaOrder) {
        String sql = "INSERT INTO ArchaeaOrder (orderName) VALUES (:orderName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaOrder)
                    .executeUpdate()
                    .getKey();
            archaeaOrder.setOrderId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaOrder> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaOrder")
                    .executeAndFetch(ArchaeaOrder.class);
        }
    }


    @Override
    public ArchaeaOrder findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaOrders WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaOrder.class);
        }
    }
}
