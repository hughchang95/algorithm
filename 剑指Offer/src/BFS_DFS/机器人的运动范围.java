package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m+1][n+1];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1],vs=x==100?1:x/10+x%10,vy=y==100?1:y/10+y%10;
                if (!visited[x][y] && x > 0 && x < m - 1 && y > 0 && y < n - 1 && vs + vy <= k) {
                    visited[x][y]=true;
                    count++;
                }else
                    continue;
                queue.add(new int[]{x+1,y});
                queue.add(new int[]{x,y+1});
            }
        }
        return count;
    }
}
