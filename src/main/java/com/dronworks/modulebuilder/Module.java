package com.dronworks.modulebuilder;

public class Module implements Comparable<Module> {

	private String name;

	public Module(String name) {
		this.name = name;
	}

	public void build() {
		if(SharedData.visited.get(name)) {
			return;
		} 
		if(SharedData.built.get(name)) {
			return;
		}
		SharedData.visited.put(name, true);
		SharedData.subTree.get(name).forEach(Module::build);
		System.out.print(name + " ");
		SharedData.built.put(name, true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Module anotherCountry) {
		return this.name.compareTo(anotherCountry.getName());
	}


}
