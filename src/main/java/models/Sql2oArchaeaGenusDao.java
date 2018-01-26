package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaGenusDao implements ArchaeaGenusDao{

    private final Sql2o sql2o;

    public Sql2oArchaeaGenusDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(ArchaeaGenus archaeaGenus) {
        String sql = "INSERT INTO ArchaeaGenera (genusName) VALUES (:genusName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaGenus)
                    .executeUpdate()
                    .getKey();
            archaeaGenus.setGenusId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaGenus> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaGenus")
                    .executeAndFetch(ArchaeaGenus.class);
        }
    }


    @Override
    public ArchaeaGenus findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaGenera WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaGenus.class);
        }
    }
}
