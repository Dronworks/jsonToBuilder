package com.dronworks.modulebuilder;

import java.util.Set;
import java.util.TreeSet;

public class Module implements Comparable<Module> {

	private String name;
	private Set<Module> dependencies = new TreeSet<>();

	public Module(String name) {
		this.name = name;
	}

	public void build() {
		if(Graph.printing.containsKey(name)) {
			return;
		}
		Graph.printing.put(name, true);
		if(!Graph.built.containsKey(name) || !Graph.built.get(name)) {
			if(dependencies.isEmpty()) {
				if(Graph.graph.containsKey(name) && !Graph.graph.get(name).dependencies.isEmpty()) {
					Graph.graph.get(name).build();
				}
			}
			dependencies.forEach(Module::build);
			if(!Graph.built.containsKey(name) || !Graph.built.get(name)) {
				System.out.print(name + " ");
				Graph.built.put(name, true);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Module> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<Module> dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public int compareTo(Module anotherCountry) {
		return this.name.compareTo(anotherCountry.getName());
	}


}
