package com.justint.usdidea.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

@State(
        name = "com.justint.usdidea.settings.USDSettingsState",
        storages = {@Storage("USD.xml")}
)
public class USDSettingsState implements PersistentStateComponent<USDSettingsState> {

    public String usdresolveInstallPath = "";
    public String usdcatInstallPath = "";

    public static USDSettingsState getInstance() {
        return ServiceManager.getService(USDSettingsState.class);
    }

    @Nullable
    @Override
    public USDSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull USDSettingsState usdSettingsState) {
        XmlSerializerUtil.copyBean(usdSettingsState, this);
    }

    public boolean isUsdresolvePathValid() {
        if (usdresolveInstallPath.equals("")) return false;

        File usdresolveFile = new File(usdresolveInstallPath);
        return (usdresolveFile.exists() && usdresolveFile.isFile() && usdresolveFile.canExecute());
    }

    public boolean isUsdcatPathValid() {
        if (usdcatInstallPath.equals("")) return false;

        File usdcatFile = new File(usdcatInstallPath);
        return (usdcatFile.exists() && usdcatFile.isFile() && usdcatFile.canExecute());
    }

    public boolean isUSDToolPathsValid(){
        return isUsdresolvePathValid() && isUsdcatPathValid();
    }
}
