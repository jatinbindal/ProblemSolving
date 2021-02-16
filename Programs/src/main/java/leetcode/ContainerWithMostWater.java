package leetcode;

public class ContainerWithMostWater {

    //https://leetcode.com/problems/container-with-most-water/
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int area = 0, a = 0;
        while (left < right) {
            // start with max width, and optimize height by changing the shorter line
            int min = height[left] > height[right] ? right : left;
            if (area < (a = height[min] * (right - left)))
                area = a;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
