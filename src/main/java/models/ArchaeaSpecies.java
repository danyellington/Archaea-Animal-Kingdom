package models;


public class ArchaeaSpecies extends ArchaeaGenus{
    public String speciesName;
    public int speciesId;


    public ArchaeaSpecies(String domainName, String phylumName, String className, String orderName, String familyName, String genusName, String speciesName) {
        super(domainName, phylumName, className, orderName, familyName, genusName);
        this.speciesName = speciesName;
        this.speciesId = speciesId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }
}
