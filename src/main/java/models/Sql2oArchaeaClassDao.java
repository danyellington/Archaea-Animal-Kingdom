package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaClassDao implements ArchaeaClassDao {

    private final Sql2o sql2o;

    public Sql2oArchaeaClassDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(ArchaeaClass archaeaClass) {
        String sql = "INSERT INTO ArchaeaClasses (className) VALUES (:className)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaClass)
                    .executeUpdate()
                    .getKey();
            archaeaClass.setClassId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaClass> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaClass")
                    .executeAndFetch(ArchaeaClass.class);
        }
    }


    @Override
    public ArchaeaClass findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaClasses WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaClass.class);
        }
    }
}


