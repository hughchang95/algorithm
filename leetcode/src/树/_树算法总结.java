package 树;

import java.util.*;

/**
 * 树算法分类：
 * 一般先考虑递归，迭代会增加复杂度
 * 1.遍历输出型（迭代）
 * 2.深度型：后续遍历取得子树结果后处理
 * 3.任意长度型：回溯法过程中验证长度
 * 4.公共祖先型：先序遍历节点判断
 * 5.二叉搜索树：中序遍历体现特点
 * 6.二叉搜索树转链表（迭代）：构造临时节点结合遍历
 * 7.数组构造二叉树：通过各种遍历的特点，多设置参数来实现
 * 8.各种验证问题：一般都是先序遍历，分析复杂的判断条件
 */
public class _树算法总结 {

    /**
     * 树的遍历基础：非递归实现
     * <p>
     * 1.在需要对每层值做复杂操作时适用
     */
    //层次遍历
    public List<Integer> bfs(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //用队列保存
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //本层队列大小，分层处理时有用，要先取值
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //取出节点
                TreeNode node = queue.poll();
                //进行处理
                res.add(node.val);
                //继续遍历
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    //先序遍历：相当于深度优先遍历
    //—————————————————————————————————————————————————————————
    //N叉树的前序遍历：压栈过程变为遍历子集，遍历后注意Reverse操作
    //—————————————————————————————————————————————————————————
    //路径和问题：利用回溯法解决
    //—————————————————————————————————————————————————————————
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //用栈保存
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            //先将右节点压栈，保证弹出顺序
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    //中序遍历
    //—————————————————————————————————————————————————————————
    //二叉搜索树的判定：处理元素时保存前一节点值，再次处理时比较前一节点和本节点的值
    //—————————————————————————————————————————————————————————
    //二叉搜索树转换为双向链表：结合链表思想，构建pre节点，中序遍历处理时改变指针方向
    //—————————————————————————————————————————————————————————
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //用栈保存
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //有节点要处理，节点不一定入栈了
        while (root != null || !stack.isEmpty()) {
            //左节点全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                //弹出操作元素
                root = stack.pop();
                //进行处理
                res.add(root.val);
                //右节点根据当前处理节点递推
                root = root.right;
            }
        }
        return res;
    }

    //后序遍历
    //—————————————————————————————————————————————————————————
    //N叉树的后序遍历：压栈过程变为遍历子集
    //—————————————————————————————————————————————————————————
    public List<Integer> postorder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        //用栈保存
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //利用双向链表简洁实现，否则要多申请一个中间栈反向输出到List
            res.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

    /**
     * 树的遍历基础：递归实现
     * <p>
     * 1.递归后的结果想象成已完成的计算结果
     * 2.二叉搜索树在中序遍历的情况下才有效果
     */
    //先序遍历
    //—————————————————————————————————————————————————————————
    //二叉树展开为链表：先序遍历过程中结合链表思想，在左子树上找到最右节点，用该节点衔接右子树
    //—————————————————————————————————————————————————————————
    //二叉搜索树的最近公共祖先：先序遍历：每次判断当前节点的位置关系，再进行查找：
    //      大于两节点时递归进入左子树查找；
    //      小于两节点时递归进入右子树查找。
    //      在两节点之间（或等于其中一个节点）说明是公共祖先；
    //升级：二叉树的最近公共祖先：先序遍历，遍历到目标节点或空节点时返回，然后获取遍历结果子树：
    //      左子树为空说明目标节点在右子树；
    //      右子树为空说明目标节点在左子树；
    //      否则作为一个普通节点，一边一个，说明是公共祖先；
    //—————————————————————————————————————————————————————————
    //构造二叉树的镜像：缓存某一子树，交换子树后递归另一子树和缓存
    //—————————————————————————————————————————————————————————
    public List<Integer> _preorder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getPreOrder(root, list);
        return list;
    }

    public void getPreOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getPreOrder(root.left, list);
        getPreOrder(root.right, list);
    }

    //中序遍历
    //—————————————————————————————————————————————————————————
    //二叉搜索树的第k大节点：中序遍历，在操作过程中计数，第k大为先右后左，第k小为先左后右
    //—————————————————————————————————————————————————————————
    public List<Integer> _inorder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getInOrder(root, list);
        return list;
    }

    public void getInOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, list);
        list.add(root.val);
        getInOrder(root.right, list);
    }

    //后序遍历
    //—————————————————————————————————————————————————————————
    //二叉树展开为链表：后序遍历，先右后左，构造前节点，逆转指针
    //—————————————————————————————————————————————————————————
    //二叉树的最大深度：后序遍历，先获得左右子树的最大深度，在此基础上+1即可返回
    //升级1：二叉树的直径：后序，获取左右子树的最大深度，用全局变量记录最大深度值，每次递归中比较
    //升级2：二叉树的最大路径和：后序，本问题相当于带权值的深度，最大深度相当于每层值为1的特殊情况。获取左右子树的最大路
    //      径和，用全局变量记录最大路径和，每次递归中比较
    //升级3：打家劫舍3：后序，相当于带条件的最大路径和，注意此时左右子树都可以加入总和。分条件判断，
    //      如果需要本层值，则下层为未偷窃的值；
    //      如果需要下层值，则下层值应该是左右子树中最大取值方法的和。
    //升级4：平衡二叉树的判断：后序遍历，先获取左右子树的深度，如果深度不符合要求则不平衡
    //—————————————————————————————————————————————————————————
    public List<Integer> _postorder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getPostOrder(root, list);
        return list;
    }

    public void getPostOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        getPostOrder(root.left, list);
        getPostOrder(root.right, list);
        list.add(root.val);
    }

    /**
     * 对称、镜像，子结构问题
     * <p>
     * 树的子结构判断&树的对称判断：厘清判断条件，用子树进行递归
     */
    //树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        //两节点相同时进入子结构判断
        if (A.val == B.val) {
            //是叶节点
            if (B.left == null && B.right == null) {
                return true;
            }
            //递归判断AB的左右子树是否相同
            return isSubStructure(A.right, B.right) || isSubStructure(A.left, B.left);
        }
        //递归判断A的子树是否与B结构相同
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //镜像判断
    public boolean isSymmetric(TreeNode root) {
        //用子树去比较
        return root == null || symmetric(root.left, root.right);
    }

    boolean symmetric(TreeNode L, TreeNode R) {
        if (L == null && R == null)
            return true;
        //任意左右节点存在情况不同或左右节点值不同则不是镜像
        if (L == null || R == null || L.val != R.val)
            return false;
        //镜像判断的是左左-右右，左右-右左
        return symmetric(L.left, R.right) && symmetric(L.right, R.left);
    }


    /**
     * 任意路径和问题
     * <p>
     * 回溯法
     */
    //回溯法解决问题的一般步骤：
    //1.边界条件处理
    //2.进行本层变化，处理本层事务、判断等（一般是达到某条件后记录）
    //3.递归进入子树
    //4.处理后回溯本层变化
    //
    class 二叉树中和为某一值的路径 {

        private List<List<Integer>> result = new LinkedList<>();
        private LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            path(root, sum);
            return result;
        }

        private void path(TreeNode root, int sum) {
            //边界条件处理
            if (root == null)
                return;
            //遍历所有情况开始
            path.add(root.val);
            //检查条件
            sum -= root.val;
            if (sum == 0 && root.left == null && root.right == null) {
                //标记
                result.add(new LinkedList<>(path));//此处要新建一个复制的path
            }
            path(root.left, sum);
            path(root.right, sum);
            //向上回溯（一步）
            path.removeLast();
            //遍历所有情况结束
        }
    }

    class 路经总和 {

        //核心：如果 当前前缀和-目标=某一前缀和 ，那么存在路径
        public int pathSum(TreeNode root, int sum) {
            //用HashMap存储“当前前缀和-当前前缀和出现次数”
            HashMap<Integer, Integer> prefixMap = new HashMap<>();
            //初始前缀和为0；
            prefixMap.put(0, 1);
            return getSum(root, sum, prefixMap, 0);
        }

        //dfs搜索
        public int getSum(TreeNode root, int sum, Map<Integer, Integer> prefixMap, int curSum) {
            if (root == null) {
                return 0;
            }
            //本层的工作
            int res = 0;
            curSum += root.val;
            //判断是否存在，存在则增加已出现的次数，否则加0；
            res += prefixMap.getOrDefault(curSum - sum, 0);
            //将本层的前缀和加入
            prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

            //递归进入子树
            res += getSum(root.left, sum, prefixMap, curSum);
            res += getSum(root.right, sum, prefixMap, curSum);

            //回溯本层的改动
            prefixMap.put(curSum, prefixMap.get(curSum) - 1);

            return res;
        }
    }
}



