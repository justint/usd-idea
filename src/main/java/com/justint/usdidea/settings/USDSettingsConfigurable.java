package com.justint.usdidea.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class USDSettingsConfigurable implements Configurable {

    private USDSettingsComponent usdSettingsComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "USD";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        usdSettingsComponent = new USDSettingsComponent();
        return usdSettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        USDSettingsState settings = USDSettingsState.getInstance();
        return !usdSettingsComponent.getUsdresolvePathText().equals(settings.usdresolveInstallPath);
    }

    @Override
    public void apply() {
        USDSettingsState settings = USDSettingsState.getInstance();
        settings.usdresolveInstallPath = usdSettingsComponent.getUsdresolvePathText();
    }

    @Override
    public void reset() {
        USDSettingsState settings = USDSettingsState.getInstance();
        usdSettingsComponent.setUsdresolvePathText(settings.usdresolveInstallPath);
    }

    @Override
    public void disposeUIResources() {
        usdSettingsComponent = null;
    }
}
