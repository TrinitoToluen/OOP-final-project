package forms;

import javax.swing.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Map;

public class RecordInfo extends JDialog {

    static final LinkedList<String> fields = new LinkedList<String>(){{
        add("Treatment room");
        add("Patient name");
        add("Patient age");
        add("Patient email");
        add("Patient phone");
        add("Patient address");
        add("Record date");
        add("Record diagnosis");
        add("Record prescription");
        add("Record notes");
    }};

    public RecordInfo(Map<String, String> data){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (String field : fields){
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            JLabel label = new JLabel(field + ": ");
            label.setForeground(Color.BLUE);
            panel.add(label);
            JTextArea textArea = new JTextArea(data.get(field));
            textArea.setEditable(false);
            panel.add(textArea);
            mainPanel.add(panel);
        }

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }
}
