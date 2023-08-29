import java.util.*;

/**
 * Top Sort
 * 
 * 2023/07/20
 */
class Solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 每个group下的项目成员
        // 1: [Item1, Item2]
        List<List<Integer>> groupItems = new ArrayList<>(); 
        List<Integer> groupIdList = new ArrayList<>(); // group id 列表
        List<List<Integer>> groupEdges = new ArrayList<>(); // group与group之间的连接边
        List<List<Integer>> itemEdges = new ArrayList<>(); // item与item之间的连接边

        for (int i = 0; i < n + m; i++){
            groupItems.add(new ArrayList<>());
            groupIdList.add(i);
            groupEdges.add(new ArrayList<>());
            if (i < n) {
                itemEdges.add(new ArrayList<>());
            }
        }

        int newGroup = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = newGroup++;
            }
            groupItems.get(group[i]).add(i);
        }

        int[] groupInDegree = new int[n+m];
        int[] itemInDegree = new int[n];

        for (int i = 0; i < beforeItems.size(); i++) {
            int currGroupID = group[i];
            int currItemID = i;
            List<Integer> beforeGroups = beforeItems.get(i);
            for (int j = 0; j < beforeGroups.size(); j++) {
                int beforeItemID = beforeGroups.get(j);
                int beforeGroupID = group[beforeItemID];

                // 如果来自相同组，则只关注item的拓扑排序
                if (currGroupID == beforeGroupID) {
                    itemInDegree[currItemID]++;
                    itemEdges.get(beforeItemID).add(currItemID);
                } else { // 反之只关注group的拓扑排序
                    groupInDegree[currGroupID]++;
                    groupEdges.get(beforeGroupID).add(currGroupID);
                }
            }
        }

        List<Integer> sortedGroup = topSort(groupInDegree, groupEdges, groupIdList);
        if (sortedGroup.size() == 0) return new int[0];

        List<Integer> result = new ArrayList<>();
        for (int g : sortedGroup) {
            if (groupItems.get(g).size() == 0) continue;
            List<Integer> sortedItem = topSort(itemInDegree, itemEdges, groupItems.get(g));
            if (sortedItem.size() == 0) return new int[0];
            result.addAll(sortedItem);
        }

        int[] arrayResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }



    public List<Integer> topSort(int[] inDegree, List<List<Integer>> edges,List<Integer> points){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer item : points) {
            if (inDegree[item] == 0) {
                queue.offer(item);
            }
        }

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            result.add(curr);
            for (Integer item : edges.get(curr)) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    queue.offer(item);
                }
            }
        }

        return result.size() == points.size() ? result : new ArrayList<>();
    }
}