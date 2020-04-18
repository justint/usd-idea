package com.justint.usdidea.util;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class USDCat {

    private static CharSequence fileContents = null;

    public static CharSequence convertToAscii(VirtualFile file) {

        // Check if file is binary
        byte[] contents = new byte[0];
        try {
            contents = file.contentsToByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String testContents = new String(contents, StandardCharsets.US_ASCII);
        if (!testContents.contains("#usda")) {
            // If binary, decompile to ASCII USD

//                File pluginPath = PluginManager.getPlugin(PluginId.getId("com.justint.usd-idea")).getPath();
//                System.out.println("Plugin path: " + pluginPath.getAbsolutePath());

//                System.setProperty("java.library.path", "C:\\Python27amd64\\Lib\\site-packages\\jep");
//                //set sys_paths to null
//                final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
//                sysPathsField.setAccessible(true);
//                sysPathsField.set(null, null);
//
//                try (Interpreter interpreter = new SharedInterpreter()) {
//                    interpreter.exec("from sys import path");
//                    interpreter.exec("path += ['" + System.getenv("PYTHONPATH") + "']");
//                    interpreter.exec("from pxr import Sdf");
//                    interpreter.exec("usdData = Sdf.Layer.FindOrOpen('" + file.getPath() + "')");
//                    String usdData = (String)interpreter.getValue("usdData.ExportToString()");
//                    fileContents = usdData;
//                }


//                interpreter.exec("from sys import path");
//                PyList path = (PyList)interpreter.get("path");
//                System.out.println(path.toString());
//                interpreter.exec("from pxr.Sdf.Layer import FindOrOpen");
//                PyFunction findOrOpen = (PyFunction)interpreter.get("FindOrOpen");
//                PyObject usdData = findOrOpen.__call__(Py.java2py(file.getPath()));
//                fileContents = usdData.toString();
            String[] commandArray = {"C:\\Users\\Justin\\USD\\bin\\usdcat.cmd", file.getPath()};
            GeneralCommandLine cmd = new GeneralCommandLine(commandArray);

            System.out.println("Command: " + cmd.getCommandLineString());
            final Process process;
            try {
                process = cmd.createProcess();
                InputStream inputStream = process.getInputStream();
                byte[] output = inputStream.readAllBytes();
                fileContents = new String(output, StandardCharsets.US_ASCII).replaceAll("\r\n", "\n");
            } catch (ExecutionException | IOException e) {
                e.printStackTrace();
            }
        } else {
            // If not, return file contents
            try {
                fileContents = new String(file.contentsToByteArray(), file.getCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileContents;
    }
}
