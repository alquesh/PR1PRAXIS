package pr1.a11;

public class Stack extends AbstractStack {

	@Override
	public Object pop() {
		try{
			return content[--size];
		}catch(IllegalArgumentException e){
			return "Stack ist leer";	
		}
	}

	@Override
	public Object peek() {
		try{
			return content[--size];
		}catch(IllegalArgumentException e){
			return "Stack ist leer";	
		}
	}

	@Override
	public Object push(Object o) {
		try{
			content[size++] = o;
		}catch(IllegalArgumentException e){
			
		}
		return o;
	}

	@Override
	public int getsize() {
		
		return size;
	}

}
