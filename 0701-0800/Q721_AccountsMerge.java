import java.util.*;

/**
 * Union Find
 * 
 * 2023/06/26
 */

 /**
  * O(n log(n)) time | O(n) space
  */
class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;

        for (List<String> account: accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account: accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email: emailToIndex.keySet()) {
            int currIndex = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(currIndex, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(currIndex, account);
        }

        List<List<String>> result = new ArrayList<>();
        for (int index: indexToEmails.keySet()) {
            List<String> emails = indexToEmails.get(index);
            Collections.sort(emails);
            List<String> currUser = new ArrayList<>();
            currUser.add(emailToName.get(emails.get(0)));
            currUser.addAll(emails);
            result.add(currUser);
        }

        return result;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}


/**

User  Emails
 X     A B
 X     A C
 Y     D
 Z     E

 emailToIndex
 A 0
 B 1
 C 2
 D 3
 E 4

 emailToName
 A X
 B X
 C X
 D Y
 E Z

 We try to union index of the email.

 */