package pr1.a11;

import java.util.ArrayList;

public class ListStack extends AbstractStack{
	protected ArrayList<Object> content;


	public ListStack(int i){
		super(i);
		content = new ArrayList<Object>(i);
		size++;
	}

	public ListStack(){
		super(10);
		content = new ArrayList<Object>(10);
		size++;
	}

	@Override
	public Object pop() {
		if(size>0 && size<=capacity){
			String result = content.get(size-1).toString();
			content.remove(size-1);
			size--;
			return result;
		}else{
			size++;
			return "Fehler : UnderFlow : ";	
		}
	}

	@Override
	public Object peek() {
		if(size>0 && size<=capacity){
			return content.get(size-1);
		}else{
			if (size>capacity){
				size--;
				return "Fehler : Overflow : ";
			}
			if(size<=0){
				return "Fehler : Underflow : ";
			}
			return "Fehler : Dies sollte nie angezeigt werden !";
		}	
	}

	@Override
	public void push(Object o) {
		if(size>=0 && size<=capacity){
			content.add(o);
			size++;
		}else{
			size--;
			System.out.println("Fehler : Overflow : ");
		}
	}

	@Override
	public int getsize() {
		return size;
	}
}
