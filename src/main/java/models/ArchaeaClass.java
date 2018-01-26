package models;


public class ArchaeaClass extends ArchaeaPhylum{
    public String className;
    public int classId;


    public ArchaeaClass(String domainName, String phylumName, String className) {
        super(domainName, phylumName);
        this.className = className;
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
