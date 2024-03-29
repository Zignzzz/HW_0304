//package components;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.event.*;
import java.awt.*;


/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class ScribbleShops extends JFrame
                               implements ActionListener {
    JDesktopPane desktop;
    static int openFrameCount = 0;

    public ScribbleShops() {
        super("InternalFrameDemo");

        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);

        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane
        createFrame(); //create first "window"
        setContentPane(desktop);
        setJMenuBar(createMenuBar());

        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Set up the lone menu.
        JMenu menu = new JMenu("Document");
        JMenu m = new JMenu("About");
        menu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menu);
        menuBar.add(m);

        //Set up the first menu item.
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Close");
        menuItem.setMnemonic(KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_C, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("close");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Close All");
        menuItem.setMnemonic(KeyEvent.VK_C);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_A, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("close all");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Help");
        //menuItem.setMnemonic(KeyEvent.VK_Q);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(
          //      KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("help");
        menuItem.addActionListener(this);
        m.add(menuItem);
        
        menuItem = new JMenuItem("Author");
        //menuItem.setMnemonic(KeyEvent.VK_Q);
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(
          //      KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("author");
        menuItem.addActionListener(this);
        m.add(menuItem);
        
        //Set up the second menu item.
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menuBar;
    }

    //React to menu selections.
    public void actionPerformed(ActionEvent e) {
        if ("new".equals(e.getActionCommand())) { //new
            createFrame();
        }else if("quit".equals(e.getActionCommand())){ //quit
            quit();
        }else if("close".equals(e.getActionCommand())){
        	JInternalFrame f = desktop.getSelectedFrame();
        	f.setVisible(false);
        }else if("close all".equals(e.getActionCommand())){
        	JInternalFrame []a = desktop.getAllFrames();
        	for(int i=0; i<a.length;i++){
        		a[i].setVisible(false);
        	}
        }else if("help".equals(e.getActionCommand())){
        	JOptionPane.showMessageDialog(new Frame(),
        		    "Please see Aj. Sivabuhd or Aj. Atiwong for further instructions",
        		    "Inane warning",
        		    JOptionPane.WARNING_MESSAGE);
        }else if("author".equals(e.getActionCommand())){
        	showAuthor();
        	
        }
    }

    private void showAuthor() {
		// TODO Auto-generated method stub
		JDialog d = new JDialog(new JFrame(),"Author");
		d.add(new Avatar());
		d.setSize(800,1000);
		
		d.setVisible(true);
		desktop.add(d);
		
	}

	//Create a new internal frame.
    protected void createFrame() {
        MyInternalFrame frame = new MyInternalFrame();
        frame.setVisible(true); //necessary as of 1.3
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    //Quit the application.
    protected void quit() {
        System.exit(0);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        ScribbleShops frame = new ScribbleShops();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public class MyInternalFrame extends JInternalFrame {
        static final int xOffset = 30, yOffset = 30;
     
        public MyInternalFrame() {
            super("Document #" + (++openFrameCount), 
                  true, //resizable
                  true, //closable
                  true, //maximizable
                  true);//iconifiable
     
            //...Create the GUI and put it in the window...
            //Scribble s = new Scribble();
            getContentPane().add(new Scribble().frame.getContentPane());
            System.out.println("scribble called");
            //setContentPane(contentPane);
            //...Then set the window size or call pack...
            setSize(500,500);
     
            //Set the window's location.
            setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        }
    }
}

