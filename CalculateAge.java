package Birthday;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.*;


 class CalculateAge extends JFrame implements ActionListener, ItemListener  
{
CalculateAge(){
    int daysAlive = 0;
    int bmi = 0;
    int byi = 0;
    int bdi = 0;
    TextField dayTF;
    TextField yearTF;
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"};
    JFrame myFrame = Display1();}
   
    TextField getDayF()
    {return dayTF;}
 
 public JFrame Display1()
  {
        JFrame TopFrame = new JFrame();
        TopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TopFrame.setLayout(new FlowLayout());
        TopFrame.setSize(300,300);
        JPanel jp1 = new JPanel();
        TopFrame.add(jp1);
        
        // create month choice
        Choice choice = new Choice();
        for (String month : months){choice.add(month);}
        jp1.add(choice);
        
        // create day label & textfield
        JLabel labelDay = new JLabel("Enter birthday format of DD");
        TopFrame.add(labelDay);
        TextField dayTF = new TextField(10);
        dayTF.setEditable(true);
        dayTF.addActionListener(this);
        TopFrame.add(dayTF);
        
        // create year label & textfield
        JLabel labelYear = new JLabel("Enter birth year as YYYY");
        TopFrame.add(labelYear);
        TextField yearTF = new TextField(10);
        yearTF.setEditable(true);
        yearTF.addActionListener(this);
        TopFrame.add(yearTF);
        choice.addItemListener(this);
        JButton calculate = new JButton("Calculate Age");
        calculate.addActionListener(this);
        TopFrame.add(calculate);
        TopFrame.setVisible(true);
        return TopFrame;
  }
    

       @Override
          public void itemStateChanged(ItemEvent e) 
        {
            String bM = (String)e.getItem();
            for(int i = 0;i<months.length;i++)
            {
                if(bM == months[i])
                { bmi = i+1;}
            }
        }
 
   @Override
        public void actionPerformed(ActionEvent myEvent) 
        {
            this.byi = Integer.parseInt(yearTF.getText());
            LocalDate local =  LocalDate.now();
            LocalDate start = LocalDate.of(this.byi, this.bmi, Integer.parseInt(dayTF.getText()));
            LocalDate end = LocalDate.of(local.getYear(), local.getMonthValue(), local.getDayOfMonth());
            long daysBetween = ChronoUnit.DAYS.between(start,end);
            this.daysAlive = (int) daysBetween;     
          }
 
    JFrame SecondDisplay()
    {
      JFrame updatedFrame = new JFrame("Display Age");
      updatedFrame.setLayout(new FlowLayout());
      updatedFrame.setSize(300,300);
      TextField displayAgeTF = new TextField("The amount of days you have been alive is : " + Integer.toString(daysAlive));
    updatedFrame.add(displayAgeTF);
    myFrame.dispose();
    updatedFrame.setVisible(true);
    return updatedFrame;
    }
}
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(CalculateAge::new);
  new CalculateAge();
    }
}

