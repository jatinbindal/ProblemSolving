import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;


//https://www.educative.io/page/11000001/70001
public class TheSkylineProblem {
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {

            List<List<Integer>> res = new ArrayList<>();
            BuildingPoint[] points = new BuildingPoint[buildings.length * 2];
            int i = 0;
            for (int[] b : buildings) {
                BuildingPoint s = new BuildingPoint(true, b[0], b[2]);
                BuildingPoint e = new BuildingPoint(false, b[1], b[2]);
                points[i++] = s;
                points[i++] = e;
            }

            Arrays.sort(points);

            TreeMap<Integer, Integer> q = new TreeMap<>();

            q.put(0, 1);
            int prevMax = 0;
            for (BuildingPoint p : points) {
                if (p.isStart) {
                    q.put(p.h, q.getOrDefault(p.h, 0) + 1);
                } else {
                    int c = q.get(p.h) - 1;
                    if (c == 0)
                        q.remove(p.h);
                    else
                        q.put(p.h, c);
                }

                int currMax = q.lastKey();
                if (currMax != prevMax) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(p.x);
                    ans.add(currMax);
                    prevMax = currMax;
                    res.add(ans);
                }
            }
            return res;
        }
    }

    class BuildingPoint implements Comparable<BuildingPoint> {
        boolean isStart;
        int x, h;

        BuildingPoint(boolean b, int x, int y) {
            isStart = b;
            this.x = x;
            this.h = y;
        }

        public int compareTo(BuildingPoint p) {
            if (this.x != p.x)
                return this.x - p.x;
            return (this.isStart ? -this.h : this.h) - (p.isStart ? -p.h : p.h);
        }
    }
}