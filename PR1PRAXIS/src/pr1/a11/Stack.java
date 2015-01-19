package pr1.a11;

public class Stack extends AbstractStack {
	protected Object[] content;

	public Stack(int capacity){
		super(capacity);
		content = new Object[capacity];
		
	}
	public Stack(){
		this(10);
		
	}
	@Override
	public Object pop() {
		try{

			return content[size--];

		}catch(Exception e){
			size++;
			return "Fehler : UnderFlow : "+e.toString();	
		}
	}
	@Override
	public Object peek() {
		try{
			return content[size];
		}catch(Exception e){
			if (size>=capacity-1){
				size--;
				return "Fehler : Overflow : "+e.toString();
			}
			if(size<0){
				size = 0;
				return "Fehler : Underflow : "+e.toString();
			}
			return "Fehler : Dies sollte nie angezeigt werden !";
		}	
	}
	@Override
	public void push(Object o) {
		try{
			content[++size] = o;
		}catch(Exception e){
			size--;
			System.out.println("Fehler : Overflow : "+e.toString());
		}
	}
	@Override
	public int getsize() {
		return size;
	}

}
