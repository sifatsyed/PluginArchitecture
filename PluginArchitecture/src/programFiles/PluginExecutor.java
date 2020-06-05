package programFiles;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PluginExecutor {
	
	public PluginExecutor() {}
	
	public static void statusReport(int statusCode, Integer fileType) {
		String fileExtension = null;
		if(fileType == 1) {
			fileExtension = "Python ";
		} else { 
			fileExtension = "Shell ";
		}
		
		 if(statusCode == 0) {
				System.out.println("Success! " + fileExtension + "Script output generated!");
			} else if(statusCode == 1){
				System.out.println(fileExtension + "Script: Failed! Check your code!");
			} else {
				System.out.println(fileExtension + "Script: Error with process!");
			}
	}
	
	//Change this to return pluginResult
	public PluginResult run(String pluginName, Integer fileType) throws IOException, InterruptedException {
		Process p;
		String outputFile = "C:\\GitHub\\PluginArchitecture\\PluginArchitecture\\src\\resultFiles\\result.txt";
		String outputText = "";
		String timeTakenToRun = "0:0";
		String scriptType = null;
            List<String> command = new ArrayList<String>();
            
            String binPython = "C:\\Users\\sifat\\Python38-32\\python.exe";
            String binShellScript = "C:\\cygwin64\\bin\\tcsh.exe";
            String arg = "C:\\GitHub\\PluginArchitecture\\PluginArchitecture\\src\\files\\" + pluginName;
            
            if(fileType == 1) {
            	command.add(binPython);
            	scriptType = ".py";
            } else if(fileType == 2) {
            	command.add(binShellScript);
            	scriptType = ".sh";
            } else {
            	System.out.println("Invalid file type entered!");
            }
            command.add(arg);
            ProcessBuilder pb = new ProcessBuilder(command);
            p = pb.start();
                
            int statusCode = p.waitFor(); 
            statusReport(statusCode, fileType);
           
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            FileWriter fileWriter = new FileWriter(outputFile);
            String line; 
            fileWriter.write("Output\n");
            outputText += "Output\n";
            fileWriter.write("====================================================\n");
            outputText += "====================================================\n";
            while((line = reader.readLine()) != null) { 
               fileWriter.write(line + "\n");
               outputText += line + "\n";
            } 
            fileWriter.write("====================================================\n");
            outputText += "====================================================\n";
            fileWriter.close();
            PluginResult pluginResult = new PluginResult(outputText, timeTakenToRun, scriptType);
            return pluginResult;
	}

}
