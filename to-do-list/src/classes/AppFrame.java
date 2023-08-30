package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppFrame extends JFrame {
    private TitelBar title;
    private List list;
    private  ButtonPanel btnPanel;

    private JButton addTask;
    private JButton clear;


    //constructor
    AppFrame(){
        this.setSize(400,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitelBar();
        list = new List();
        btnPanel = new ButtonPanel();
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel,BorderLayout.SOUTH);

        this.add(list,BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        clear = btnPanel.getClear();

        addListeners();
    }

    public void addListeners(){
        addTask.addMouseListener(new MouseAdapter(){
            @Override
                    public void mousePressed(MouseEvent e)
            {
                Task task =new Task();
                list.add(task);
                list.updateNumber();

                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e)
                    {
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }
        });
    }

}
