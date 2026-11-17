package leetcode;

public class ContainerWithMostWaters {
    static void main() {
        /*
        Problem statement: Leetcode-11
        You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
        of the ith line are (i, 0) and (i, height[i]).
        Find two lines that together with the x-axis form a container, such that the container contains the most water.
        Return the maximum amount of water a container can store.
        Notice that you may not slant the container.
         */
        int[] height = {8,7,2,1}; // 7
        int[] height2 = {1,8,6,2,5,4,8,3,7}; // 49
        int[] height3 = {1,1}; // 1
        System.out.println(containerCapacityBF(height));
        System.out.println(containerCapacityBF(height2));
        System.out.println(containerCapacityBF(height3));
        System.out.println("-------------------------------");
        System.out.println(containerCapacityOptimal(height));
        System.out.println(containerCapacityOptimal(height2));
        System.out.println(containerCapacityOptimal(height3));
    }
    // Bruteforce approach
    private static int containerCapacityBF(int[] height){
        int containerCapacity = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                int cWidth = j - i;
                int cHeight = Math.min(height[i],height[j]);
                containerCapacity = Math.max(containerCapacity,cWidth * cHeight);
            }
        }
        return containerCapacity;
    }
    // Optimal approach - opposite direction two pointers
    private static int containerCapacityOptimal(int[] height){
        int left = 0;
        int right = height.length - 1;
        int containerCapacity = 0;
        while(left <= right){
            int cWidth = right - left;
            int cHeight = Math.min(height[left],height[right]);
            containerCapacity = Math.max(containerCapacity,cWidth * cHeight);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return containerCapacity;
    }
}
