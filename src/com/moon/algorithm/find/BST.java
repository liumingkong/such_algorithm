package com.moon.algorithm.find;

/**
 * @ClassName: BST 
 * @Description: TODO
 * @author liuzhao
 * @date 2013-6-18 上午12:34:16 
 * 
 * 二叉查找树
 * 数据结构是结点：在二叉树中，每个结点只能有一个父节点指向自己（只有根节点没有父节点）
 * 每个结点都只有左右两个链接，分别指向自己的左子结点和右子结点
 * 每个结点还包含一个键和一个值，键之间也有顺序之分以支持高效的查找
 * 
 * 定义：一棵二叉查找树是一棵二叉树，其中每个结点都含有一个Comparable的键以及相关联的值
 * ，并且每个结点的键都大于其左子树中的任意结点的键而小于右子树的任意结点的键
 * 
 * 二叉查找树的算法的运行时间取决于树的形状
 * 而树的形状取决于键被插入的先后顺序。
 * 最好的情况，一棵含有N个结点的树是完全平衡的，每条空链接和根结点的距离都为lgN。
 * 最坏的情况下，搜索路径上可能会有N个结点。
 *  
 */
public class BST<Key extends Comparable<Key>,Value> extends SignTable<Key ,Value>{

	private Node root;
	
	class Node{
		Key key; // 键
		Value value; // 值
		Node left; // 左子树链接
		Node right; // 右子树链接
		Integer count; // 结点计数器，以该结点为根的子树种的结点总数
	}

	@Override
	void put(Key key, Value value) {
		root = put(root,key,value);
	}

	Node put(Node node, Key key,Value value) {
		if ( node == null ) return genNode(key, value);
		int result = (key.compareTo(node.key));
		if ( result < 0 ) node.left = put(node.left, key, value);
		else if (result > 0) node.right = put(node.right, key, value);
		else node.value = value;
		node.count = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	private Node genNode(Key key,Value value) {
		Node node = new Node();
		node.key = key;
		node.value = value;
		node.count = 1;
		return node;
	}
	
	void putByLiu(Key key, Value value) {
		if (root == null) {
			root = genNode(key,value);
		} else {
			putByLiu(root, key, value);
		}
	}
	
	/**递归插入数据,by liu zhao*/
	void putByLiu(Node node, Key key,Value value) {
		if (node == null) return;
		int result = (key.compareTo(node.key));
		if (result < 0) {
			if (node.left != null) {
				putByLiu(node.left,key,value);
			} else {
				Node newNode = genNode(key,value);
				node.left = newNode;
				node.count ++;
			}
		} else if(result>0) {
			if (node.right != null ) {
				putByLiu(node.right,key,value);
			} else {
				Node newNode = genNode(key,value);
				node.right = newNode;
				node.count ++;
			}
		} else {
			node.value = value;
		}
		
	}
	
	@Override
	Value get(Key key) {
		Node node = searchRecu(root, key);
		if (node != null) {
			return node.value;
		}
		return null;
	}
	
	/** 
	 * 递归查找：如果树是空的，则查找未命中;如果被查找的键和根节点的键相等，查找命中
	 * 否则递归的在适当的子树中继续查找，较小就查左子树，较大就查右子树
	 */
	Node searchRecu(Node node, Key key) {
		if (node == null) return null;
		int result = (key.compareTo(node.key)) ;
		if (result < 0) {
			return searchRecu(node.left,key);
		} else if ( result > 0) {
			return searchRecu(node.right,key);
		} else {
			return node;
		}
	}
	
	@Override
	int size() {
		return size(root);
	}

	/** 二叉树中某个结点为根的树的元素总数 = 其左子树的元素总数 + 其右子树的元素总数 + 1（结点本身）*/
	private int size(Node node) {
		if (null == node) return 0;
		return size(node.left) + size(node.right) + 1;
	}
	
	@Override
	Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**  
	 * 最大键
	 * 如果根结点的右链接为空，那么最大键就是根结点
	 * 如果右链接不为空，那么最大键要沿着右边结点找下去
	 */
	public Value max() {
		if (root == null) return null;
		return max(root);
	}
	
	private Value max(Node node) {
		if (node.right == null) {
			return node.value;
		} else {
			return max(node.right);
		} 
	}
	
	/** 
	 * 最小键
	 * 如果根结点的左链接为空，那么最小键就是根结点
	 */
	public Value min() {
		if (root == null) return null;
		return min(root).value;
	}
	
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		} else {
			return min(node.left);
		} 
	}
	
	/**
	 * 查找排名为k的键，即树中恰好有k个小于它的键
	 * 如果左子树中的结点数t大于k，那么就继续(递归)在左子树中查找排名为k的键
	 * 如果t等于k，返回根结点中的键
	 * 如果左子树中的结点数t小于k，递归地在右子树中查找排名为(k-t-1)的键
	 */
	public Key select(int k) {
		Node node = select(root, k);
		if (node == null) 
			return null;
		return node.key;
	}
	
	private Node select(Node x,int k) {
		if (x == null) return null;
		int t = size(x.left);
		if (t > k) return select(x.left, k);
		else if (t < k) return select(x.right, k-t-1);
		else return x;
	}
	
	/** 
	 * 返回给定键的排名
	 * 如果给定的键和根结点的键相等，返回左子树中的结点总数
	 * 如果给定的键小于根结点，返回该键在左子树中的排名
	 * 如果给定的键大于根结点，返回t+1(根结点)加上它在右子树中的排名
	 */
	public int rank(Key key) {
		return rank(root, key);
	}
	
	private int rank(Node x, Key key) {
		if (x==null) return 0;
		if (key == null) return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return rank(x.left, key);
		else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
		else return size(x.left);
	}
	
	/** 
	 * 删除最小键
	 * 不断深入根结点的左子树中直到遇见一个空链接
	 * 然后将指向该结点的链接指向该结点的右子树(只需在递归调用中返回它的右链接)
	 * 终点会有两种情况：1.该结点没有右结点，2.该结点有右结点
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node) {
		if (node.left == null) return node.right; // 返回右边结点
		node.left = deleteMin(node.left);
		node.count = size(node);
		return node; // 返回更新了count的结点
	}
	
	/**
	 * 删除操作
	 * 如何删除一个拥有两个子结点的结点？
	 * Hibbard提出解决算法：在删除结点x后用它的后继结点补充它的位置
	 * 因为x有一个右子结点，因此它的后继结点就是其右子树中的最小结点
	 * 这样的替换仍能够保证树的有序性，
	 * 因为x.key和它的后继结点的键之间不存在其他的键
	 * 
	 * 用四个步骤完成将x替换为它的后继结点：
	 * 1.将指向即将被删除的结点的链接保存为t
	 * 2.将x指向它的后继结点min(t.right)
	 * 3.将x的右链接(原本指向一棵所有结点都大于x.key的二叉查找树)
	 * 指向deleteMin(t.right),也就是在删除后所有结点仍然都大于x.key的子二叉查找树
	 * 4.将x的左链接(本为空)设为t.left(其下所有的键都小于被删除的结点和它的后继结点)
	 * 
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = delete(x.left, key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;
			x = min(x.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x);
		return x;
	}
}
