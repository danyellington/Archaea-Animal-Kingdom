package models;

import java.util.List;

public interface ArchaeaFamilyDao {

    void add(ArchaeaFamily archaeaFamily);

    List<ArchaeaFamily> getAll();

    ArchaeaFamily findById(int id);
}
