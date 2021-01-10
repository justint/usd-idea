package com.justint.usdidea.settings;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.DialogPanel;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import com.intellij.util.ui.UI;
import com.justint.usdidea.util.USDInstallFinder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class USDSettingsComponent {
    private final JPanel mainPanel;
    private final TextFieldWithBrowseButton usdresolvePathText;

    private final USDInstallFinder installFinder;

    public USDSettingsComponent() {
        installFinder = new USDInstallFinder();

        usdresolvePathText = new TextFieldWithBrowseButton();
        usdresolvePathText.addBrowseFolderListener(new TextBrowseFolderListener(
                new FileChooserDescriptor(
                        true,
                        false,
                        false,
                        false,
                        false,
                        false
                )
        ));
        usdresolvePathText.setToolTipText("<html>Path to <code>usdresolve</code> script. Usually resides in USD install bin directory.</html>");

        DialogPanel buttonPanel = new DialogPanel(new FlowLayout(FlowLayout.LEFT));

        JButton usdToolsFindButton = new JButton("Autodetect Tool Paths");

        JPanel buttonHelpTextPanel = UI.PanelFactory.panel(usdToolsFindButton)
                .withComment("Searches for USD tool paths in PATH environment variable").resizeY(true).createPanel();

        JBLabel usdToolsFindButtonErrorLabel = new JBLabel();
        usdToolsFindButtonErrorLabel.setText("<html>Failed to detect <code>usdresolve</code> path automatically.</html>");
        usdToolsFindButtonErrorLabel.setForeground(getErrorForeground());
        usdToolsFindButtonErrorLabel.setVisible(false);

        usdToolsFindButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String usdresolveInstallPath = installFinder.findUsdresolveInstallPath();
                if (usdresolveInstallPath.equals("")) {
                    usdToolsFindButtonErrorLabel.setVisible(true);
                }
                else {
                    usdresolvePathText.setText(usdresolveInstallPath);
                    usdToolsFindButtonErrorLabel.setVisible(false);
                }
            }
        });
        usdToolsFindButton.setMaximumSize(usdToolsFindButton.getPreferredSize());

        buttonPanel.add(usdToolsFindButton);
        buttonPanel.add(buttonHelpTextPanel);


        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("<html><code>usdresolve</code> path:</html>"), usdresolvePathText)
                .addComponent(buttonPanel)
                .addComponent(usdToolsFindButtonErrorLabel)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    private Color getErrorForeground() {
        // Stolen from com.intellij.util.ui.UIUtil, for backwards compatibility
        return JBColor.namedColor("Label.errorForeground", new JBColor(new Color(0xC7222D), JBColor.RED));
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return usdresolvePathText;
    }

    @NotNull
    public String getUsdresolvePathText() {
        return usdresolvePathText.getText();
    }

    public void setUsdresolvePathText(@NotNull String newText) {
        usdresolvePathText.setText(newText);
    }

}
