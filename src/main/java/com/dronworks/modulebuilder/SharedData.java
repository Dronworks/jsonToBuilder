package com.dronworks.modulebuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SharedData {
	
	public static Map<String, Boolean> visited = new HashMap<>();
	public static Map<String, Boolean> built = new HashMap<>();
	public static Map<String, Set<Module>> subTree = new HashMap<>();
	public static Set<Module> allModules = new HashSet<>();
	

}
