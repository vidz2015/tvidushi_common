package com.vidushi.takshila.linkedlist;

public interface IList<T> {
	
	
public  void traverse();
public void insertAtFirst(T data);

public void insertAtIndex(T data,int index);

public  void insertInLast(T data);

public void removeFirst();

public void removeLast();


public T get(int index);



}
