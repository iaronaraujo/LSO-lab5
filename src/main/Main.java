package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import algorithms.CScan;
import algorithms.DiskAlgorithm;
import algorithms.FCFS;
import algorithms.SSF;
import algorithms.Scan;
import disk.Disk;

public class Main {

	public static void main(String[] args) throws IOException {
		List<DiskAlgorithm> algorithms = new ArrayList<>();
		algorithms.add(new FCFS());
		algorithms.add(new SSF());
		algorithms.add(new Scan());
		algorithms.add(new CScan());
		
		List<Integer> bufferSizes = new ArrayList<>();
		bufferSizes.add(10);
		bufferSizes.add(50);
		bufferSizes.add(100);
		bufferSizes.add(200);
		bufferSizes.add(500);
		bufferSizes.add(1000);
		
		Disk disk;
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Output.plot")));
		StringBuffer output = new StringBuffer();
		output.append("moves,buffer_size,algorithm\n");
		
		for(DiskAlgorithm alg : algorithms){
			for(Integer size : bufferSizes){
				Path inputPath = Paths.get("input/trace_1.txt");
				BufferedReader reader = Files.newBufferedReader(inputPath);
				
				String line = "";
				Deque<Integer> input = new ArrayDeque<>();
				
				while((line = reader.readLine()) != null) {
					input.add(Integer.parseInt(line));
					
				}
				
				System.out.println("Executando: " + alg.getName() + " Size: " + size);
				disk = new Disk(size, alg, input);
				output.append(disk.run().toString() + "\n");
			}
		}
		writer.write(output.toString());
		writer.flush();
		writer.close();
		

	}

}
