
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.*;

public class DaysOld implements ActionListener {
     JButton button;
    int daysLive;
    JTextField MM;
    JTextField DD;
    JTextField YYYY;
    String userYear;
    String userMonth;
    String userDay;
    JFrame FrameOne;
DaysOld()
{
FrameOne = new JFrame("Frame 1");
JPanel PanelOne = new JPanel();
FrameOne.setLayout(new FlowLayout());
FrameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
FrameOne.setSize(300,300);
JLabel displayDetails = new JLabel("Enter your birthday in the format of MM/DD/YYYY");
PanelOne.add(displayDetails);
FrameOne.add(PanelOne);

JPanel PanelTwo = new JPanel();
MM = new JTextField("MM",2);
PanelTwo.add(MM);
DD = new JTextField("DD",2);
PanelTwo.add(DD);
YYYY = new JTextField("YYYY",4);
PanelTwo.add(YYYY);
FrameOne.add(PanelTwo);

JPanel PanelThree = new JPanel();
//JTextField DaysOld = new JTextField();
//PanelThree.add(DaysOld);
button = new JButton("Get Age");

PanelThree.add(button);
FrameOne.add(PanelThree);
button.addActionListener(this);

userYear = YYYY.getText();
userMonth = MM.getText();
userDay = DD.getText();
System.out.println(userYear + " " + userMonth + " " + userDay);
daysLive = CalcD(userYear, userMonth, userDay);
setDA(daysLive);

FrameOne.setVisible(true);



}
@Override
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==button)
{

FrameTwo(this);
}
}

public int CalcD(String userYear,String userMonth, String userDay)
{

LocalDate local =  LocalDate.now();
LocalDate start = LocalDate.of(Integer.parseInt(userYear),Integer.parseInt(userMonth),Integer.parseInt(userDay));
LocalDate end = LocalDate.of(local.getYear(), local.getMonthValue(), local.getDayOfMonth());
long daysBetween = ChronoUnit.DAYS.between(start,end);
return (int) daysBetween;

}
public void setDA(int d)
{
this.daysLive=d;
System.out.println(this.daysLive);
}
public int getDA()
{
    return this.daysLive;
}
public void FrameTwo(DaysOld frame)
{
   int num = frame.getDA();
   System.out.println(num);
    JFrame FrameTwo = new JFrame("Frame Two");
    FrameTwo.setLayout(new FlowLayout());
    FrameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    FrameTwo.setSize(300,300);
    JLabel DisplayAge = new JLabel("You are "+ num + " days Old!");
    FrameTwo.add(DisplayAge);
    FrameTwo.setVisible(true);
}

public static void main(String[] args) {
    DaysOld d = new DaysOld();

   
}
}
