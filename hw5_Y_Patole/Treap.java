//Name: Yash Avinash Patole
//Cwid: 10460520
//Course: CS570
//Homework: Assignment 5

package HW5;

import java.util.Stack;
import java.util.*;
import java.util.Random;
public class Treap <E extends Comparable<E> >{
	//private class node
	/** 
	 * @author Yash Patole CWID : 10460520
	 * @param <E> Generic Type Data
	 */
	private static class Node<E>{
		public E data; // Key for the search
		public int priority; // Random heap priority
		public Node<E > left;
		public Node<E > right;
		public Node(E data, int priority) {
			if(data==null) {
			throw new IllegalArgumentException();
			}
			else {
				this.left=null;
				this.right=null;
				this.data=data;
				this.priority=priority; 
			   			    }
			}
		/**
		 * performs right rotation
		 */
		public Node<E > rotateRight(){
			Node<E> rootNode = new Node<E>(data, priority);
			if(this.left!=null){
				rootNode.left = this.left.right;
				rootNode.right = this.right;
				this.priority = this.left.priority;
				this.data = this.left.data;			
				this.left = this.left.left;
				this.right = rootNode;
			}
			return this;
			}
		/**
		 * performs left rotation
		 */
		public Node<E> rotateLeft() {
			Node<E> temp = this.right;
			Node<E> right = temp.left;
			temp.left = this;
			this.right = right;
			return temp;
		}
		public String toString() {
			return this.data.toString();
			}
		}
	/**
	 * Data Fields
	 */
		
	
	private Node<E> root;
	private Random priorityGenerator;
	
	public Treap() {
		
		priorityGenerator = new Random();
		root = null;
	}
	/**
	 * creates an empty treap and initializes priorityGenerator using new Random(seed)
	 * @param seed
	 */
	public Treap(long seed) {
		
		priorityGenerator = new Random(seed);
		root = null;
	}
	
	public void reheap(Node<E> child, Stack<Node<E>> stack) {
		while (!stack.isEmpty()) {
		Node<E> parent = stack.pop();
		if (parent.priority < child.priority) {
		 if (parent.data.compareTo(child.data) > 0) {
			child = parent.rotateRight();
			}
		 else {
		child = parent.rotateLeft();
			}
	 if (!stack.isEmpty()) {
		if (stack.peek().left == parent) {
			stack.peek().left = child;
		}
		else {
		stack.peek().right = child;
						}
	 }
	 else { 
	    this.root = child;
		}
	 }
		else {
		   break;
		 }
		}
		}
/**
 * performing add
 * @param key
 */
	boolean add(E key){
		return add(key, priorityGenerator.nextInt());
	}
	
	boolean add(E key, int priority) {
		 if (root == null) {
		  root = new Node<E>(key, priority);
			return true;
			}
		 else {
		  Node<E> newNode = new Node<E>(key, priority);
		  Stack<Node<E>> stack = new Stack<Node<E>>();
		  Node<E> baseRoot = root;
		 while (baseRoot != null) {
			baseRoot.data.compareTo(key);
		  if (baseRoot.data.compareTo(key) == 0) {
			 return false;
					}
		  else {
			  if (baseRoot.data.compareTo(key) < 0) {
				stack.push(baseRoot);
				if (baseRoot.right == null) {
				  baseRoot.right = newNode;
				  reheap(newNode, stack);
	            	return true;
					}
			else {
				baseRoot = baseRoot.right;
							}
				}
		else { 
			stack.push(baseRoot);
			if (baseRoot.left == null) {
			 baseRoot.left = newNode;
			 reheap(newNode, stack);
			 return true;
			}
		else {
			baseRoot = baseRoot.left;
			}}
			  }
				}
			return false;
			}
		}
	
	public boolean delete(E key) {
		if (find(key) == false || root == null) {
			return false;
		} else {
			root = delete(key, root);
			return true;
		}
	}
	
	/**
	 * This function helps in delete 
	 * @param key
	 * @param baseRoot
	 * @return
	 */
	private Node<E> delete(E key, Node<E> baseRoot){
	  if (baseRoot == null) {
		return baseRoot;
	   }
	 else {
	   if (baseRoot.data.compareTo(key) < 0) {
		 baseRoot.right = delete(key, baseRoot.right);
		}
	   else {
		  if (baseRoot.data.compareTo(key) > 0) {
			baseRoot.left = delete(key, baseRoot.left);
			}
	  else {
		if (baseRoot.right == null) {
		  baseRoot = baseRoot.left;
			}
		else if (baseRoot.left == null) {
		  baseRoot = baseRoot.right;
			}
		else {
		  if (baseRoot.right.priority < baseRoot.left.priority) {
			baseRoot = baseRoot.rotateRight();
			 baseRoot.right = delete(key, baseRoot.right);
			  }
		 else {
			baseRoot = baseRoot.rotateLeft();
		    baseRoot.left = delete(key, baseRoot.left);
			}}}
			}
		 }
		 return baseRoot;
		 }
	
	private boolean find(Node<E> root,E key){
		if(root==null)
			return false;
		else if((key.compareTo(root.data))>0)
			return find(root.right, key);
		else if((key.compareTo(root.data))<0)
			return find(root.left, key);
		else 
			return true;
	}
	
	public boolean find(E key){
		if(key==null) {
			throw new NullPointerException("Key cannot be null");
		}
		return find(root, key);
	}
	/**
	 * string value of tree
	 */
	
	public String toString(){
		StringBuilder strbuild = new StringBuilder();
		return getPreOrderTraverse(root, 1, strbuild);
	}
	
	private String getPreOrderTraverse(Node<E>node, int depth, StringBuilder strbuild){
		// TODO Auto-generated method stub
		for(int i=1; i< depth; i++){
			strbuild.append("  ");
		}		
		if(node==null)
			strbuild.append("null\n");
		else{
			strbuild.append("(key="+node.data+",priority="+node.priority+")\n\n");
			getPreOrderTraverse(node.left, depth + 1,strbuild);
			getPreOrderTraverse(node.right, depth + 1,strbuild);
		}
		return strbuild.toString();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Treap<Integer> testTree = new Treap<Integer>(); 
		testTree . add (4 ,19); 
		testTree . add (2 ,31);  
		testTree . add (6 ,70); 
		testTree . add (1 ,84);  
		testTree . add (3 ,12); 
		testTree . add (5 ,83);  
		testTree . add (7 ,26); 
		
		System.out.println("Given node is found? : "+ testTree.find(3)); // finding test
		System.out.println("Deleting given Node: "+ testTree.delete(2));   //test for deleting a node
		System.out.println(testTree.toString());

	}

}


	