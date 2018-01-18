
package de.programmierenlernenhq.panzerhq;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.Action;




public class GameWindow extends JFrame{
    
    private final GamePanel panzerGamePanel;
    
    public GameWindow(){
        
        this.panzerGamePanel = new GamePanel();
                
        registerWindowListener();
        createMenu();
        
        add(panzerGamePanel);
        pack();
        
        setTitle("Panzer HQ");
        setLocation(10,10);
        setResizable(false);
        
        setVisible(true);
            
    }
    
    private void createMenu(){
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefMenu = new JMenu("Preferences");
        
        menubar.add(fileMenu);
        menubar.add(gameMenu);
        menubar.add(prefMenu);
        
        addFileMenuItems(fileMenu);
        addGameMenuItems(gameMenu);
        addPrefMenuItems(prefMenu);
    }
    
    private void addFileMenuItems(JMenu fileMenu){
        
        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               System.exit(0);
           } 
        });
                    
    }
    
    private void addGameMenuItems(JMenu gameMenu){
        JMenuItem pauseItem = new JMenuItem("Pause");
        gameMenu.add(pauseItem);
        pauseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.pauseGame();
            }
        });
        
        JMenuItem fortsetzenItem = new JMenuItem("Fortsetzen");
        gameMenu.add(fortsetzenItem);
        fortsetzenItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.continueGame();
            }
        });
        
        gameMenu.addSeparator();
        JMenuItem restartItem = new JMenuItem("Neustarten");
        gameMenu.add(restartItem);
        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.restartGame();
            }
        });
    }
    
    private void addPrefMenuItems(JMenu prefMenu){
        JMenuItem submenu = new JMenu("Anderer Hintergrund");
        prefMenu.add(submenu);
        
        JMenuItem menuItem = new JMenuItem("Mud Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(0);
                repaint();
            }
        });
        
        menuItem = new JMenuItem("Snow Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(1);
                repaint();
            }
        });
        
        menuItem = new JMenuItem("Desert Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(2);
                repaint();
            }
        });
        
    }
    
    private void registerWindowListener(){
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               System.exit(0);
           } 
           
           public void windowDeactivated(WindowEvent e){
               panzerGamePanel.pauseGame();
           }
           
           public void windowActivated(WindowEvent e){
               panzerGamePanel.continueGame();
           }
        });
    }
    
    
    
    

}
