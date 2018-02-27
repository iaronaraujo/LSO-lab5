package algorithms;

import buffer.InputBuffer;
import disk.Needle;

public class FCFS implements DiskAlgorithm{
	
	public FCFS(){
		
	}

	@Override
	public Integer access(InputBuffer buffer, Needle needle) {
		return buffer.getBuffer().getFirst();
	}

	@Override
	public String getName() {
		return "FCFS";
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
