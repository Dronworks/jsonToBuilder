package com.dronworks.modulebuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class JsonFileReader {

	private Gson gson = new Gson();
	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	public Map<String, List<String>> readJsonFile(File jsonFile) {
		String json = "";
		try {
			json = FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cound not read file " + jsonFile.getName());
			throw new RuntimeException(e);
		}
		return readJson(json);
	}
	
	public Map<String, List<String>> readJson(String jsonFormat) {
		return validateAndReturnIfCorrect(jsonFormat); 
	}
	
	private Map<String, List<String>> validateAndReturnIfCorrect(String json) {
		try {
			return gson.fromJson(json, new TypeToken<Map<String, List<String>>>(){}.getType());
		} catch (JsonSyntaxException e) {
			logger.log(Level.SEVERE, "Could not parse json String: " + json);
			throw new RuntimeException(e);
		}
	}


}
