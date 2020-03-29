package leetcode;

import java.util.*;

class Solution38 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates,int len, int left
            , int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (left == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;//结束这一条path
        }
        for (int i = begin; i < len; i++) {
            // 在数组有序的前提下，剪枝
            if (left - candidates[i] < 0) {
                break;//当前层全部放弃结束循环,因为剩余元素都比left大
            }
            path.addLast(candidates[i]);
            //往下一层,参数中只变动了left和path
            dfs(candidates, len, left - candidates[i], i, path, res);
            path.removeLast();//回退一层,继续横向遍历
        }
    }
}