package algorithms;

import buffer.InputBuffer;
import disk.Disk;
import disk.Needle;

public class Scan implements DiskAlgorithm{
	
	private boolean isMovingUp;
	
	public Scan(){
		this.isMovingUp = true;
	}

	@Override
	public Integer access(InputBuffer buffer, Needle needle) {
		Integer closer = null;
		if(this.isMovingUp){
			closer = new Integer(Disk.N_TRACKS + 2);
			int closerDistance = closer - needle.getPosition();
			int distance = Integer.MAX_VALUE;
			for(Integer entry : buffer.getBuffer()){
				distance = entry - needle.getPosition();
				if(distance < closerDistance && distance > 0){
					closer = entry;
					closerDistance = distance;
				}
			}
		} else {
			closer = new Integer(-1);
			int closerDistance = needle.getPosition() - closer;
			int distance = Integer.MAX_VALUE;
			for(Integer entry : buffer.getBuffer()){
				distance = entry - needle.getPosition();
				if(distance < closerDistance && distance > 0){
					closer = entry;
					closerDistance = distance;
				}
			}
		}
		
		return closer;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Scan";
	}

	@Override
	public boolean moveNeedle(Integer target, Needle needle) {
		boolean result = true;
		if(this.isMovingUp){
			needle.moveUp();
			if(needle.getPosition() > Disk.N_TRACKS){
				isMovingUp = false;
				result = false;
			}
		} else {
			needle.moveDown();
			if(needle.getPosition() < 0){
				isMovingUp = true;
				result = false;
			}
		}
		
		return result;
	}

}
