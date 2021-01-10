package com.justint.usdidea.util.binscripts;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.justint.usdidea.settings.USDSettingsState;
import org.bouncycastle.util.Arrays;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class USDResolve extends USDBinScript {

    public static final String BINSCRIPT_NAME = "usdresolve";

    private String referencePath;
    private String contextPath;
    private final Project project;

    /**
     * A wrapper around the usdresolve bin script.
     *
     * @param referencePath the layer path to resolve (usually wrapped by the @ symbol)
     * @param contextPath the working directory to execute usdresolve from (usually the reference path's source file directory)
     */
    public USDResolve(String referencePath, String contextPath, Project project) {
        this.referencePath = referencePath;
        this.contextPath = contextPath;
        this.project = project;
    }

    @Override
    public String getBinScriptName() {
        return BINSCRIPT_NAME;
    }

    @Override
    public Path getBinScriptPath() {
        return Paths.get(USDSettingsState.getInstance().usdresolveInstallPath);
    }

    /**
     * Returns a resolved path to a USD layer file from the provided reference path.
     *
     * @return the resolved USD layer file path
     * @throws ExecutionException
     */
    public String resolvePath() throws ExecutionException, InterruptedException {
        if (!isUSDInstallValid()) {
            throw new ExecutionException("Invalid USD install path");
        }
        String[] usdresolveCmdArray = Arrays.append(getPythonBinScriptCmds(project), referencePath);
        GeneralCommandLine cmd = new GeneralCommandLine(usdresolveCmdArray);
        cmd.setWorkDirectory(contextPath);
        Process process = cmd.createProcess();
        process.waitFor();
        if (process.exitValue() != 0){
            throw new ExecutionException(String.valueOf(process.exitValue()));
        }
        InputStream inputStream = process.getInputStream();
        try {
            return new String(inputStream.readAllBytes(), StandardCharsets.US_ASCII).trim();
        } catch (IOException e) {
            // Hopefully usdresolve will always give us clean output...
            throw new ExecutionException(String.valueOf(process.exitValue()));
        }
    }

    public String getReferencePath() {
        return referencePath;
    }

    public void setReferencePath(String referencePath) {
        this.referencePath = referencePath;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
