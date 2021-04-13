package com.velociter.training.aalam.generics;

import java.io.Serializable;

public class Stack<T> implements Serializable // here we Mention <T> as TypeArgument as a Double
{

	private Object[] items;
	private int bottomPossition = 0;
	final static int limit = 10; // Initial stack capacity

	public Stack() // constructor to initialize Stack Object with Stack size
	{
		items = new Object[limit];
	}

	public void push(T item) {
		if (bottomPossition == items.length) // it means both are equal means no data available(means stack is empty)
		{
			Object[] insertItem = new Object[items.length];

			for (int i = 0; i < items.length; i++) {
				insertItem[i] = items[i]; // here we are storing upcomming data into Object[] one by one
			}

		}
		items[bottomPossition++] = item; // bottum possition increement place will change after push element
	}

	public Object pop() {
		if (bottomPossition == 0) // here we first check .is stack allready null or not if yes then return null
		{
			return null;
		}

		T item = (T) items[--bottomPossition]; // if in the stack have some item then we have to pop item by decreez te
		items[bottomPossition] = null; // deleteing item (pop item)
		return item;
	}

	// listAll() to get display the stack elements
	public void listAll() {
		for (int i = bottomPossition - 1; i >= 0; --i)
		{
			System.out.print(((T) items[i]) + "  ,  ");
		}
	}

	public boolean isEmpty() {
		return bottomPossition == 0;
	}

}
