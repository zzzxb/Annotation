package com.github.zzzxb.annotation.setting;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author zzzxb
 * 2024/12/3
 */
public class AnnotationSettingComponent {
    private final JPanel jPanel;
    private final JBTextField jbTextField = new JBTextField();

    public AnnotationSettingComponent() {
        jPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("annotation symbol"), jbTextField, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return jPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return jbTextField;
    }

    @NotNull
    public String getUserInput() {
        return jbTextField.getText();
    }

    public void setUserInput(@NotNull String newText) {
        jbTextField.setText(newText);
    }
}
