package models;


import models.*;


//Euryarchaeota and Crenarchaeota.


public class ArchaeaPhylum extends ArchaeaDomain {
    public String phylumName;
    public int phylumId;


    public ArchaeaPhylum(String domainName, String phylumName){
        super(domainName);
        this.phylumName = phylumName;
        this.phylumId = phylumId;
    }

    public String getPhylumName() {
        return phylumName;
    }

    public void setPhylumName(String phylumName) {
        this.phylumName = phylumName;
    }

    public int getPhylumId() {
        return phylumId;
    }

    public void setPhylumId(int phylumId) {
        this.phylumId = phylumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ArchaeaPhylum that = (ArchaeaPhylum) o;

        if (phylumId != that.phylumId) return false;
        return phylumName.equals(that.phylumName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + phylumName.hashCode();
        result = 31 * result + phylumId;
        return result;
    }
}
