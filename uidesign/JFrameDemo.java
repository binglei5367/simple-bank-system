package uidesign;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JPanel;

import ui.BackgroundPanel;

import javax.swing.JButton;

public class JFrameDemo extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected JFrame parentFrame;
    
   // protected JPanel contentPane;
   // protected JButton btnReturn;
    private JPanel contentPane;
    private JButton btnReturn;

//    protected JPanel contentPane;
//    protected JPanel backgroundPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    JFrameDemo frame = new JFrameDemo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the 
     */
    public JFrameDemo() {
       
        init();
        
    }
    public JFrameDemo(JFrame parentframe) {
        init();
        this.parentFrame = parentframe;
    }
    
    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("framedemo");
        getContentPane().setLayout(null);
        
        contentPane = new JPanel();
        contentPane.setBounds(0, 0, 450, 300);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
    }
    public void setBackgroundImg(JPanel panel) {
        File f = new File("C:\\Users\\chen\\Desktop\\back.jpg");
        BufferedImage  bufimage = new BufferedImage(300, 300,BufferedImage.SCALE_DEFAULT);
        Image image;
        try {
            bufimage = ImageIO.read(f);
           
        } catch (IOException e) {
            Graphics g  = bufimage.getGraphics();
            g.setColor(new Color(0,0,0,0));
        }finally {
            image = bufimage.getScaledInstance(this.contentPane.getWidth(), this.contentPane.getHeight(), Image.SCALE_DEFAULT);
        }
        
        BackgroundPanel backgroundPane = new BackgroundPanel(image,BackgroundPanel.SCALED,1.0f,0.5f);
        backgroundPane.setBounds(0,0,this.contentPane.getWidth(),this.contentPane.getHeight());
        backgroundPane.setSize(this.contentPane.getSize());
        backgroundPane.setPreferredSize(contentPane.getPreferredSize());
        contentPane.add(backgroundPane);
//        JPanel backgroundPane = new JPanel();
//        backgroundPane.setBounds(0, 0, 432, 253);
//        backgroundPane.setSize(panel.getSize());
        panel.add(backgroundPane);
        
//        JLabel lblNewLabel = new JLabel();
//        
//        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\chen\\Desktop\\back.jpg"));
//        lblNewLabel.setSize(backgroundPane.getSize());
//        backgroundPane.add(lblNewLabel);
    }

    
    class JButtonReturnListener extends MouseAdapter{

        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            parentFrame.setVisible(true);
            dispose();
        }
        
    }
}
