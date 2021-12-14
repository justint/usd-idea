package com.justint.usdidea.util.binscripts;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.util.PlatformUtils;
import com.justint.usdidea.settings.USDSettingsState;
import org.apache.commons.lang.SystemUtils;

import java.nio.file.Path;

public abstract class USDBinScript {

    public abstract String getBinScriptName();

    public abstract Path getBinScriptPath();

    public String[] getPythonBinScriptCmds(Project project) {
        if (SystemUtils.IS_OS_WINDOWS) {
            // For windows, we need to prepend the bin script path with the path to python.exe
            // (ie: treat python.exe as the executable and our USD bin script as its first argument)
            String pythonPath;
            if (PlatformUtils.isPyCharm()) {
                try {
                    // Try to use the current Python SDK path
                    pythonPath = ProjectRootManager.getInstance(project).getProjectSdk().getHomePath();
                } catch (NullPointerException e) {
                    pythonPath = "python";
                }
            }
            else {
                pythonPath = "python";
            }
            return new String[]{pythonPath, getBinScriptPath().toString()};
        }
        return new String[]{getBinScriptPath().toString()};
    }

    public boolean isUSDInstallValid() {
        return USDSettingsState.getInstance().isUSDToolPathsValid();
    }
}
