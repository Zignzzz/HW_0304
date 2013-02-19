import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
//import java.awt.Canvas;

public class Scribble {
	 JFrame frame;
	
	 public Scribble(){
		 frame = new JFrame();
		    final DrawingPad drawPad = new DrawingPad();
		    frame.add(drawPad, BorderLayout.CENTER);
		    
		    JPanel a = new JPanel(new GridLayout(1,2,0,0));
		    TitledBorder border = new TitledBorder("Settings");
		    a.setBorder(border);
		    JPanel scroll = new JPanel(new GridLayout(3,2,1,1));
		    JPanel button = new JPanel(new BorderLayout());
		   
		    //JPanel colorView = new JPanel();
		    
		    JButton clearButton = new JButton("Clear");
		    
		    JSlider size = new JSlider(JSlider.HORIZONTAL,0,50,2);
		    JSlider r = new JSlider(JSlider.HORIZONTAL, 0, 255, 5);
			JSlider g = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
			JSlider b = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

			r.setMajorTickSpacing(100);
			r.setMinorTickSpacing(50);
			r.setPaintTicks(true);
		    r.setPaintLabels(true);
		    g.setMajorTickSpacing(100);
			g.setMinorTickSpacing(50);
			g.setPaintTicks(true);
		    g.setPaintLabels(true);
		    b.setMajorTickSpacing(100);
			b.setMinorTickSpacing(50);
			b.setPaintTicks(true);
		    b.setPaintLabels(true);
			size.setMajorTickSpacing(10);
			size.setMinorTickSpacing(1);
			size.setPaintTicks(true);
		    size.setPaintLabels(true);
		     
			final JLabel rLabel = new JLabel("R 0");
		    final JLabel gLabel = new JLabel("G 0");
		    final JLabel bLabel = new JLabel("B 0");
		   
		    
			r.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent e) {
			        JSlider source = (JSlider) e.getSource();
			        if (!source.getValueIsAdjusting()) {
			           drawPad.red = (int) source.getValue();
			           rLabel.setText("R "+drawPad.red);
			        }
			      }
			    });
			g.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent e) {
			        JSlider source = (JSlider) e.getSource();
			        if (!source.getValueIsAdjusting()) {
			           drawPad.green = (int) source.getValue();
			           gLabel.setText("G "+drawPad.green);
			        }
			      }
			    });
			b.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent e) {
			        JSlider source = (JSlider) e.getSource();
			        if (!source.getValueIsAdjusting()) {
			           drawPad.blue = (int) source.getValue();
			           bLabel.setText("B = "+drawPad.blue);
			        }
			      }
			    });

			size.addChangeListener(new ChangeListener() {
			      public void stateChanged(ChangeEvent e) {
			        JSlider source = (JSlider) e.getSource();
			        if (!source.getValueIsAdjusting()) {
			           drawPad.sizeBrush = (int) source.getValue();
			        }
			      }
			    });
			
			clearButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        drawPad.clear();
		      }
		    });
		   // checkBG(drawPad.red, drawPad.green, drawPad.blue);
			
			a.setBackground(new Color(drawPad.red,drawPad.green,drawPad.blue));
			button.add(clearButton);
			button.add(size,BorderLayout.NORTH);
		    scroll.add(r);scroll.add(rLabel);
		    scroll.add(g);scroll.add(gLabel);
		    scroll.add(b);scroll.add(bLabel);

			a.add(scroll);
			a.add(button);

			frame.add(a, BorderLayout.NORTH);
			frame.setSize(600, 600);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    //frame.setVisible(true);
	 }
	 
	 
	 public static void main(String[] args) {
		 Scribble s = new Scribble();
	/*frame = new JFrame();
    final DrawingPad drawPad = new DrawingPad();
    frame.add(drawPad, BorderLayout.CENTER);
    
    JPanel a = new JPanel(new GridLayout(1,2,0,0));
    TitledBorder border = new TitledBorder("Settings");
    a.setBorder(border);
    JPanel scroll = new JPanel(new GridLayout(3,2,1,1));
    JPanel button = new JPanel(new BorderLayout());
   
    //JPanel colorView = new JPanel();
    
    JButton clearButton = new JButton("Clear");
    
    JSlider size = new JSlider(JSlider.HORIZONTAL,0,50,2);
    JSlider r = new JSlider(JSlider.HORIZONTAL, 0, 255, 5);
	JSlider g = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider b = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

	r.setMajorTickSpacing(50);
	r.setMinorTickSpacing(10);
	r.setPaintTicks(true);
    r.setPaintLabels(true);
    g.setMajorTickSpacing(50);
	g.setMinorTickSpacing(10);
	g.setPaintTicks(true);
    g.setPaintLabels(true);
    b.setMajorTickSpacing(50);
	b.setMinorTickSpacing(10);
	b.setPaintTicks(true);
    b.setPaintLabels(true);
	size.setMajorTickSpacing(10);
	size.setMinorTickSpacing(1);
	size.setPaintTicks(true);
    size.setPaintLabels(true);
     
	final JLabel rLabel = new JLabel("R 0");
    final JLabel gLabel = new JLabel("G 0");
    final JLabel bLabel = new JLabel("B 0");
   
    
	r.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider) e.getSource();
	        if (!source.getValueIsAdjusting()) {
	           drawPad.red = (int) source.getValue();
	           rLabel.setText("R "+drawPad.red);
	        }
	      }
	    });
	g.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider) e.getSource();
	        if (!source.getValueIsAdjusting()) {
	           drawPad.green = (int) source.getValue();
	           gLabel.setText("G "+drawPad.green);
	        }
	      }
	    });
	b.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider) e.getSource();
	        if (!source.getValueIsAdjusting()) {
	           drawPad.blue = (int) source.getValue();
	           bLabel.setText("B = "+drawPad.blue);
	        }
	      }
	    });

	size.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider) e.getSource();
	        if (!source.getValueIsAdjusting()) {
	           drawPad.sizeBrush = (int) source.getValue();
	        }
	      }
	    });
	
	clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        drawPad.clear();
      }
    });
   // checkBG(drawPad.red, drawPad.green, drawPad.blue);
	
	a.setBackground(new Color(drawPad.red,drawPad.green,drawPad.blue));
	button.add(clearButton);
	button.add(size,BorderLayout.NORTH);
    scroll.add(r);scroll.add(rLabel);
    scroll.add(g);scroll.add(gLabel);
    scroll.add(b);scroll.add(bLabel);

	a.add(scroll);
	a.add(button);

	frame.add(a, BorderLayout.NORTH);
	frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);*/
    
  }
	
  }

  class DrawingPad extends JComponent {
    Image image;
    Graphics2D graphics2D;
    int currentX, currentY, oldX, oldY;
    int red,green,blue,sizeBrush;
    public DrawingPad() {
      setDoubleBuffered(false);
      
      addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          oldX = e.getX();
          oldY = e.getY();
          
        }
      });
      addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
          currentX = e.getX();
          currentY = e.getY();
         graphics2D.setColor(new Color(red,green,blue));
         //a.setBackground(new Color(drawPad.red,drawPad.green,drawPad.blue));
          if (graphics2D != null)
        	  graphics2D.setStroke(new BasicStroke(sizeBrush));
        	  graphics2D.drawLine(oldX, oldY, currentX, currentY);
          repaint();
          oldX = currentX;
          oldY = currentY;
        }
      });
    }
   
	public void paintComponent(Graphics g) {
        if (image == null) {
        //g.fillOval(20, 20, 15, 15);
          image = createImage(getSize().width, getSize().height);
          graphics2D = (Graphics2D) image.getGraphics();
          graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);
          clear();
        }
        g.drawImage(image, 0, 0, null);
      }

      public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
      }
   }
  