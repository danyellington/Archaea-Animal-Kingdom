package models;


public class ArchaeaGenus extends ArchaeaFamily {
    public String genusName;
    public int genusId;


    public ArchaeaGenus(String domainName, String phylumName, String className, String orderName, String familyName, String genusName){
        super(domainName, phylumName, className, orderName, familyName);
        this.genusName = genusName;
        this.genusId = genusId;
    }

    public String getGenusName() {
        return genusName;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public int getGenusId() {
        return genusId;
    }

    public void setGenusId(int genusId) {
        this.genusId = genusId;
    }
}
