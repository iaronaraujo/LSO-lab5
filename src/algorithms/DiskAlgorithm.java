package algorithms;

import buffer.InputBuffer;
import disk.Needle;

public interface DiskAlgorithm {
	
	
	public Integer access(InputBuffer buffer, Needle needle);
	
	public String getName();
	
	public boolean moveNeedle(Integer target, Needle needle);

}
