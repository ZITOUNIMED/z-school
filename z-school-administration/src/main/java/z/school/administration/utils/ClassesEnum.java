package z.school.administration.utils;

public enum ClassesEnum {
    S01A("SEPTIEME_SECONDAIRE", 20),
    S01B("SEPTIEME_SECONDAIRE", 21),

    S02A("HUITIEME_SECONDAIRE", 19),
    S02B("HUITIEME_SECONDAIRE", 18),

    S03A("NEUVIEME_SECONDAIRE", 17),
    S03B("NEUVIEME_SECONDAIRE", 17);

    private String sectionKey;
    private int capacity;

    ClassesEnum(String sectionKey, int capacity){
        this.sectionKey = sectionKey;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSectionKey() {
        return sectionKey;
    }
}
