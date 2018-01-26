package models;


public class ArchaeaFamily extends ArchaeaOrder{
    public String familyName;
    public int familyId;


    public ArchaeaFamily(String domainName, String phylumName, String className, String orderName, String familyName ) {
        super(domainName, phylumName, className, orderName);
        this.familyName = familyName;
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
}
