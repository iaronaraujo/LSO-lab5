package disk;

public class Needle {
	
	private int position;
	
	public Needle(){
		position = 0;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public void moveUp(){
		this.position++;
	}
	
	public void moveDown(){
		this.position--;
	}
	
	public void reset(){
		this.position = -1;
	}

}
