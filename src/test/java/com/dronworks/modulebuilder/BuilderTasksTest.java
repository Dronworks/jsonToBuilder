package com.dronworks.modulebuilder;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BuilderTasksTest {
	
	private JsonFileReader jsonFileReader = new JsonFileReader();
	
	@BeforeEach
	public void cleanData() {
		SharedData.allModules.clear();
		SharedData.built.clear();
		SharedData.visited.clear();
		SharedData.subTree.clear();
	}
	
	@ParameterizedTest
	@MethodSource("generateData")
	public void noConnectionsAllPrinted(List<String> expected, String filename) {
		Map<String, List<String>> readJsonFile = jsonFileReader.readJsonFile(new File(String.format("src/main/resources/%s.txt", filename)));
		SharedDataBuilder sharedDataBuilder = new SharedDataBuilder();
		sharedDataBuilder.buildData(readJsonFile);
		ByteArrayOutputStream baos = getOutput();
		System.out.println(baos.toString().trim());
		assertTrue(expected.contains(baos.toString().trim()));
	}
	
	static Stream<Arguments> generateData() {
	    return Stream.of(
	        Arguments.of(Arrays.asList("E D C G F B A", "D E C B A G F", "G D B E C A F"), "JsonExampleA"),
	        Arguments.of(Arrays.asList("O U X N T M Y Z"), "JsonExampleB"),
	        Arguments.of(Arrays.asList("B D C A", "B A D C", "B D A C"), "ABCDB"),
	        Arguments.of(Arrays.asList("a"), "MapOfLeaf"),
	        Arguments.of(Arrays.asList("A B"), "RootBRoot"),
	        Arguments.of(Arrays.asList("b a"), "RootLeaf"),
	        Arguments.of(Arrays.asList("b"), "RootRoot")

	    );
	}

	private ByteArrayOutputStream getOutput() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		SharedData.allModules.forEach(Module::build);
		System.out.flush();
		System.setOut(old);
		return baos;
	}
	
	

}
