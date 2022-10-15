package Lecture_2;

public class IMF {
    private static IMF imf;

    private IMF() {
    }

    public static IMF getFund() {
        if (imf == null) {
            synchronized (IMF.class) {
                imf = new IMF();
            }
        }
        return imf;
    }
}
