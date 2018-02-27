package output;

public class Output {
	
	private String n_moves;
	private String buffer_size;
	private String alg;
	
	public Output(String moves, String size, String alg){
		this.n_moves = moves;
		this.buffer_size = size;
		this.alg = alg;
	}
	
	
	public String toString(){
		return this.n_moves + "," +this.buffer_size + "," + this.alg;
		
	}

}
