package com.globalClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyTools{
	
	public void resource(String string) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = "/"+string + "\n";
	        File file = new File("resource.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (bw != null)
	                bw.close();
	            if (fw != null)
	                fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	public void statusCode(String string) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = string + "\n";
	        File file = new File("statusCode.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (bw != null)
	                bw.close();
	            if (fw != null)
	                fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	
	
	
	public void responseBody(String string) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = string + "\n";
	        File file = new File("responseBody.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (bw != null)
	                bw.close();
	            if (fw != null)
	                fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
