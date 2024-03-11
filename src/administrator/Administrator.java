package administrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import core.Assigner;
import core.Query;
import core.profiler.Profile;

public class Administrator {
    
    Query           userQuery;
    Assigner        assigner;
    EventHandler    eventHandler;
    JFrame          window;

    JTextField clientFirstName, clientLastName, clientAge, clientNationality;

    Map<Integer, Profile> userUniqueIds;

    public static Administrator createAdministrator() {
        Administrator admin = new Administrator();
        admin.initializeUserProfiles();
        admin.createQuery();
        admin.createAssigner();
        admin.createEventHandler();
        admin.initializeJFrame();

        return admin;
    }

    private void initializeUserProfiles() {
        userUniqueIds = new HashMap<Integer, Profile>();
    }
    private void createQuery() {
        userQuery = new Query();
    }
    private void createAssigner() {
        assigner = new Assigner();
    }
    private void createEventHandler() {
        eventHandler = new EventHandler();
    }
    private void initializeJFrame() {
        window = new JFrame("Surveillance");

        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(210, 600);




        clientFirstName = new JTextField();
        clientFirstName.setSize(200, 40);
        clientFirstName.setLocation(0, 80);
        clientFirstName.setText("First Name");
        mainPanel.add(clientFirstName);

        clientLastName = new JTextField();
        clientLastName.setSize(200, 40);
        clientLastName.setLocation(0, 120);
        clientLastName.setText("Last Name");
        mainPanel.add(clientLastName);

        clientAge = new JTextField();
        clientAge.setSize(200, 40);
        clientAge.setLocation(0, 160);
        clientAge.setText("Age");
        mainPanel.add(clientAge);

        clientNationality = new JTextField();
        clientNationality.setSize(200, 40);
        clientNationality.setLocation(0, 200);
        clientNationality.setText("Nationality");
        mainPanel.add(clientNationality);

        JTextPane t = new JTextPane();
        t.setText("asshole");
        t.setLocation(0, 0);
        t.setSize(200, 40);

        JButton b = new JButton("Add client");
        b.setSize(200, 30);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Added client with details: First Name: "
                                                       +clientFirstName.getText()+" - Last Name: " + clientLastName.getText() + " - Age: "
                                                       +clientAge.getText() + " - Nationality: " + clientNationality.getText());

                
                Profile profile = new Profile();
                profile.initializeProfile(clientFirstName.getText(), 
                                          clientLastName.getText(), clientNationality.getText(), 18);

                userUniqueIds.put(profile.uniqueId, profile);
            }

        });
        mainPanel.add(b);

        window.setVisible(true);
        window.getContentPane().add(mainPanel);













        clientFirstName.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                clientFirstName.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (clientFirstName.getText().isEmpty()) clientFirstName.setText("First Name");
            }
            
        });
        clientLastName.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                clientLastName.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (clientLastName.getText().isEmpty()) clientLastName.setText("Last Name");
            }
            
        });
        clientAge.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                clientAge.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (clientAge.getText().isEmpty()) clientAge.setText("Age");
            }
            
        });
        clientNationality.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                clientNationality.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (clientNationality.getText().isEmpty()) clientNationality.setText("Nationality");
            }
            
        });
    }


    public Profile getProfileByUniqueID(int userUniqueId, String administratorPrivateKey) {

        if (administratorPrivateKey != "123456789") return null;
        return userUniqueIds.get(userUniqueId);

    }
    public void run() {
        System.out.println("Hello, World!");
    }
}
