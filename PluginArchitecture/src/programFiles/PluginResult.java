package programFiles;

import java.io.FileWriter;
import java.io.IOException;

public class PluginResult {

	public static void outputGenerator(String resultFile) throws IOException, InterruptedException {
		PluginExecutor pythonRun = new PluginExecutor();
		PluginExecutor shellScriptRun = new PluginExecutor();

		String pythonOutputFile = "C:\\SNRG\\PluginArchitecture\\PluginArchitecture\\src\\resultFiles\\pythonResult.txt";
		String shellScriptOutputFile = "C:\\SNRG\\PluginArchitecture\\PluginArchitecture\\src\\resultFiles\\shellScriptResult.txt";

		String pythonOutput = pythonRun.pythonExecutor(pythonOutputFile);
		String shellScriptOutput = shellScriptRun.shellScriptExecutor(shellScriptOutputFile);

		FileWriter fileWriter = new FileWriter(resultFile);
		fileWriter.write(pythonOutput + "\n====================================================\n" + shellScriptOutput);
		fileWriter.close();
	}

	public static void main(String args[]) throws IOException, InterruptedException {
		outputGenerator("C:\\SNRG\\PluginArchitecture\\PluginArchitecture\\src\\resultFiles\\result.txt");
	}
}
