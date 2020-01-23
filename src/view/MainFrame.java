package view;

import control.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import model.ImageDisplay;
import persistence.FileImageLoader;

public class MainFrame extends JFrame{
    private ImageDisplay imageDisplay;
    private final Map<String,Command> commands = new HashMap<>();

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState( JFrame.MAXIMIZED_BOTH ); //|JFrame.MAXIMIZED_BOTH
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        addCommands();
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public ImageDisplay getImageDisplay() {
        return this.imageDisplay;
    }

    private Component toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener( 
                e -> {
                    this.commands.get("PrevImage").execute();
                }
        );
        return button;
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(
                e -> {
                    this.commands.get("NextImage").execute();
                }
        );
        return button;
    }

    private void addCommands() {
        this.commands.put("PrevImage", new PreviousImageCommand(this.imageDisplay));
        this.commands.put("NextImage", new NextImageCommand(this.imageDisplay));
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
}
