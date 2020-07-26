package 数组.双指针;

public class 盛最多水的容器 {
    //短指针已经限制了高度，如果移动高指针不可能增加整体的高度，而底在不断减少，所以移动短指针来尝试增加最大高度
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int ll = height[l];
            int rr = height[r];
            int area = (ll > rr ? rr : ll) * (r - l);
            maxArea = maxArea > area ? maxArea : area;
            if (ll < rr) l++;
            else r--;
        }
        return maxArea;
    }
}
