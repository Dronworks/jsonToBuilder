package com.dronworks.modulebuilder;

import java.util.List;
import java.util.Map;

public class GraphBuilder {
	
	public void buildGraph(Map<String, List<String>> json) {
		Graph graph = new Graph();
		graph.buildGraph(json);
	}

}
