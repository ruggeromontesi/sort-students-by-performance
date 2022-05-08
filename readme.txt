SHORT TASK DESCRIPTION
SpringBoot  framework was used for the task.
**************
The user can upload student data through a REST call.
URI: http://localhost:8080/uploadFile/<filename> (Example of file used to "test" the application: http://localhost:8080/uploadFile/results.csv)
Method : POST
File has to be located within folder ./resources, it should also be a csv file formatted as:
{String:StudentName},{double:StudentMark}
**************************

The user can request to sort this list via the following API:
URI : http://localhost:8080/students/sort/<sortingAlgorithm>/<saveToFileString>
where sortingAlgorithm can assume values : bubblesort,mergesort,heapsort  
saveToFileString can assume whatever value, can even be absent, anyway to get file saved it should be equal to saveToFile
Examples: 
1) to sort and get result saved on file : http://localhost:8080/students/sort/bubblesort/saveToFile
2) to sort without getting result saved : http://localhost:8080/students/sort/bubblesort

