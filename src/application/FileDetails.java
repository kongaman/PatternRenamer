package application;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

public class FileDetails {
	
	private File f;
	private String origFilename;
	private String prefix;
	private String suffix;
	private String stripped;
	private ArrayList<NamePart> parts;
	private String renamedFilename;
	private char seperator;
	
	public FileDetails(File f) {
		this.f = f;
		this.origFilename = f.getName();
		this.suffix = "." + FilenameUtils.getExtension(origFilename);
		this.stripped = FilenameUtils.getBaseName(origFilename);
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

	public String getOrigFilename() {
		return origFilename;
	}

	public void setOrigFilename(String origFilename) {
		this.origFilename = f.getName();
	}
	
	public char getSeperator() {
		return seperator;
	}

	public void setSeperator() {
		int minus = stripped.length() - stripped.replaceAll("-","").length();
		int dot = stripped.length() - stripped.replaceAll(".","").length();
		int underscore = stripped.length() - stripped.replaceAll("_","").length();
		if(minus > dot && minus > underscore){
			this.seperator = '-';
		} else if(dot > minus && dot > underscore){
			this.seperator = '.';
		} else if(underscore > minus && underscore > dot) {
			this.seperator = '_';
		} else {
			this.seperator = 'x';
		}
		System.out.println("Seperator found for this file: " + this.seperator);
	}

	public ArrayList<NamePart> getParts() {
		return parts;
	}

	public void setParts(ArrayList<NamePart> parts) {
		this.parts = parts;
	}

	public String getStripped() {
		return stripped;
	}

	public void setStripped(String stripped) {
		this.stripped = FilenameUtils.getBaseName(origFilename);
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix() {
		this.suffix = "." + FilenameUtils.getExtension(origFilename);;
	}

	public String getRenamedFilename() {
		return renamedFilename;
	}

	public void setRenamedFilename() {
		String partName = "";
		for (NamePart namePart : parts) {
			if (namePart.isVisibile()) {
				partName += namePart.getNamePart();
			}
		}		
		this.renamedFilename = prefix + partName + suffix;
	}	
	

}
