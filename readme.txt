SHORT TASK DESCRIPTION
SpringBoot  framework was used for the task.
**********************


The user can upload student data through a REST call.
URI: http://localhost:8080/uploadFile/<filename> (Example of file used to "test" the application: http://localhost:8080/uploadFile/results.csv)
Method : POST
File has to be located within folder ./resources, it should also be a csv file formatted as:
{String:StudentName},{double:StudentMark}
**************************

The user can request to sort this list via the following API:
URI : http://localhost:8080/students/sort?sortingAlgorithm=<sortingAlgorithm>&saveToFile=true
where sortingAlgorithm can assume values : bubblesort,mergesort,heapsort  
saveToFile:boolean can assume values : true,false. 
Examples: 
1) to sort and get result saved on file : http://localhost:8080/students/sort?sortingAlgorithm=bubblesort&saveToFile=true - Method : POST
2) to sort without getting result saved : http://localhost:8080/students/sort?sortingAlgorithm=bubblesort - Method : POST

In the first case the application returns on the screen the sorted list and saves on file ./output-files/result.txt
In the second case the application returns on the screen the sorted list.

*******************************
To have a benchmark of performances of algorithm, each time an user is requesting to perform a sorting a report is saved keeping information about duration of the procedure, number of records and algorith utilized.
******************
NOTES:
POSTMAN REST called collection is saved within ./postman collection  folder.
******************
Algorithms have not been implemented.



