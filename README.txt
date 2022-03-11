My assumptions for the project:

1 - Input is a json file of format - String: List<String>
2 - In case of loop, upper element will be printed after its dependencies, his loop wont be printed. 
(A -> B -> A: output - B A)
3 - Also in case of loops, it is not defined properly. 
For example A->B->C->D->B: my code will print B A C D and I think this is correct because D cant be build before B and A cares only on B.