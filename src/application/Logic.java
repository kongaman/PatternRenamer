package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

public class Logic {
	   
	   public char verifySplit(ArrayList<File> fileList) {
	      HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
	      char sc;
	      for (File file : fileList) {
	    	  String fileName = FilenameUtils.getBaseName(file.getName());
	    	  //Check for -,.,_ as splitcharacter
	    	  int minus = fileName.length() - fileName.replaceAll("-","").length();
		      int dot = fileName.length() - fileName.replaceAll(".","").length();
		      int underscore = fileName.length() - fileName.replaceAll("_","").length();
		      if(minus > dot && minus > underscore){
		         sc = '-';
		      } else if(dot > minus && dot > underscore){
		    	  sc = '.';
		      } else if(underscore > minus && underscore > dot) {
		    	  sc = '_';
		      } else {
		    	  sc = 'x';
		      }
		      //Enter character into hashmap or add to charcount
		      if (hmap.isEmpty() && sc != 'x') {
		         hmap.put(sc, 1);
		      } else if (!hmap.containsKey(sc) && sc != 'x'){
		         hmap.put(sc, 1);
		      } else if (hmap.containsKey(sc)) {
		         hmap.put(sc, hmap.get(sc) + 1);
		      }
		   }
	      //Get char with max counts on it
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
