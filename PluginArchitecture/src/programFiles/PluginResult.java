package programFiles;

import java.io.FileWriter;
import java.io.IOException;

public class PluginResult {
	
	public static void outputGenerator(String resultFile) throws IOException, InterruptedException {
		PluginExecutor pythonRun = new PluginExecutor();
		PluginExecutor shellScriptRun = new PluginExecutor();
		
		String pythonOutputFile = "src/resultFiles/pythonResult.txt";
		String shellScriptOutputFile = "src/resultFiles/shellScriptResult.txt";
		
		String pythonOutput = pythonRun.pythonExecutor(pythonOutputFile);
		String shellScriptOutput = shellScriptRun.shellScriptExecutor(shellScriptOutputFile);
		
		FileWriter fileWriter = new FileWriter(resultFile);
		fileWriter.write(pythonOutput + "\n====================================================\n" + shellScriptOutput);
		fileWriter.close();
	}
	
	public static void main(String args[]) throws IOException, InterruptedException {
		outputGenerator("src/resultFiles/result.txt");
	}
}
