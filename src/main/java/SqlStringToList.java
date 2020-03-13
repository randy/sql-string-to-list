import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SqlStringToList extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        if (project == null) return;

        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (editor == null) return;

        Document document = editor.getDocument();
        int start = editor.getSelectionModel().getSelectionStart();
        int end = editor.getSelectionModel().getSelectionEnd();
        String selectedText = editor.getSelectionModel().getSelectedText();

        ActionManager actionManager = e.getActionManager();
        String actionId = actionManager.getId(this);
        String replacementText;

        if (actionId.equals("sjq.basic") && selectedText != null) {
            replacementText = splitJoin(selectedText);
        } else if (actionId.equals("sjq.adv") && selectedText != null) {
            replacementText = splitJoinLine(selectedText);
        } else {
            return;
        }

        assert replacementText != null;
        final String text = replacementText;

        Runnable runnable = () -> document.replaceString(start, end, text);

        WriteCommandAction.runWriteCommandAction(project, runnable);
    }

    private String splitJoin(String text) {
        String[] split = StringUtils.split(text, ',');
        StringJoiner joiner = new StringJoiner("\',\'","\'","\'");
        Arrays.stream(split).forEach(joiner::add);
        return joiner.toString();
    }

    private String splitJoinLine(String text) {
        String[] split = StringUtils.split(text, ',');
        StringJoiner joiner = new StringJoiner("\',\n\'","\'","\'");
        Arrays.stream(split).forEach(joiner::add);
        return joiner.toString();
    }
}
