package models;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oArchaeaSpeciesDao implements ArchaeaSpeciesDao{

    private final Sql2o sql2o;

    public Sql2oArchaeaSpeciesDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(ArchaeaSpecies archaeaSpecies) {
        String sql = "INSERT INTO ArchaeaSpecies (speciesName) VALUES (:speciesName)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(archaeaSpecies)
                    .executeUpdate()
                    .getKey();
            archaeaSpecies.setSpeciesId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<ArchaeaSpecies> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaSpecies")
                    .executeAndFetch(ArchaeaSpecies.class);
        }
    }


    @Override
    public ArchaeaSpecies findById(int id){
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM archaeaSpecies WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ArchaeaSpecies.class);
        }
    }
}
