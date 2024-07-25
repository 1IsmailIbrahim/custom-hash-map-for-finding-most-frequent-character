package Q1;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        System.out.println("Enter the string");
        System.out.println("__________________");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char ch = 0;
        int count = -1;

        myHashMap<Character, Integer> hm = new myHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
            } else {
                hm.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (hm.get(str.charAt(i)) > count) {
                count = hm.get(str.charAt(i));
                ch = str.charAt(i);
            } else if (hm.get(str.charAt(i)) == count && (int) str.charAt(i) < (int) ch) {
                ch = str.charAt(i);
            }
        }
        System.out.println();
        System.out.println(ch + "   " + count);
    }

}
