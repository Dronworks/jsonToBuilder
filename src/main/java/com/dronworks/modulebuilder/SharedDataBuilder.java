package com.dronworks.modulebuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SharedDataBuilder {
	
	public void buildData(Map<String, List<String>> json) {
		for (Map.Entry<String, List<String>> entry : json.entrySet()) {
			String key = entry.getKey();
			SharedData.built.put(key, false);
			SharedData.visited.put(key, false);
			List<String> val = entry.getValue();
			Set<Module> subModules = new TreeSet<>();
			val.forEach(sub -> {
				SharedData.built.put(sub, false);
				SharedData.visited.put(sub, false);
				Module subM = new Module(sub);
				subModules.add(new Module(sub));
				SharedData.allModules.add(subM);
				if(!SharedData.subTree.containsKey(sub)) {
					SharedData.subTree.put(sub, new HashSet<>());
				}
			});
			SharedData.subTree.put(key, subModules);
			SharedData.allModules.add(new Module(key));
		}
	}

}
