package com.justint.usdidea.util;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import org.apache.commons.lang.SystemUtils;
import org.jetbrains.annotations.NotNull;

import java.io.*;


public class USDInstallFinder {
    public String findUsdresolveInstallPath() {
        return findInstallPath("usdresolve");
    }

    @NotNull
    private String findInstallPath(String binscript) {
        GeneralCommandLine cmd;

        if (SystemUtils.IS_OS_WINDOWS || SystemUtils.IS_OS_MAC) {
            cmd = new GeneralCommandLine("where", binscript);
        }
        else {
            cmd = new GeneralCommandLine("which", binscript);
        }

        final Process process;
        try {
            process = cmd.createProcess();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String output = in.readLine();

                // Ignore any invalid/empty output
                if (!output.contains(File.separator)) {
                    return "";
                }
                else {
                    return output.trim();
                }
            }
        } catch (ExecutionException | IOException e) {
            return "";
        }
    }
}
