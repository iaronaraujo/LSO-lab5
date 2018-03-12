package algorithms;

import buffer.InputBuffer;
import disk.Disk;
import disk.Needle;

public class CScan implements DiskAlgorithm{
	
	public CScan(){
		
	}

	@Override
	public Integer access(InputBuffer buffer, Needle needle) {
		Integer closer = new Integer(Disk.N_TRACKS + 2);
		int closerDistance = closer - needle.getPosition();
		int distance = Integer.MAX_VALUE;
		for(Integer entry : buffer.getBuffer()){
			distance = entry - needle.getPosition();
			if(distance < closerDistance && distance > 0){
				closer = entry;
				closerDistance = distance;
			}
		}
		return closer;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CScan";
	}

	@Override
	public boolean moveNeedle(Integer target, Needle needle) {
		boolean result = true;
		needle.moveUp();
		if(needle.getPosition() > Disk.N_TRACKS){
			needle.reset();
			result = false;
		}
		return result;
		
	}
	
	

}
