package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaPhylumDao implements ArchaeaPhylumDao {

    private final Sql2o sql2o;

    public Sql2oArchaeaPhylumDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(ArchaeaPhylum archaeaPhylum) {
        String sql = "INSERT INTO archaeaPhylum (phylumName) VALUES (:phylumName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaPhylum)
                    .executeUpdate()
                    .getKey();
            archaeaPhylum.setPhylumId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaPhylum> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaPhylum")
                    .executeAndFetch(ArchaeaPhylum.class);
        }
    }


    @Override
    public ArchaeaPhylum findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaPhyla WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaPhylum.class);
        }
    }
}
