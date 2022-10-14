package Lecture_2;

import java.util.ArrayList;
import java.util.List;

/*
Заметки
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        NoteThread nS1 = new NoteThread();
        nS1.setName("Pot 1");
        NoteThread nS2 =  new NoteThread();
        nS2.setName("Pot 2");
        NoteThread nS3 =  new NoteThread();
        nS3.setName("Pot 3");
        nS1.start();
        nS1.join();
        nS3.start();
        nS3.join();
        nS2.start();

    }

    public static  class Note extends Thread {

        public volatile List<String> notes = new ArrayList<>();

        public void addNote(String note) {
            notes.add(0, note);
        }

        public void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Note {

        @Override
        public void run() {
            boo();
        }

        public void boo () {
            for (int i = 0; i < 100; i++) {
                try {
                    notes.add(currentThread().getName() + "-Note" + i);
                    Thread.sleep(10);
                    removeNote(getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
