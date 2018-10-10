/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Mirror {

    public void Mirror(TreeNode root) {
        if(root == null || root.left!=null || root.right!=null){
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
