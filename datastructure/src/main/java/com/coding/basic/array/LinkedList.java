package com.coding.basic.array;


import java.util.NoSuchElementException;

import com.coding.basic.Iterator;
import com.coding.basic.List;

public class LinkedList implements List{
	
	private Node head;
	
	private Node end;
	
	private int size = 0;
	
	public void add(Object o){
		addLast(o);
		
	}
	public void add(int index , Object o){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("this is Index out");
		}
		if(index == size)
			addLast(o);
		else
			linkBefore(o, node(index));
	}
	void linkBefore(Object o,Node succ){
		// assert succ != null;
		final Node temp = succ.prev;
		final Node newNode = new Node(temp, o, succ);
		succ.prev = newNode;
		if(temp == null)
			head = newNode;
		else
			temp.next = newNode;
		size++;
		
	}
	public Object get(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("this is Index out");
		}
		return node(index).data;
	}
	Node node(int index){
		if(index < (size >> 1)){
			Node x = head;
			for (int i = 0; i < index; i++) 
				x = x.next;
			return x;
		}else{
			Node x = end;
			for (int i = size-1; i > index; i--) 
				x = x.prev;
			return x;
		}
	}
	public Object remove(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("index out");
		}
		return unlink(node(index));
	}
	Object unlink(Node x){
		Object element = x.data;
		Node prev = x.prev;
		Node next = x.next;
		
		if(prev == null){
			head = next;
		}else{
			prev.next = next;
			x.prev = null;
		}
		
		if(next == null){
			end = prev;
		}else{
			next.prev = prev;
			x.next = null;
		}
		
		x.data = null;
		size--;
		return element;
	} 
	
	
	public int size(){
		return size;
	}
	
	public void addFirst(Object o){
		final 
		Node temp = head;
		final Node newNode = new Node(null, o, temp);
		head = newNode;
		if(temp==null)
			end = newNode;
		else
			temp.prev = newNode;
		size++;
	}
	
	public void addLast(Object o){
		final Node temp = end;
		final Node newNode = new Node(temp, o, null);
		end = newNode;
		if(temp == null)
			head = newNode;
		else
			temp.next = newNode;
		
		size++;
	}
	public Object removeFirst(){
		final Node f = head;
		if (f == null)
        throw new NoSuchElementException();
		
		return unlinkHead(f);
	}
	private Object unlinkHead(Node f){
		final Object element = f.data;
		final Node next = f.next;
		f.next = null;
		f.data = null;
		head = next;
		if(next == null){
			end = null;
		}else{
			next.prev = null;
		}
		size--;
		return element;
	}
	public Object removeLast(){
		final Node e = end;
		if (e == null)
        throw new NoSuchElementException();
		return unlinkEnd(e);
	}
	private Object unlinkEnd(Node e){
		final Object element = e.data;
		final Node prev = e.prev;
		e.prev = null;
		e.data = null;
		end = prev;
		if(prev == null)
			head = null;
		else
			prev.next = null;
		
		size--;
		return element;
	}
	public Iterator iterator(){
		return null;
	}
	
	
	private static  class Node{
		Object data;
		Node next;
		Node prev;
		
		 Node(Node prev,Object data,Node next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
		
	}
	
	
	
	
	
	
	/**
	 * 把该链表逆置
	 * 例如链表为 3->7->10 , 逆置后变为  10->7->3
	 */
	public  void reverse(){		
		
	}
	
	/**
	 * 删除一个单链表的前半部分
	 * 例如：list = 2->5->7->8 , 删除以后的值为 7->8
	 * 如果list = 2->5->7->8->10 ,删除以后的值为7,8,10

	 */
	public  void removeFirstHalf(){
		
	}
	
	/**
	 * 从第i个元素开始， 删除length 个元素 ， 注意i从0开始
	 * @param i
	 * @param length
	 */
	public  void remove(int i, int length){
		
	}
	/**
	 * 假定当前链表和listB均包含已升序排列的整数
	 * 从当前链表中取出那些listB所指定的元素
	 * 例如当前链表 = 11->101->201->301->401->501->601->701
	 * listB = 1->3->4->6
	 * 返回的结果应该是[101,301,401,601]  
	 * @param list
	 */
	public  int[] getElements(LinkedList list){
		return null;
	}
	
	/**
	 * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 从当前链表中中删除在listB中出现的元素 

	 * @param list
	 */
	
	public  void subtract(LinkedList list){
		
	}
	
	/**
	 * 已知当前链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）
	 */
	public  void removeDuplicateValues(){
		
	}
	
	/**
	 * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
	 * 试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）
	 * @param min
	 * @param max
	 */
	public  void removeRange(int min, int max){
		
	}
	
	/**
	 * 假设当前链表和参数list指定的链表均以元素依值递增有序排列（同一表中的元素值各不相同）
	 * 现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列
	 * @param list
	 */
	public  LinkedList intersection( LinkedList list){
		return null;
	}
	
}
