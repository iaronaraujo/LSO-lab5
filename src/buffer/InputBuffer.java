package buffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputBuffer {
	
	
	private Deque<Integer> buffer;
	private int maxSize;
	
	public InputBuffer(int maxSize){
		this.buffer = new ArrayDeque<>();
		this.maxSize = maxSize;
	}
	
	
	public boolean add(Integer x){
		boolean result = false;
		if(buffer.size() < maxSize){
			buffer.add(x);
			result = true;
		}
		return result;
	}
	
	public boolean remove(Integer x){
		return this.buffer.remove(x);
	}
	
	public Deque<Integer> getBuffer(){
		return this.buffer;
	}
	
	public boolean isEmpty(){
		return this.buffer.isEmpty();
	}
	
	public int getMaxSize(){
		return this.maxSize;
	}
	

}
