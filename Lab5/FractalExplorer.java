import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

import javax.imageio.ImageIO;
import javax.swing.filechooser.*;
import java.io.IOException;


public class FractalExplorer{
    private JImageDisplay display;
    private int dSize;
    private FractalGenerator fGenerator;
    private Rectangle2D.Double range = new Rectangle2D.Double(0,0,0,0);
    JComboBox box = new JComboBox();
    // Create the Window
    JFrame frame = new JFrame("Fractal Explorer");
            
    public static void main(String[] args){
        FractalExplorer expl = new FractalExplorer(600);
        expl.createAndShowGUI();
        expl.drawFractal();
    }

    /**
     * @param size - The height and width of the window
     */
    public FractalExplorer(int size){
        dSize = size;
        display = new JImageDisplay(dSize, dSize);
        fGenerator = new Mandelbrot();
        fGenerator.getInitialRange(range);
    }

    public void createAndShowGUI(){

        //Add fractal display
        display.addMouseListener(new mouse_listener());
        frame.add(display,BorderLayout.CENTER);

        //Add buttons panel
        JPanel buttonsPanel = new JPanel();
        
        //Add the reset buttons
        JButton buttonR = new JButton("Reset");
        buttonR.addActionListener(new act_listener());
        buttonsPanel.add(buttonR, BorderLayout.CENTER);

        //Add the save button
        JButton buttonS=new JButton("Save");
        buttonS.addActionListener(new act_listener());
        buttonsPanel.add(buttonS, BorderLayout.CENTER);

        frame.add(buttonsPanel, BorderLayout.SOUTH);

        //Add the combobox
        JLabel comboboxLabel = new JLabel("Select the fractal:");
        JPanel comboboxPanel = new JPanel();
        box.addItem(new Mandelbrot());
        box.addItem(new Tricorn());
        box.addItem(new BurningShip());
        box.addActionListener(new act_listener());
        comboboxPanel.add(comboboxLabel, BorderLayout.CENTER);
        comboboxPanel.add(box,BorderLayout.CENTER);
        frame.add(comboboxPanel,BorderLayout.NORTH);   

        // Set the default close action to exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The installation default settings
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void drawFractal(){
        for(int i=0;i<dSize;i++)
        for (int j=0;j<dSize;j++){
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, dSize, i);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, dSize, j);
            // Compute the number of iterations
            int iterations = fGenerator.numIterations(xCoord, yCoord);
            //If the color is not default
            if(iterations!=-1){
                float hue = 0.7f + (float) iterations / 200f;
                int color = Color.HSBtoRGB(hue, 1f, 1f);
                display.drawPixel(i, j, color);
            }
            // If color is default
            else display.drawPixel(i, j, 0);
        }
          // Display the image on the screen
         display.repaint();
    }

    private class act_listener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            if (command.equals("Reset")){
                fGenerator.getInitialRange(range);
                display.clearImage();
                drawFractal();
            }

            if (command.equals("Save")){
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                if(chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION){
                    try{
                        ImageIO.write(display.getImage(), "png", chooser.getSelectedFile());
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog (frame, ex.getMessage(), "Unable to save image", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                else{
                    return;
                }

            }

            if ((JComboBox)e.getSource()==box){
                fGenerator = (FractalGenerator)box.getSelectedItem(); 
                fGenerator.getInitialRange(range);
                display.clearImage();
                drawFractal();
            }
        }
    }

    private class mouse_listener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            // Get mouse's coordinates
            super.mouseClicked(e);
            int mouseX=e.getX();
            int mouseY=e.getY();

            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, dSize, mouseX);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, dSize, mouseY);

            fGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            display.clearImage();
            drawFractal();
        }
    }

}
