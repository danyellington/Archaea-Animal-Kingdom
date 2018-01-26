package models;


import java.util.List;

public interface ArchaeaGenusDao {

    void add(ArchaeaGenus archaeaGenus);

    List<ArchaeaGenus> getAll();

    ArchaeaGenus findById(int id);
}
