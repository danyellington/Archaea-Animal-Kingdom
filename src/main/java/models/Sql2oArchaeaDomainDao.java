package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaDomainDao implements ArchaeaDomainDao {

    private final Sql2o sql2o;

    public Sql2oArchaeaDomainDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(ArchaeaDomain archaeaDomain) {
        String sql = "INSERT INTO ArchaeaDomains (domainName) VALUES (:domainName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaDomain)
                    .executeUpdate()
                    .getKey();
            archaeaDomain.setDomainId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaDomain> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaDomains")
                    .executeAndFetch(ArchaeaDomain.class);
        }
    }


    @Override
    public ArchaeaDomain findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaDomains WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaDomain.class);
        }
    }
}
