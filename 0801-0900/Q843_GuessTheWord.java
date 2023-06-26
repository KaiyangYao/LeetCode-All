import java.util.*;

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 * public int guess(String word) {}
 * }
 */
interface Master {
  public int guess(String word);
}

class Solution implements Master{
    public void findSecretWord(String[] words, Master master) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < 30; i++) {
            Random r = new Random();
            int idx = r.nextInt(list.size());
            String currWord = list.get(idx);
            int matchScore = master.guess(currWord);
            if (matchScore == 6) {
                return;
            }

            List<String> candidates = new ArrayList<>();
            for (String s : list) {
                if (getMatchScore(s, currWord) == matchScore) {
                    candidates.add(s);
                }
            }

            list = candidates;
        }
    }

    private int getMatchScore(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int guess(String word) {
        return 0;
    }
}