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
 