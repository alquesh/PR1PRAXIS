package pr1.a11;

public abstract class AbstractStack {
	protected Object[] content;
	protected int capacity;
	protected int size;
	protected boolean overflow;
	protected boolean underflow;
	
	public AbstractStack(int capacity){
		content = new Object[capacity];
		this.capacity = capacity;
		size = 0;
		
	}
	public AbstractStack(){
		content = new Object[10];
		capacity = 10;
		size = 0;
		
	}
	public abstract Object pop();
	public abstract Object peek();
	public abstract Object push(Object o);
	public abstract int getsize();
	

}
