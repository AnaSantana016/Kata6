package blockshifter.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import blockshifter.model.Block;
import blockshifter.view.BlockDisplay;
import blockshifter.control.Command;
import blockshifter.control.DownCommand;
import blockshifter.control.LeftCommand;
import blockshifter.control.RightCommand;
import blockshifter.control.UpCommand;
import java.util.Map;
import java.util.HashMap;

public class Main extends JFrame{
    
    public static void main(String[] args){
        new Main().execute();
    }
    private BlockDisplay blockDisplay;
    private Map<String,Command> commands = new HashMap<>();
    
    public Main(){
        this.setTitle("Block shifter");
        this.setSize(700,750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);
        
        Block block = new Block(4,4);
        this.blockDisplay.display(block);
        this.commands.put("left", new LeftCommand(block));
        this.commands.put("right", new RightCommand(block));
        this.commands.put("up", new UpCommand(block));
        this.commands.put("down", new DownCommand(block));
    }
    
    private void execute(){
        this.setVisible(true);
    }
    
    private JPanel blockPanel(){
        BlockPanel blockPanel = new BlockPanel();
        this.blockDisplay = blockPanel;
        return blockPanel;
    }
    
    private JMenuBar toolbar(){
        JMenuBar menubar = new JMenuBar();
        menubar.add(button("left"));
        menubar.add(button("up"));
        menubar.add(button("down"));
        menubar.add(button("right"));
        return menubar;
    }
    
    private JButton button(String name){
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                commands.get(name).execute();
            }
        });
        return button;
    }
}
