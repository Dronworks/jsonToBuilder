package com.dronworks.modulebuilder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class JsonFileReaderTest {
	
	private JsonFileReader jsonFileReader = new JsonFileReader();

	@Test
	public void badFileLocationThrowsException() {
		assertThrows(RuntimeException.class, () -> jsonFileReader.readJsonFile(new File("not a file")));
	}
	
	@Test
	public void notAJasonFileTrhowsExcepion() {
		assertThrows(RuntimeException.class, () -> jsonFileReader.readJson("not json"));
	}
	
	@Test
	public void notSupportedJsonThrowsException() {
		assertThrows(RuntimeException.class,  () -> jsonFileReader.readJsonFile(new File("src/main/resources/UnsupportedJson.txt")));
	}
	
	@Test
	public void notSupportedDuplicatesThrowsException() {
		assertThrows(RuntimeException.class,  () -> jsonFileReader.readJsonFile(new File("src/main/resources/Duplicates.txt")));
	}
	
	@Test
	public void notSupportedDuplicatesKeysThrowsException() {
		assertThrows(RuntimeException.class,  () -> jsonFileReader.readJsonFile(new File("src/main/resources/DuplicatesKeys.txt")));
	}
	
	@Test
	public void simpleJsonReturnMap() {
		Map<String, List<String>> readJsonFile = jsonFileReader.readJsonFile(new File("src/main/resources/SimpleJson.txt"));
		assertNotNull(readJsonFile.get("a"));
		assertEquals(readJsonFile.get("a").get(0), "b");
	}
	
	@Test
	public void jsonMapOfLeafReturnsMapWithEmpltyList() {
		Map<String, List<String>> readJsonFile = jsonFileReader.readJsonFile(new File("src/main/resources/MapOfLeaf.txt"));
		assertNotNull(readJsonFile.get("a"));
		assertEquals(0, readJsonFile.get("a").size());
	}
	
	@Test
	public void jsonSupporedExampleReturnsAMapOfLists() {
		Map<String, List<String>> readJsonFile = jsonFileReader.readJsonFile(new File("src/main/resources/JsonExampleA.txt"));
		assertNotNull(readJsonFile.get("A"));
		assertEquals(2, readJsonFile.get("A").size());
		assertTrue(readJsonFile.get("B").contains("D"));
	}
	
	@Test
	public void jsonSupportedExample2ReturnsAMapOfLists() {
		Map<String, List<String>> readJsonFile = jsonFileReader.readJsonFile(new File("src/main/resources/JsonExampleB.txt"));
		assertNotNull(readJsonFile.get("Z"));
		assertEquals(3, readJsonFile.get("Z").size());
		assertEquals(0, readJsonFile.get("U").size());
		assertTrue(readJsonFile.get("T").contains("N"));
		assertEquals(6, readJsonFile.keySet().size());
	}

}
