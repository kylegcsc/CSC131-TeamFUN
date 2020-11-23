# CSC131 Team FUN github repo
Make sure you don't commit any documents here, use collaborative office 365 for that. 
The reason being, if 2 people are working on the document at the same time, git will be unable to handle merges of the two peoples' changes because docx is not a plain text file like code is.

Also you need to add JUnit5 to the build path for the unit tests

### Setting up TeamProject eclipse project
After you clone the repo, in eclipse File > Import Projects from File System
You need to install the JavaFX SDK for your platform 
https://gluonhq.com/products/javafx/

And then add the jars to the project's classpath
https://openjfx.io/openjfx-docs/#IDE-eclipse

Then you need to add these VM arguments to the run configuration
Right click the project in eclipse, Run > Run Configurations > Arguments and add to VM arguments if on Windows:

--module-path "\path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml

...replacing the path with wherever you put the JavaFX SDK

If on Linux/Mac:

--module-path /path/to/javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml


I added the .classpath to the .gitignore because the SDK each person uses will be different because we may be on different platforms, so we can't just distribute the JavaFX SDK with the repository.