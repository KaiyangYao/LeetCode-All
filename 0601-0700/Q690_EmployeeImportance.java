import java.util.*;

/**
 * Graph
 * 
 * 2023/06/17
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


/**
 * DFS
 * 
 * O(n) time | O(n) space
 */
class Solution {
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        int result = map.get(id).importance;
        for (int i: map.get(id).subordinates) {
            result += dfs(i);
        }
        return result;
    }
}