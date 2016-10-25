package com.glivas.passGen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class codegen {
    private JButton generateACodeButton;

    public void setGeneratedpassword(JLabel generatedpassword) {
        this.generatedpassword = generatedpassword;
    }

    private JLabel generatedpassword;

    public codegen() {
        generateACodeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new PassGen(4, 4, 4, 4).getPassword();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
