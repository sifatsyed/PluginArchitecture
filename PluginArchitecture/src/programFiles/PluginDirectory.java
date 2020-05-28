package programFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PluginDirectory {
	
	public PluginDirectory() {}
	
	/**
	 * Can probably change this to return a string of the fileNames. This might work
	 * or turn out to work in a better way
	 * @param filePath
	 * @return
	 */
	public static List<String> getFilesList(String filePath) {
		File file = new File(filePath);
		String[] fileList = file.list();
		List<String> fileNameList = new ArrayList<String>();
		for(String fileName : fileList) {
			fileNameList.add(fileName);
		}
		return fileNameList;
	}	
}
	/**
	 * The rest call code from the ResearcherServices back-end
	 */
		/*
		 * 
		 *
		package com.odin.controller;
		
		import java.io.File;
		import java.util.ArrayList;
		import java.util.List;
		
		import javax.ws.rs.GET;
		import javax.ws.rs.Path;
		import javax.ws.rs.QueryParam;
		
		import org.springframework.stereotype.Component;
		
		import com.odin.researcher.utils.SwaggerDocQueryConstants;
		import com.wordnik.swagger.annotations.Api;
		import com.wordnik.swagger.annotations.ApiParam;
		
		
		/**
		 * @author sifat
		 *
		 *
		/**
		 * This class "PluginRest" contains different RestFul WebServices for different
		 * operations related to processing of shell scripts
		 *
		@Component
		@Path("/PluginsProcess")
		@Api(value = "PluginRest", description = "Processing shell scripts for advanced design")
		public class PluginRest {
			
			/*
			 * RestFul End Point URI: http://host:port/ResearcherService/rest/PluginsProcess/getFilesList
			 * Example from postman- http://localhost:8081/ResearcherService/rest/PluginsProcess/getFilesList
			 * ?pluginFilePath=C:\\SNRG\\ODINBEServices\\ResearcherServiceBE\\ResearcherService\\src\\main\\java\\com\\odin\\controller
			 * REQUEST TYPE: GET
			 *
			
			@GET
			@Path("/getFilesList")
			public String getFilesList(
					@ApiParam(value = SwaggerDocQueryConstants.PLUGIN_FILE_PATH, required = true) @QueryParam("pluginFilePath") String pluginFilePath
					) {
				File file = new File(pluginFilePath);
				String[] fileList = file.list();
				List<String> fileNameList = new ArrayList<String>();
				for(String fileName : fileList) {
					fileNameList.add(fileName);
				}
				String returnValue = "";
				
				for(String fileName : fileList) {
					returnValue += fileName + "\n";
				}
				
				System.out.println(returnValue);
				return returnValue;
			}
		
		}
		}
		*/
