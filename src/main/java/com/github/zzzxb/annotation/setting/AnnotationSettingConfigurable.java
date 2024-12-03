package com.github.zzzxb.annotation.setting;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

/**
 * @author zzzxb
 * 2024/12/3
 */
public class AnnotationSettingConfigurable implements Configurable {
    private AnnotationSettingComponent component;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Annotation Setting";
    }

    @Override
    public @Nullable JComponent createComponent() {
        component = new AnnotationSettingComponent();
        return component.getPanel();
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return Configurable.super.getPreferredFocusedComponent();
    }

    @Override
    public boolean isModified() {
        AnnotationSetting.State state =
                Objects.requireNonNull(AnnotationSetting.getInstance().getState());
        return !component.getUserInput().equals(state.symbol);
    }

    @Override
    public void apply() throws ConfigurationException {
        AnnotationSetting.State state =
                Objects.requireNonNull(AnnotationSetting.getInstance().getState());
        state.symbol = component.getUserInput();
    }

    @Override
    public void reset() {
        AnnotationSetting.State state =
                Objects.requireNonNull(AnnotationSetting.getInstance().getState());
        component.setUserInput(state.symbol);
    }

    @Override
    public void disposeUIResources() {
        component = null;
    }
}
