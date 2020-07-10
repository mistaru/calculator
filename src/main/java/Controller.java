import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Calculator program executed in Java and Swing with MVC template
 * Main function:
 * This program repeats the basic functions of the Windows Calculator in "Normal" mode
 * with the ability to calculate examples where there are brackets.
 * Calculations are performed using the logic of reverse Polish notation.
 * Its possibility:
 * addition, subtraction, multiplication,division,parentheses,
 * integers and fractions, clearing the screen.
 * You can enter data using the app's buttons.
 *
 * @author Argen Kasymov
 */


/**
 * Controller
 * The controller accepts data and translates it into commands for the model or View.
 * Implements the ActionListener interface for listening to actions from the viewer
 */
public class Controller implements ActionListener {

    private Model model;

    public Controller(Viewer viewer){
        this.model = new Model(viewer);
    }

    /**
     * actionPerformed
     * Listens for actions and sends commands to the model
     */
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
	    model.doAction(command);
    }

}
