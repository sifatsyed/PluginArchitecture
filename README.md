# Plugin Architecture
This plugin architecture is used to run python/tcsh code using java processes and process builder class and is used to generate an output. 
#### PluginDirectory 
This class is used to display all the files present in a particular path, given the absolute file path for that directory. 
#### PluginExecutor
This is the backbone of the program as it is responsible for executing the python and shell scripts and then generating an output. The methods present in this executor return a string consisting of the formatted output. One more functionality was added during `phase 2`. The output is now written to the designated files, `pythonResult.txt` and `shellScriptResult.txt`.
#### PluginResult
This is the `main` function. It is used to call the methods present in other classes. It does not have any special functionality.
## Phase 1
The initial step was to get a hold of the ProcessBuilder class. `Cygwin` and `python` (expicitly tcsh.exe and python.exe) were installed in my machine to run shell and python scripts. Right now the functionality is at the basic level of coding for python. 
Description of classes:

## Phase 2
Three separate classes were created for listing, execution and generating result. Also, the output was stored in separate files during execution and combined in the end in `result.txt`. 

## Phase 3
New elements were added to `PluginResult` class. These elements are a result, of type `String`, a timeTaken variable of type `String`, it is supposed to be changed to either DateTime or other variable type which fits. There is one more variable named fileType of type `String` and it determines which kind of file was executed. Earlier, the file executor was returning a `String`, but now it returns a `PluginResult`.

## Phase 4
In PluginExecutor, earlier the program had two different executors for python and shell script, but in this phase both of them were merged together. The new method is called `run`. An if else condition, and a type determinator was added to the method to add the correct executor. Right now, the executor is designed to be used locally. 


 