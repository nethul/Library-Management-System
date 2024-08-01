launch.json 

{
    // Use IntelliSense to learn about possible attributes.
    // Hover to view descriptions of existing attributes.
    // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
    "version": "0.2.0",
    "configurations": [
        
       
        {
            "type": "java",
            "name": "Current File",
            "request": "launch",
            "mainClass": "${file}"
        },

        {
            "type": "java",
            "name": "LibraryManagementSystemApplication",
            "request": "launch",
            "mainClass": "edu.ijse.library_management_system.LibraryManagementSystemApplication",
            "projectName": "library_management_system",
            "vmArgs": "--module-path \"D:/javafx-sdk-21.0.3/lib\" --add-modules javafx.controls,javafx.fxml",
        },
        
    ]
}
