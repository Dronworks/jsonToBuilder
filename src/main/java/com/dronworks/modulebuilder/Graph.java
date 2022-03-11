package com.dronworks.modulebuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Graph {
	
	public static Map<String, Module> graph = new HashMap<>();
	public static Map<String, Boolean> built = new HashMap<>();
	public static Map<String, Boolean> printing = new HashMap<>();
	
	public void buildGraph(Map<String, List<String>> input) {
		for(Map.Entry<String, List<String>> entry : input.entrySet()) {
			Set<Module> modules = new TreeSet<>();
			entry.getValue().forEach(n -> modules.add(new Module(n)));
			Module root = new Module(entry.getKey());
			root.setDependencies(modules);
			graph.put(entry.getKey(), root);
		}
	}

}
