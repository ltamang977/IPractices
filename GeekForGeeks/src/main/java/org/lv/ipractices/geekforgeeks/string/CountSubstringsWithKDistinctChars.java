package org.lv.ipractices.geekforgeeks.string;

public class CountSubstringsWithKDistinctChars {

    /**
     * incomplete solution
     * @param str
     * @param k
     * @return
     */
    static int countkDist(String str, int k)	{

        int substringWithKDistinctChars=0;
        int distinct = 0;
        int[] countArr = new int[256];

        for(int i=0; i<str.length()-k+1; i++) {
            distinct=0;

            for (int j = i; j < str.length(); j++) {

                countArr[str.charAt(j)]++;
                if (countArr[str.charAt(i)] == 1) {
                    distinct++;
                }

                if (distinct == k) {
                    substringWithKDistinctChars++;
                }
            }
        }

        return substringWithKDistinctChars;
    }

    public static void main (String[] args) {
        //code

        //String ch = "abcbaa";
        String ch = "abc";
        int k = 2;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + countkDist(ch, k));
    }
}
