import java.util.*;

/**
 * Dijkstra's
 */
class Solution499 {
    class Square implements Comparable<Square> {
        int row;
        int col;
        int dist;
        String path;

        public Square(int row, int col, int dist, String path) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.path = path;
        }

        @Override
        public int compareTo(Square other) {
            if (this.dist != other.dist) {
                return Integer.compare(this.dist, other.dist);
            }
            return this.path.compareTo(other.path);
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ") - Dist: " + dist + " Path: " + path;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        String[] pathList = new String[] {"u", "r", "d", "l"};
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Square[][] sq = new Square[m][n];
        sq[ball[0]][ball[1]] = new Square(ball[0], ball[1], 0, "");

        PriorityQueue<Square> pq = new PriorityQueue<>(); 
        pq.offer(new Square(ball[0], ball[1], 0, ""));

        while (!pq.isEmpty()) {
            Square curr = pq.poll();
            String path = curr.path;

            if (curr.row == hole[0] && curr.col == hole[1]) {
                return curr.path;
            }

            for (int i = 0; i < directions.length; i++) {
                int count = 0;
                int currX = curr.row, currY = curr.col;
                int deltaX = directions[i][0], deltaY = directions[i][1];
                while (currX + deltaX >= 0 && currX + deltaX < m && currY + deltaY >= 0 && currY + deltaY < n && maze[currX+deltaX][currY+deltaY] == 0) {
                    currX += deltaX;
                    currY += deltaY;
                    count++;

                    if (currX == hole[0] && currY == hole[1]) {
                        break;
                    }
                }

                if (count == 0) {
                    continue;
                }

                Square next = new Square(currX, currY, count + curr.dist, path + pathList[i]);
                if (sq[currX][currY] == null || sq[currX][currY].compareTo(next) > 0) {
                    sq[currX][currY] = next;
                    pq.add(next);
                }
            }
        }

        return "impossible";
    }
}
class test {
    public static void main(String[] args) {
        Solution499 s = new Solution499();
        int[][] maze = new int[][] { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
        int[] ball = new int[] { 4, 3 };
        int[] hole = new int[] { 0, 1 };
        System.out.println(s.findShortestWay(maze, ball, hole));


        int[][] maze2 = new int[][] { {0,0,0,0,0,0,0}, {0,0,1,0,0,1,0}, {0,0,0,0,1,0,0}, {0,0,0,0,0,0,1}};
        int[] ball2 = new int[] { 0, 4 };
        int[] hole2 = new int[] { 3, 5 };
        System.out.println(s.findShortestWay(maze2, ball2, hole2));
    }
}