import javax.swing.SwingUtilities;
import ui.ToDoFrame;

public class App{
    public static void main(String []args){
        SwingUtilities.invokeLater(() -> new ToDoFrame());
    }
}