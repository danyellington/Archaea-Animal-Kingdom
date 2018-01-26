package models;


import java.util.List;

public interface ArchaeaPhylumDao {

    void add(ArchaeaPhylum archaeaPhylum);

    List<ArchaeaPhylum> getAll();

   ArchaeaPhylum findById(int id);
}
