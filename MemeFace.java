import jdk.management.cmm.SystemResourcePressureMXBean;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


public class MemeFace extends Thread
{
    static int match =0;
    static int turn = 0;
    static  int ind1;
    static int ind2;
    static int butind1;
    static int butind2;
    static int success= 0;


    public static void main(String args[])
    {
        JFrame mainframe = new JFrame("MemeFace");
        JLabel head =  new JLabel("Meme Face Memory Game");
        //head.setBorder();
        head.setBounds(60,10,650,80);
        head.setFont(new Font("serif",Font.PLAIN,55));
        mainframe.add(head);
        mainframe.setResizable(false);
       // String image_names[] = {"C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\1.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\2.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\3.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\4.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\5.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\6.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\7.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\8.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\9.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\10.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\11.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\18.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\12.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\13.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\14.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\15.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\16.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\17.jpeg",};
        String image_names[] = {"C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\1.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\2.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\5.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\7.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\8.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\12.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\14.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\15.jpeg","C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\17.jpeg",};
        ArrayList<Integer> seq = new ArrayList<Integer>();
        Random rand = new Random();
        while (seq.size() < 36)
        {
            int rand_int = rand.nextInt(9);
            int occ = Collections.frequency(seq,rand_int);
            if(occ < 4)
            {
                seq.add(rand_int);
            }
        }
        System.out.println(seq);
        ArrayList<JButton> buts = new ArrayList<JButton>();
        //int butcount = 0;
        for (int i = 0;i<6;i++)
        {
            for (int j=0;j<6;j++)
            {
                //int ind = seq.get(butcount);
                JButton but = new JButton(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\think.png"));
                buts.add(but);
                but.setBounds(((j*100)+(j*20)+20),((i*100)+(i*20)+100),100,100);
                but.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          if (turn == 0) {
                              int butind = buts.indexOf(but);
                              int ind = seq.get(butind);
                              but.setIcon(new ImageIcon(image_names[ind]));
                              ind1 = ind;
                              butind1 = butind;
                              turn = 1;
                          } else if (turn == 1) {

                              int butind = buts.indexOf(but);
                              int ind = seq.get(butind);
                              but.setIcon(new ImageIcon(image_names[ind]));
                              ind2 = ind;
                              butind2 = butind;
                              turn = 2;
                          }
                      }
                  });
                        but.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (turn ==2)
                                {
                            if (ind1 == ind2) {
                                JButton but1 = buts.get(butind1);
                                but1.setIcon(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\smile2.png"));
                                but1.setEnabled(false);
                                JButton but2 = buts.get(butind2);
                                but2.setIcon(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\smile2.png"));
                                but2.setEnabled(false);
                                turn = 0;
                                success++;
                                if (success == 17 ){
                                    but1.setIcon(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\smile2.png"));
                                    but1.setEnabled(false);
                                    but2.setIcon(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\smile2.png"));
                                    but2.setEnabled(false);
                                }
                            } else {
                                JButton but1 = buts.get(butind1);
                                but1.setIcon(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\think.png"));
                                JButton but2 = buts.get(butind2);
                                but2.setIcon(new ImageIcon("C:\\Users\\Goutam Awadhiya\\IdeaProjects\\MemeFace\\src\\app_pics\\think.png"));
                                turn = 0;
                            }
                        }
                    }
                        });
                mainframe.add(but);
                //butcount++;
            }
        }
      mainframe.setSize(760,900);
      mainframe.setLayout(null);
      mainframe.setVisible(true);
    }
}