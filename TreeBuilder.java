import java.util.*;

public class TreeBuilder {
	public TreeBuilder() {}
	
	public TreeNode build(String nodes) {
		Scanner sc = new Scanner(nodes);
		sc.useDelimiter(",");
		TreeNode root = null;
		if (sc.hasNextInt()) root = new TreeNode(sc.nextInt());
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (sc.hasNext() && que.size() != 0) {
			TreeNode node = que.poll();
			if (node == null) continue;
			String temp = sc.next();
			node.left = temp.equals("null") ? null : new TreeNode(Integer.valueOf(temp));
			que.offer(node.left);
			if (!sc.hasNext()) break;
			temp = sc.next();
			node.right = temp.equals("null") ? null : new TreeNode(Integer.valueOf(temp));
			que.offer(node.right);
		}
		return root;
	}
}
