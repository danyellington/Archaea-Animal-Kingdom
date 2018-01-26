package models;
import models.*;

import java.util.List;

public interface ArchaeaDomainDao {

    void add(ArchaeaDomain archaeaDomain);

    List<ArchaeaDomain> getAll();

    ArchaeaDomain findById(int id);


}
