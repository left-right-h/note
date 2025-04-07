/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huozhibin on 2025/4/7.
 */
public class ThreeSumTarget15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        int target = 15;
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumTarget15 solution = new ThreeSumTarget15();
        int[] nums = {1, 0, 7, 2, 4, 5, 3, 15, 6, 9, 11, 12, 13, 14};
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
