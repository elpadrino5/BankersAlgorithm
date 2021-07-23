# Bankers Algorithm<br>
Program uses bankers algorithm to grant or deny requested resources depending on resources max, allocation, need, and availability.<br>
<br>
## Example 1<br>
Example output after running program in the terminal<br>
<br>
MAX<br>
7 5 3<br>
3 2 2<br>
9 0 2<br>
2 2 2<br>
4 3 3<br>
<br>
ALLOC<br>
0 1 0<br>
2 0 0<br>
3 0 2<br>
2 1 1<br>
0 0 2<br>
<br>
NEED<br>
7 4 3<br>
1 2 2<br>
6 0 0<br>
0 1 1<br>
4 3 1<br>
<br>
AVAILABLE<br>
3 3 2<br>
<br>
What process is making a request?(0 to 4):1<br>
Request for resource A:1<br>
Request for resource B:0<br>
Request for resource C:2<br>
Your request for Process1 is (1,0,2).<br>
<br>
First condition was met!<br>
REQUEST1 (1,0,2) is less than or equal to NEED1 (1,2,2).<br>
Second Condition was met!<br>
REQUEST1 (1,0,2) is less than or equal to what's AVAILABLE (3,3,2).<br>
<br>
The resources AVAILABLE has been changed to (2,3,0).<br>
Process1 ALLOCATION has been changed to (3,0,2).<br>
Process1 NEED has been changed to (0,2,0).<br>
<br>
P0 7 4 3 <= 2 3 0 Finish[0] = false X<br>
P1 0 2 0 <= 2 3 0 Finish[1] = true new Available = 5 3 2<br>
P2 6 0 0 <= 5 3 2 Finish[2] = false X<br>
P3 0 1 1 <= 5 3 2 Finish[3] = true new Available = 7 4 3<br>
P4 4 3 1 <= 7 4 3 Finish[4] = true new Available = 7 4 5<br>
<br>
P0 7 4 3 <= 7 4 5 Finish[0] = true new Available = 7 5 5<br>
P2 6 0 0 <= 7 5 5 Finish[2] = true new Available = 10 5 7<br>
<br>
REQUEST GRANTED!!!<br>
<br>
## Example 2<br>
Example output after running program in the terminal<br>
<br>
MAX<br>
7 5 3<br>
3 2 2<br>
9 0 2<br>
2 2 2<br>
4 3 3<br>
<br>
ALLOC<br>
0 1 0<br>
2 0 0<br>
3 0 2<br>
2 1 1<br>
0 0 2<br>
<br>
NEED<br>
7 4 3<br>
1 2 2<br>
6 0 0<br>
0 1 1<br>
4 3 1<br>

AVAILABLE<br>
3 3 2<br>

What process is making a request?(0 to 4):0<br>
Request for resource A:2<br>
Request for resource B:3<br>
Request for resource C:1<br>
Your request for Process0 is (2,3,1).<br>

First condition was met!<br>
REQUEST0 (2,3,1) is less than or equal to NEED0 (7,4,3).<br>
Second Condition was met!<br>
REQUEST0 (2,3,1) is less than or equal to what's AVAILABLE (3,3,2).<br>
<br>
The resources AVAILABLE has been changed to (1,0,1).<br>
Process0 ALLOCATION has been changed to (2,4,1).<br>
Process0 NEED has been changed to (5,1,2).<br>
<br>
P0 5 1 2 <= 1 0 1 Finish[0] = false X<br>
P1 1 2 2 <= 1 0 1 Finish[1] = false X<br>
P2 6 0 0 <= 1 0 1 Finish[2] = false X<br>
P3 0 1 1 <= 1 0 1 Finish[3] = false X<br>
P4 4 3 1 <= 1 0 1 Finish[4] = false X<br>
<br>
REQUEST DENIED!!!<br>
