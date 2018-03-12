package input;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InputGenerator {
	
	
	public static void main(String[] args) {
		InputGenerator ig = new InputGenerator();
		
		ig.generateInput("Trace-4", 1, 2999, 100);
	}
	
	public InputGenerator() {
		
	}
	
	public void generateInput(String fileName, int lowNumber, int highNumber, int numberQtd) {
		Path path = Paths.get("input/" + fileName + ".txt");
		try {		
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for (int i = 0; i < numberQtd; i++) {
				Random random = new Random();
				writer.write((lowNumber + random.nextInt(highNumber + 1)) + " " + (lowNumber + random.nextInt(99)) + " " + "r" + "\n");
			}
			
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
