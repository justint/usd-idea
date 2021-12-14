package com.justint.usdidea.util.binscripts;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.justint.usdidea.settings.USDSettingsState;
import com.justint.usdidea.util.USDFormat;
import org.bouncycastle.util.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class USDCat extends USDBinScript {

    public static final String BINSCRIPT_NAME = "usdcat";

    private String inputPath;
    private String outputPath;
    private USDFormat format;
    private final Project project;

    public USDCat(String inputPath, Project project) {
        this.inputPath = inputPath;
        this.project = project;
    }

    public USDCat(String inputPath, String outputPath, USDFormat format, Project project) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.format = format;
        this.project = project;
    }

    @Override
    public String getBinScriptName() {
        return BINSCRIPT_NAME;
    }

    @Override
    public Path getBinScriptPath() {
        return Paths.get(USDSettingsState.getInstance().usdcatInstallPath);
    }

    public String readFileContents() throws ExecutionException, InterruptedException {
        if (!USDSettingsState.getInstance().isUsdcatPathValid()) {
            throw new ExecutionException("Invalid USD install path");
        }
        String[] usdcatCmdArray = Arrays.append(getPythonBinScriptCmds(project), inputPath);
        GeneralCommandLine cmd = new GeneralCommandLine(usdcatCmdArray);
        Process process = cmd.createProcess();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        ArrayList<String> lines = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new ExecutionException(String.valueOf(process.exitValue()));
        }

        process.waitFor();
        if (process.exitValue() != 0){
            throw new ExecutionException(String.valueOf(process.exitValue()));
        }

        return String.join("\n", lines);

//        try {
//            return new String(inputStream.readAllBytes(), StandardCharsets.US_ASCII).trim();
//        } catch (IOException e) {
//            throw new ExecutionException(String.valueOf(process.exitValue()));
//        }
    }
}
