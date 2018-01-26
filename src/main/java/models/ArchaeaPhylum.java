package models;


import models.*;

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
}
