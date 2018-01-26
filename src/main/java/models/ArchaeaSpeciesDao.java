package models;


import java.util.List;

public interface ArchaeaSpeciesDao {

    void add(ArchaeaSpecies archaeaSpecies);

    List<ArchaeaSpecies> getAll();

    ArchaeaSpecies findById(int id);
}
