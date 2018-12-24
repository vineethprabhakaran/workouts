package com.vineethds.files;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/*
 * @Author: Vineeth
 * @Description: Program to search and delete the files in the specified directory
 * @Warning: Be Aware when you specify the directory because it may delete all the important files(OS) if you specify the root directory 
 */
public class SearchAndDelete {
	/*
	 * Algorithm Description:
	 * Searches the directories recursively and deletes the files whose names are specified in the set
	 */

	public static void main(String[] args) throws IOException {
		
		SearchAndDelete s = new SearchAndDelete();
		 Set<String> namesToBeDeleted = new HashSet<String>();
		 namesToBeDeleted.add(".metadata");
		 namesToBeDeleted.add(".meta");
		 namesToBeDeleted.add(".prefs");
		 namesToBeDeleted.add(".dmignore");
		 namesToBeDeleted.add(".settings");
		 namesToBeDeleted.add("test");
		 String directory = "C:\\***";
		 s.findFile(new File(directory),namesToBeDeleted);
	}

	private void findFile(File files,Set<String> names) throws IOException {

		File[] list = files.listFiles();
		if(list != null)
			for(File file : list) {
				if (names.contains(file.getName())) {
					System.out.println("Files Deleted: "+file.getAbsolutePath());
					delete(file);
					file.delete();
					continue;
				}
				if(file.isDirectory()) {
					findFile(file,names);
				}
			}
	}

	private void delete(File files) {
		File[] dlist = files.listFiles();
		if (dlist != null)
			for (File file : dlist) {
				if (file.isDirectory()) {
					delete(file);
				}  
				file.delete();
			}
	}

}
