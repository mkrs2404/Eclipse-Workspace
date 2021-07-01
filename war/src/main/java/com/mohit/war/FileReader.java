package com.mohit.war;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {

	public static Map<Integer, Integer> readInput(String path) {
		
		Map<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		File file = new File(path);
		try {
			Scanner sc = new Scanner(file);
			String input;
			if(sc.hasNext()) {
				input = sc.nextLine();
				String[] battalions = input.split(" ");
				for(int i = 1; i < battalions.length; i++) {
					int troopQty = Integer.parseInt(battalions[i].replaceAll("[^\\d]", " ").trim());
					inputMap.put(i, troopQty);
				}
		    }
			else {
				System.out.println("Incorrect input file!!");
				System.exit(0);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
			System.exit(0);
		}
		return inputMap;
	}
}
