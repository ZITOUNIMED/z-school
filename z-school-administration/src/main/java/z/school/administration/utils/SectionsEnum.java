package z.school.administration.utils;

public enum SectionsEnum {
    SEPTIEME_SECONDAIRE("Septième année secondaire", 1),
    HUITIEME_SECONDAIRE("Huitième année secondaire", 2),
    NEUVIEME_SECONDAIRE("Neuvième année secondaire", 3);

    private String ref;
    private int level;

    SectionsEnum(String ref, int level){
        this.ref = ref;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getRef() {
        return ref;
    }
}
