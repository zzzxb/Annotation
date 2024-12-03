package com.github.zzzxb.annotation.setting;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author zzzxb
 * 2024/12/3
 */
@State(
        name = "com.github.zzzxb.annotation.setting.AnnotationSetting",
        storages = @Storage("SdkSettingsPlugin.xml")
)
public class AnnotationSetting
        implements PersistentStateComponent<AnnotationSetting.State> {

    static public class State {
        @NonNls
        public String symbol = "--";
    }

    private State myState = new State();

    static public AnnotationSetting getInstance() {
        return ApplicationManager.getApplication()
                .getService(AnnotationSetting.class);
    }

    @Override
    public State getState() {
        return myState;
    }

    @Override
    public void loadState(@NotNull State state) {
        myState = state;
    }
}
