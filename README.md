# RailwayStations

The program reads a CSV file of locations and distances. It then prompts the user to input a starting location and a destination. Using an implementation of Djikstra's Algorithm, the shortest path's distance from the starting location to the destination is returned.<br />
<br />
Sample input file:<br />
A,B,4<br />
A,C,3<br />
A,E,7<br />
B,D,5<br />
B,C,6<br />
C,D,11<br />
C,E,8<br />
D,G,10<br />
D,E,5<br />
D,F,2<br />
E,G,5<br />
G,F,3<br />
<br /><br />
Sample input:<br />
Enter your current station:<br />
\>A<br />
Enter your destination station:<br />
\>F<br />
<br />
Sample output:<br />
The shortest route from A to F is 11KM.

