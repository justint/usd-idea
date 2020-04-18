//package com.justint.usdidea.util;
//
//import com.intellij.ide.DataManager;
//import com.intellij.openapi.actionSystem.DataConstants;
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.projectRoots.Sdk;
//import com.intellij.openapi.projectRoots.SdkTypeId;
//import com.intellij.openapi.roots.ProjectRootManager;
//import com.jetbrains.python.sdk.PythonSdkType;
//import org.jetbrains.annotations.Nullable;
//import org.python.core.*;
//import org.python.util.PythonInterpreter;
//
//public class IdeaPythonInterpreter extends PythonInterpreter {
//
//    private Sdk currentProjectInterpreter;
//
//    public IdeaPythonInterpreter() {
//        super();
//        initialize();
//    }
//    public IdeaPythonInterpreter(PyObject dict) {
//        super(dict);
//        initialize();
//    }
//    public IdeaPythonInterpreter(PyObject dict, PySystemState systemState) {
//        super(dict, systemState);
//        initialize();
//    }
//
//    private void initialize() {
//        currentProjectInterpreter = initializeCurrentProjectInterpreter();
//
//        String tempPath = "C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;C:\\Windows\\System32\\OpenSSH\\;C:\\Program Files\\NVIDIA Corporation\\NVIDIA NvDLISR;C:\\Program Files (x86)\\NVIDIA Corporation\\PhysX\\Common;C:\\Program Files\\Git\\cmd;C:\\Python27amd64\\;C:\\Python27amd64\\Scripts;C:\\Users\\Justin\\AppData\\Local\\Programs\\Python\\Python38\\Scripts\\;C:\\Users\\Justin\\AppData\\Local\\Programs\\Python\\Python38\\;C:\\Users\\Justin\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Program Files\\JetBrains\\PyCharm Community Edition 2019.3.3\\bin;;C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2019.3.3\\bin;;C:\\Program Files (x86)\\FAHClient;C:\\Users\\Justin\\USD\\bin;C:\\Users\\Justin\\USD\\lib;";
//        String[] tempPathArray = tempPath.split(";");
//
//        String[] python2path = {"C:\\Windows\\SYSTEM32\\python27.zip",
//                "C:\\Python27amd64\\DLLs",
//                "C:\\Python27amd64\\lib", "C:\\Python27amd64\\lib\\plat-win",
//                "C:\\Python27amd64\\lib\\lib-tk", "C:\\Python27amd64",
//                "C:\\Python27amd64\\lib\\site-packages"};
//
//        // Append current PYTHONPATH
//        String pythonPath = System.getenv("PYTHONPATH");
//        if (pythonPath != null) {
//            String[] pythonPathArray =  pythonPath.split(";");
//            this.exec("from sys import path");
//            PyList sysPath = (PyList)this.get("path");
//            for (String path : pythonPathArray) {
//                sysPath.append(new PyString(path));
//            }
//            for (String tPath : tempPathArray) {
//                sysPath.append(new PyString(tPath));
//            }
//            for (String path2 : python2path) {
//                sysPath.append(new PyString(path2));
//            }
//
//        }
//    }
//
//    @Nullable
//    private Sdk initializeCurrentProjectInterpreter() {
//        // Initialize current project interpreter
//        Project currentProject = (Project) DataManager.getInstance().getDataContext().getData(DataConstants.PROJECT);
//        if (currentProject != null) {
//            Sdk projectSdk = ProjectRootManager.getInstance(currentProject).getProjectSdk();
//            if (projectSdk != null) {
//                SdkTypeId sdkType = projectSdk.getSdkType();
//                if ((sdkType instanceof PythonSdkType)) {
//                    return projectSdk;
//                } else {
//                    // The SDK isn't python???
//                    // Maybe find Python somewhere else
//                    return null;
//                }
//            } else {
//                // We have no SDK???
//                return null;
//            }
//        } else {
//            // We have no project???
//            return null;
//        }
//    }
//
//    public Sdk getCurrentProjectInterpreter() {
//        return currentProjectInterpreter;
//    }
//
//    public String getCurrentProjectInterpreterPath() {
//        return currentProjectInterpreter.getHomePath();
//    }
//}
