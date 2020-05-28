package programFiles;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PluginExecutor {
	
	public PluginExecutor() {}
	
	public String pythonExecutor(String outputFile) throws IOException, InterruptedException {
		
		//String[] command = {"C:\\Users\\sifat\\PycharmProjects\\helloWorld\\venv\\Scripts\\python.exe", "C:\\SNRG\\PluginArchitecture\\PluginArchitecture\\src\\files\\helloWorld.py"};
		String outputText = "";
		List<String> command = new ArrayList<String>();
        command.add("C:\\Users\\sifat\\PycharmProjects\\helloWorld\\venv\\Scripts\\python.exe");
        command.add("C:\\SNRG\\PluginArchitecture\\PluginArchitecture\\src\\files\\helloWorld.py");
		ProcessBuilder pb = new ProcessBuilder(command);
		
			Process process = pb.start();
			
			if(process.waitFor() == 0) {
				System.out.println("Success! Python output generated!");
			} else if(process.waitFor() == 1){
				System.out.println("Python: Failed! Check your code!");
			} else {
				System.out.println("Python: Error with process!");
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			FileWriter fileWriter = new FileWriter(outputFile);
			fileWriter.write("====================================================\n");
			outputText += "====================================================\n";
			fileWriter.write("Python Output\n====================================================\n");
			outputText += "Python Output\n====================================================\n";
			while((line = reader.readLine()) != null) {
				fileWriter.write(line + "\n");
				outputText += line + "\n";
			}
			fileWriter.write("====================================================\n");
			outputText += "====================================================\n";
			fileWriter.close();
		
		return outputText;
	}
	
	public String shellScriptExecutor(String outputFile) throws IOException, InterruptedException {
		Process p;
		String outputText = "";
            List<String> command = new ArrayList<String>();
            command.add("C:\\cygwin64\\bin\\tcsh.exe");
            command.add("C:\\SNRG\\PluginArchitecture\\PluginArchitecture\\src\\files\\helloWorld.sh");
            ProcessBuilder pb = new ProcessBuilder(command);
            p = pb.start();
                
            p.waitFor(); 
            if(p.waitFor() == 0) {
				System.out.println("Success! Shell Script output generated!");
			} else if(p.waitFor() == 1){
				System.out.println("Shell Script: Failed! Check your code!");
			} else {
				System.out.println("Shell Script: Error with process!");
			}
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
            FileWriter fileWriter = new FileWriter(outputFile);
            String line; 
            fileWriter.write("Shell Script Output\n");
            outputText += "Shell Script Output\n";
            fileWriter.write("====================================================\n");
            outputText += "====================================================\n";
            while((line = reader.readLine()) != null) { 
               fileWriter.write(line + "\n");
               outputText += line + "\n";
            } 
            fileWriter.write("====================================================\n");
            outputText += "====================================================\n";
            fileWriter.close();
            return outputText;
	}

}
