package FileReaderPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class MultipleFileProcessor 
{
	    static String Label;
	    static public void fileConcatenator(String outputfilePath,String inputFilePath) throws java.io.IOException 
	    {
		PrintWriter pw = new PrintWriter(new FileOutputStream(outputfilePath));
		File file = new File(inputFilePath);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++)
		{
			BufferedReader br = new BufferedReader(new FileReader(files[i].getPath()));
			String line = br.readLine();
			while (line != null) {
				pw.println(line);
				line = br.readLine();
			}
			br.close();
		}
		pw.close();
		Label="All files have been concatenated a single file";
	}
}