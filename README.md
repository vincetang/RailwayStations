# RailwayStations

The program reads a CSV file of locations and distances. It then prompts the user to input a starting location and a destination. Using an implementation of Djikstra's Algorithm, the shortest path's distance from the starting location to the destination is returned.

Sample input file:
A,B,4
A,C,3
A,E,7
B,D,5
B,C,6
C,D,11
C,E,8
D,G,10
D,E,5
D,F,2
E,G,5
G,F,3

Sample input:
Enter your current station:
>A
Enter your destination station:
>F

Sample output:
The shortest route from A to F is 11KM.

