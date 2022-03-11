Running code:
- Via Main.java class.
- Via BuilderTasksTest.java unit test class.

Implementation:
- Module.java - holds the build() method as requested.
- SharedData.java - holds the building map. While "visited" is a Loop stop condition. And "built" is a stop condition for not building same Module twice. Example: "A": ["B"], "B": [] - we wont bould B twice.

Comments:

1 - I assume that the input is a json file of format - String: List<String>
2 - If any other format will be presented to me, I will be able to convert it to a format that I support.
3 - Loops are not defined good enough for me.
	- Basically i support them but I dont think they act good.
	  For example: A->B->C->D->B my code will print B A C D and I think this is correct because D cant be build before B and A cares only on B.
	- I think a better approach is to throw some exception when a loop is located in the Json data.
4 - I dont support duplicates in the Json. Example { "a":["b"], "a":["b"]}
5 - I dont support multiple keys with same value. Example { "a": ["b"], "a": ["c"]}
6 - Unit test built on list of possible options, and may fail if an option is not located in them. This DON'T mean the code is incorrect, just that I din't cover a permutation.
