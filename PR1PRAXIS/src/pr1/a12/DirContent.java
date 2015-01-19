package pr1.a12;

import java.io.File;
import java.io.PrintWriter;

public class DirContent {
	
	
	public static void main(String[] args){
		
	}
	
	public static void printAll(File path){
		PrintWriter out = new PrintWriter(System.out,true);
		File[] content = path.listFiles();
		out.printf("%11s 	%s\n",getType(path),path.getAbsolutePath());
		out.println();
		for(File s : content){
			
			out.printf("%11s 	%s\n",getType(s),s.getName());
		}
		out.println();

	}
	
	public static void printAll(String path){
		printAll(new File(path));
	}
	public static void printFilesOnly(File path){
		PrintWriter out = new PrintWriter(System.out,true);
		File[] content = path.listFiles();
		out.printf("%11s 	%s\n",getType(path),path.getAbsolutePath());
		out.println();
		for(File s : content){
			if(getType(s)=="Datei"){
				out.printf("%11s 	%s\n",getType(s),s.getName());
				}
			

		}
		out.println();

	}
	public static void printDirsOnly(File path){
		PrintWriter out = new PrintWriter(System.out,true);
		File[] content = path.listFiles();
		out.printf("%11s 	%s\n",getType(path),path.getAbsolutePath());
		out.println();
		for(File s : content){
			if(getType(s)=="Verzeichnis"){
				out.printf("%11s 	%s\n",getType(s),s.getName());
				}
		}
		out.println();

	}
	
	public static String getType(File f){
		
		if (f.isFile()){
			return "Datei";
		}
		return "Verzeichnis";
	}
	public static void test(File[] path){
		File test = new File("./listen");
		printAll(test);
		
		printFilesOnly(test);
		printDirsOnly(test);
	}
}
