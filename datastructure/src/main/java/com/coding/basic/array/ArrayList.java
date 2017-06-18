package com.coding.basic.array;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import com.coding.basic.Iterator;
import com.coding.basic.List;

public class ArrayList implements List{
	
	private int size = 0;
	
	private Object[] elementData = new Object[3];
	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	@Override
	public void add(Object o) {
		int sizeAdd = size + 1;
		if(sizeAdd < elementData.length){
			elementData[sizeAdd] = o;
		}else{
			grow(sizeAdd);
		}
		//这是为了先让size的值增加
		elementData[size++] = o;
	}
	/**
	 * 数组增加容量
	 * @param minCap
	 */
	private void grow(int minCap){
		
		int oldCap = elementData.length;
		int newCap = oldCap + (oldCap >> 1);
		//当新增容量小于所传入容量
		if(newCap < minCap)
			newCap = minCap;
		if(newCap > MAX_ARRAY_SIZE)
			newCap = hugeCapacity(minCap);
		
		elementData = Arrays.copyOf(elementData, newCap);
	}
	
	private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
	
	
	@Override
	public void add(int index, Object o) {
		//先判断指定位置索引不能是负数并且不大于原有数组的大小
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		
		int sizeAdd = size + 1;
		if (sizeAdd - elementData.length > 0)
            grow(sizeAdd);
//		System.out.println("length:"+elementData.length);
//		System.out.println("sizeAdd:"+sizeAdd);
		for (int i = sizeAdd-1; i > index ; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = o;
		
		size++;
	}
	
	@Override
	public Object get(int index) {
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		return elementData[index];
	}
	
	@Override
	public Object remove(int index) {
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		Object oldValue = elementData[index];
		for (int i = index; i < size-1; i++) {
			System.out.println("asd");
			elementData[i] = elementData[i+1];
		}
		
		elementData[--size] = null;
		
		return oldValue;
	}
	
	public boolean remove(Object o) {
		if(o == null){
			for (int i = 0; i < size; i++) {
				if(elementData[i] == null){
					fastRemove(i);
					return true;
				}
			}
		}else{
			for (int i = 0; i < size; i++) {
				if(o.equals(elementData[i])){
					fastRemove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	private void fastRemove(int index){
		int moveLength = size - index - 1;
		System.arraycopy(elementData, index+1, elementData, index, moveLength);
		elementData[--size] = null;
	}
	@Override
	public int size() {
		return size;
	}
	
	
	public Iterator iterator(){
		return new Itr();
	}
	
	private class Itr implements Iterator{
		//remove 直接先查看源码即可，为了节约时间。checkForComodification这类检查暂时就不需要实现
		//remove 只是为了让在当前获取的元素删除之前，判断是否针对结构由改动，有改动直接报异常，
		//如果没有改动，直接删除当前获取的元素，因为删除以后，后面元素都已向前挪移一个位置，
		//获取元素位置的索引需要变回删除的那个元素的索引
		int nextIndex;
		
		@Override
		public boolean hasNext() {
			return nextIndex != size;
		}
		@Override
		public Object next() {
			int i = nextIndex;
			if(i > size){
				throw new NoSuchElementException();
			}
			Object[] elementData = ArrayList.this.elementData;
			if (i >= elementData.length)
                throw new ConcurrentModificationException();
				nextIndex = i+1;
			return elementData[i];
			
			
		}
	}
	
	
}
