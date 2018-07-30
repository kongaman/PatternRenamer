package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FilenameUtils;

public class Logic {
	private ArrayList<String> globalParts;

	public char verifySplit(ArrayList<File> fileList) {
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		char sc;
		for (File file : fileList) {
			String fileName = FilenameUtils.getBaseName(file.getName());
			// Check for -,.,_ as splitcharacter
			int minus = fileName.length() - fileName.replaceAll("-", "").length();
			int dot = fileName.length() - fileName.replaceAll(".", "").length();
			int underscore = fileName.length() - fileName.replaceAll("_", "").length();
			if (minus > dot && minus > underscore) {
				sc = '-';
			} else if (dot > minus && dot > underscore) {
				sc = '.';
			} else if (underscore > minus && underscore > dot) {
				sc = '_';
			} else {
				sc = 'x';
			}
			// Enter character into hashmap or add to charcount
			if (hmap.isEmpty() && sc != 'x') {
				hmap.put(sc, 1);
			} else if (!hmap.containsKey(sc) && sc != 'x') {
				hmap.put(sc, 1);
			} else if (hmap.containsKey(sc)) {
				hmap.put(sc, hmap.get(sc) + 1);
			}
		}
		// Get char with max counts on it
		// char max = Collections.max(hmap.entrySet(), (entry1, entry2) ->
		// entry1.getValue() - entry2.getValue()).getKey();
		char max = Collections.max(hmap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

		// Was passiert wenns mehrere gleich hohe gibt?
		return max;
	}

	public ArrayList<String> fillGlobalPatternList(ArrayList<FileDetails> detailList) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		ArrayList<String> allUsableFileNameParts = new ArrayList<>();
		for (FileDetails fileD : detailList) {
			char splitChar = fileD.getSeperator();
			if (splitChar != 'x') {
				String splitName = fileD.getStripped();
				String[] parts = splitName.split("(?=\\" + splitChar + ")");
				ArrayList<String> allFileNameParts = new ArrayList<>(Arrays.asList(parts));
				for (String part : allFileNameParts) {
					if (hmap.isEmpty()) {
						hmap.put(part, 1);
					} else if (!hmap.containsKey(part)) {
						hmap.put(part, 1);
					} else if (hmap.containsKey(part)) {
						hmap.put(part, hmap.get(part) + 1);
					}
				}
			}
		}
		for (Entry<String, Integer> entry : hmap.entrySet()) {
			if (entry.getValue() > (detailList.size() * .4)) {
				allUsableFileNameParts.add(entry.getKey());
			}
		}
		return allUsableFileNameParts;
	}

	public ArrayList<FileDetails> fillParts(ArrayList<FileDetails> detailList, ArrayList<String> globalParts) {
		for (FileDetails fileD : detailList) {
			char splitChar = fileD.getSeperator();
			if (splitChar != 'x') {
				String splitName = fileD.getStripped();
				String[] parts = splitName.split("(?=\\" + splitChar + ")");
				ArrayList<NamePart> allParts = new ArrayList<>();
				for (String part : parts) {
					if(globalParts.contains(part)) {
						allParts.add(new NamePart(part, true));
					} else if (fileD.getPrefix().isEmpty()){
						fileD.setPrefix(part);
					}			
				}
				fileD.setParts(allParts);
			} else {
				fileD.setParts(new ArrayList<>());
			}
		}
		return detailList;
	}

	public ArrayList<String> getGlobalParts() {
		return globalParts;
	}

	public void setGlobalParts(ArrayList<String> globalParts) {
		this.globalParts = globalParts;
	}
	
}
