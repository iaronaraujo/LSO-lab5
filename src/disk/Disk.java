package disk;

import java.util.Deque;
import java.util.List;

import algorithms.DiskAlgorithm;
import buffer.InputBuffer;
import output.Output;

public class Disk {
	
	private Needle needle;
	private DiskAlgorithm algorithm;
	private InputBuffer buffer;
	public static final int N_TRACKS = 3000;
	private Deque<Integer> input;
	
	public Disk(int bufferSize, DiskAlgorithm algorithm, Deque<Integer> input){
		this.needle = new Needle();
		this.algorithm = algorithm;
		this.input = input;
		this.buffer = new InputBuffer(bufferSize);
	}
	
	
	public Output run(){
		boolean haveInput = true; // ver como vai ser isso
		long moves = 0;
		Integer target = null;
		int count = 0;
		while(haveInput || !buffer.isEmpty()){
			//check count
			if(count == 0 && haveInput){
				if(buffer.add(input.getFirst())){
					//System.out.println(input);
					target = null;
					input.poll();
					if(input.isEmpty()) haveInput = false;
				}
				
			}
			
			//get new target
			if(target == null){
				target = algorithm.access(this.buffer, this.needle);
			}
			if(target.equals(this.needle.getPosition())){
				this.buffer.remove(target);
				target = null;
				continue;
				//target = algorithm.access(this.buffer, this.needle);
			}
			//moving needle
			if(!target.equals(this.needle.getPosition())){
				if(!algorithm.moveNeedle(target, needle)) target = null;;
				moves++;
			}
			
			
			
			if(++count == 50) count = 0;
		}
		
		
		
		return new Output(Long.toString(moves), Integer.toString(this.buffer.getMaxSize()), this.algorithm.getName());
		
	}
	
	
	

}
