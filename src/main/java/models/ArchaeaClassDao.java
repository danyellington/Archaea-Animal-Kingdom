package models;

import java.util.List;

public interface ArchaeaClassDao {

    void add(ArchaeaClass archaeaClass);

    List<ArchaeaClass> getAll();

    ArchaeaClass findById(int id);


}