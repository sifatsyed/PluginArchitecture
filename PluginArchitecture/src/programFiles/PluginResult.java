package programFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PluginResult {
	
	private String outputText;
	private String timeTakenToGenerateOutput; //might need to change this to int? or dateTime?
	private String scriptType;
	
	public PluginResult(String outputText, String timeTakenToGenerateOutput, String scriptType) {
		super();
		this.outputText = outputText;
		this.timeTakenToGenerateOutput = timeTakenToGenerateOutput;
		this.scriptType = scriptType;
	}

	public String getOutputText() {
		return outputText;
	}

	public void setOutputText(String outputText) {
		this.outputText = outputText;
	}

	public String getTimeTakenToGenerateOutput() {
		return timeTakenToGenerateOutput;
	}

	public void setTimeTakenToGenerateOutput(String timeTakenToGenerateOutput) {
		this.timeTakenToGenerateOutput = timeTakenToGenerateOutput;
	}

	public String getScriptType() {
		return scriptType;
	}

	public void setScriptType(String scriptType) {
		this.scriptType = scriptType;
	}

	@Override
	public String toString() {
		return "PluginResult \n[outputText = \n" + outputText + "timeTakenToGenerateOutput = " + timeTakenToGenerateOutput
				+ "\nscriptType = " + scriptType + "]";
	}

	public static void main(String args[]) throws IOException, InterruptedException {
		PluginDirectory pluginDirectory = new PluginDirectory();
		List<String> result = pluginDirectory.getFilesList("C:\\GitHub\\PluginArchitecture\\PluginArchitecture\\src\\files");
		System.out.println(result);
		PluginExecutor plugin = new PluginExecutor();
		PluginResult pluginResult = plugin.run("helloWorld.py", 1);
		System.out.println(pluginResult.toString());
	}
}