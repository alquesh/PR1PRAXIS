package pr1.a11;

public abstract class AbstractStack {
	protected int capacity;
	protected int size;

	public AbstractStack(int capacity){	
		this.capacity = capacity;
		size = -1;
	}
	public AbstractStack(){
		capacity = 10;
		size = -1;
	}
	public abstract Object pop();
	public abstract Object peek();
	public abstract void push(Object o);
	public abstract int getsize();
}
