package Lecture_2;

public class OurPresident {
    private static final OurPresident president;

    static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
