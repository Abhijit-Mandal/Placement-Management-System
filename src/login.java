import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class login extends JFrame implements ActionListener
{
    private JButton btn;

    public login()
    {
        super("Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("Open the other JFrame!");
        btn.addActionListener(this);
        btn.setActionCommand("Open");
        add(btn);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if(cmd.equals("Open"))
        {
            dispose();
            new AnotherJFrame();
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run()
            {
                new login().setVisible(true);
            }

        });
    }
}
 @SuppressWarnings("serial")
class AnotherJFrame extends JFrame
{
    public AnotherJFrame()
    {
        super("Another GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Empty JFrame"));
        pack();
        setVisible(true);
    }
}