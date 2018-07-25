package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Logic {
	
	 private char getSplitChar(String fileName) {
	      int minus = fileName.length() - fileName.replaceAll("-","").length();
	      int dot = fileName.length() - fileName.replaceAll(".","").length() - 1;
	      int underscore = fileName.length() - fileName.replaceAll("_","").length();
	      if(minus > dot && minus > underscore){
	         return '-';
	      } else if(dot > minus && dot > underscore){
	         return '.';
	      } else if(underscore > minus && underscore > dot) {
	         return '_';
	      } else {
	         return 'x';
	      }    
	   }
	   
	   public char verifySplit(ArrayList<File> fileList) {
	      HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
	      int percent40 = (int) Math.ceil(fileList.size() * 0.4);
	      //Falls mehrere Trannzeichen erkannt werden alle in Hashmap eintragen
	      for (int i = 0; i < percent40; i++) {
	         char singleSplitChar = getSplitChar(fileList.get(i).getName());
	         if (hmap.isEmpty() && singleSplitChar != 'x') {
	            hmap.put(singleSplitChar, 1);
	         } else if (!hmap.containsKey(singleSplitChar) && singleSplitChar != 'x'){
	            hmap.put(singleSplitChar, 1);
	         } else if (hmap.containsKey(singleSplitChar)) {
	            hmap.put(singleSplitChar, hmap.get(singleSplitChar) + 1);
	         }
	      }
	      //char max = Collections.max(hmap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
	      char max = Collections.max(hmap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
	      
	      //Was passiert wenns mehrere gleich hohe gibt?
	      return max;
	   }
	   
//	   public ArrayList<FileNamePart> verifyPatternParts(ArrayList<File> fileList, char sep) {
//	      HashMap<FileNamePart, Integer> hmap = new HashMap<FileNamePart, Integer>();
//	      ArrayList<FileNamePart> allFileNameParts = new ArrayList<>();
//	      ArrayList<FileNamePart> allUsableFileNameParts = new ArrayList<>();
//	      for (File file : fileList) {
//	         allFileNameParts = filenameToObjectList(file.getName(), sep);
//	         for (FileNamePart fileNamePart : allFileNameParts) {
//	            if (hmap.isEmpty()) {
//	               hmap.put(fileNamePart, 1); 
//	            } else if (!hmap.containsKey(fileNamePart)){
//	               hmap.put(fileNamePart, 1);
//	            } else if (hmap.containsKey(fileNamePart)) {
//	               hmap.put(fileNamePart, hmap.get(fileNamePart) + 1);
//	            }
//	         }     
//	      }
//	      for (Entry<FileNamePart, Integer> entry : hmap.entrySet()) {
//	         if(entry.getValue() > 3){
//	            allFileNameParts.add(entry.getKey());
//	         }
//	      }  
//	     return allFileNameParts;    
//	   }
//	   
//	   public ArrayList<String> getParts(ArrayList<File> fileList) {
//	      char splitChar = verifySplit(fileList);
//	      System.out.println(splitChar);
//	      ArrayList<String> allParts = new ArrayList<>();
//	      if(splitChar != 'x') {
//	         for(File f : fileList){
//	            String fileName = f.getName();
//	            String[] parts = fileName.split("(?=\\"+ getSplitChar(fileName) + ")");
//	            for(String part : parts){
//	               if(allParts.isEmpty()){
//	                  allParts.add(part);
//	               } else if(!allParts.contains(part) && !allParts.isEmpty()) {
//	                  allParts.add(part);
//	               }
//	            }      
//	         }
//	         return allParts;
//	      } else {
//	         return null;
//	      }   
//	   }
//	   
//	   public ArrayList<FileNamePart> filenameToObjectList(String fileName, char seperator) {
//	      ArrayList<FileNamePart> allFilenameParts = new ArrayList<>();
//	      String[] parts = fileName.split("(?=\\"+ getSplitChar(fileName) + ")");
//	      for(String part : parts){
//	         allFilenameParts.add(new FileNamePart(part, true));
//	      }
//	      return null;    
//	   }
//	   
//	   public String buildFileName(String fileName, char sep) {
//	      String constrFileName = "";
//	      ArrayList<FileNamePart> fnp = filenameToObjectList(fileName, sep);
//	      for (FileNamePart fileNamePart : fnp) {
//	          if(fileNamePart.isVisible()) {
//	             constrFileName += fileNamePart.getNamePart();
//	          }            
//	      }
//	      return constrFileName;
//	   }
}
