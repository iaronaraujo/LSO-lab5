package algorithms;

import buffer.InputBuffer;
import disk.Needle;

public class SSF implements DiskAlgorithm{
	
	public SSF(){
		
	}

	@Override
	public Integer access(InputBuffer buffer, Needle needle) {
		Integer closer = null;
		int closerDistance = Integer.MAX_VALUE;
		int distance = Integer.MAX_VALUE;
		for(Integer entry : buffer.getBuffer()){
			distance = Math.abs(entry - needle.getPosition());
			if(distance < closerDistance){
				closer = entry;
				closerDistance = distance;
			}
		}
		return closer;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SSF";
	}

	@Override
	public boolean moveNeedle(Integer target, Needle needle) {
		if(target > needle.getPosition()){
			needle.moveUp();
		}else if(target < needle.getPosition()){
			needle.moveDown();
		}
		return true;
	}
	
	

}
