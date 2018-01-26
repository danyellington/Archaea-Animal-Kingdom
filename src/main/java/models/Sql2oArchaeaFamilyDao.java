package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaFamilyDao implements ArchaeaFamilyDao{

    private final Sql2o sql2o;

    public Sql2oArchaeaFamilyDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(ArchaeaFamily archaeaFamily) {
        String sql = "INSERT INTO ArchaeaFamilies (familyName) VALUES (:familyName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaFamily)
                    .executeUpdate()
                    .getKey();
            archaeaFamily.setFamilyId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaFamily> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaFamily")
                    .executeAndFetch(ArchaeaFamily.class);
        }
    }


    @Override
    public ArchaeaFamily findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaFamilies WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaFamily.class);
        }
    }
}
