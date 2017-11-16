package br.com.sergio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestePerformance {
	
	public static void main(String[] args) {
		
		rodaLoopFor();
		rodaParallelStream();
		rodaStream();
		
		
	}
	
	private static void rodaLoopFor() {
		
		List<Integer> numeros = Arrays.asList(1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		long start = System.currentTimeMillis();
		
		List<Integer> numerosPares = new ArrayList<>();
		for(Integer n : numeros) {
			if(n % 2 == 0) {
				numerosPares.add(n);
			}
		}
		
		System.out.println("LOOP-FOR: "+numeros.toString());
		System.out.println("LOOP-FOR: "+numerosPares.toString());
		System.out.println("TEMPO: "+(System.currentTimeMillis()-start)+" ms.");
	}

	private static void rodaStream() {
		
		List<Integer> numeros = Arrays.asList(1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		long start = System.currentTimeMillis();
		List<Integer> numerosPares = numeros
			.stream()
			.filter(n -> n % 2 == 0)
			.collect(Collectors.toList());
		
		System.out.println("STREAM: "+numeros.toString());
		System.out.println("STREAM: "+numerosPares.toString());
		System.out.println("TEMPO: "+(System.currentTimeMillis()-start)+" ms.");
	}
	
	private static void rodaParallelStream() {
		
		List<Integer> numeros = Arrays.asList(1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		long start = System.currentTimeMillis();
		List<Integer> numerosPares = numeros
			.parallelStream()
			.filter(n -> n % 2 == 0)
			.collect(Collectors.toList());
		
		System.out.println("PARALLEL STREAM: "+numeros.toString());
		System.out.println("PARALLEL STREAM: "+numerosPares.toString());
		System.out.println("TEMPO: "+(System.currentTimeMillis()-start)+" ms.");
	}

}
