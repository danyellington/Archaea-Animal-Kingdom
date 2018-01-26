package models;


import java.util.List;

public interface ArchaeaOrderDao {

    void add(ArchaeaOrder archaeaOrder);

    List<ArchaeaOrder> getAll();

    ArchaeaOrder findById(int id);
}
