import java.util.*;

public class Tester {
	// implement Stack DFS && Queue BFS
	public static void main(String args[]) {
		System.out.println("Please Enter comma seperated node values: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		TreeBuilder tb = new TreeBuilder();
		TreeNode root = tb.build(input);
		
		printDFS(root);
		inorderPrintDFS(root);
		printBFS(root);
		
		sc.close();
	}
				
	private static void printDFS(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
		}
		System.out.println();
	}
	
	private static void inorderPrintDFS(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		HashSet<TreeNode> dealt = new HashSet<>();
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.left == null && node.right == null) {
				System.out.print(node.val + " ");
				dealt.add(node);
			} else {
				if (dealt.contains(node.left)) {
					System.out.print(node.val + " ");
					dealt.add(node);
				} else {
					if (node.right != null) stack.push(node.right);
					stack.push(node);
					if (node.left != null) stack.push(node.left);
				}
			}
		}
		System.out.println();
	}
	
	private static void printBFS(TreeNode root) {
		if (root == null) return;
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			System.out.print(node.val + " ");
			if (node.left != null) que.offer(node.left);
			if (node.right != null) que.offer(node.right);
		}
		System.out.println();
	}
}
