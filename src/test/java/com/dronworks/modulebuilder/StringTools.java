package com.dronworks.modulebuilder;

import java.util.HashSet;
import java.util.Set;

public class StringTools {
	
	public static Set<Character> stringToCharacterSet(String s) {
	    Set<Character> set = new HashSet<>();
	    for (char c : s.toCharArray()) {
	        set.add(c);
	    }
	    return set;
	}

	public static boolean containsAllChars(String container, String containee) {
	    return stringToCharacterSet(container).containsAll
	               (stringToCharacterSet(containee));
	}
	
}
