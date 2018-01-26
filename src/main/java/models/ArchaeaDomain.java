package models;


public class ArchaeaDomain {
    public String domainName;
    public int domainId;

    public ArchaeaDomain(String domainName) {

        this.domainName = domainName;
        this.domainId = domainId;
    }

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public int getDomainId() {
            return domainId;
        }

        public void setDomainId(int domainId) {
            this.domainId = domainId;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArchaeaDomain that = (ArchaeaDomain) o;

        if (domainId != that.domainId) return false;
        return domainName.equals(that.domainName);
    }

    @Override
    public int hashCode() {
        int result = domainName.hashCode();
        result = 31 * result + domainId;
        return result;
    }
}



