package Lecture_2;

import java.util.ArrayList;
import java.util.List;

/*
Сад-огород
*/

public class Solution_4 {


    public static void main(String[] args) {

    }

    public static class Garden extends Thread {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit) {
            fruits.add(index, fruit);
        }

        public synchronized void removeFruit(int index) {
            fruits.remove(index);
        }

        public synchronized void addVegetable(int index, String fruit) {
            vegetables.add(index, fruit);
        }

        public synchronized void removeVegetable(int index) {
            vegetables.remove(index);
        }
    }
}