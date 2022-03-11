package com.dronworks.modulebuilder;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		JsonFileReader jsonFileReader = new JsonFileReader();
		Map<String, List<String>> readJsonFile = jsonFileReader.readJsonFile(new File("src/main/resources/ABCDB.txt"));
		SharedDataBuilder sharedDataBuilder = new SharedDataBuilder();
		sharedDataBuilder.buildData(readJsonFile);
		SharedData.allModules.forEach(Module::build);
	}
	
}
