package ui;

import model.Task;
import storage.FilesStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoFrame extends JFrame{
    private DefaultListModel<Task> taskListModel;
    private JList<Task> taskList;
    private JTextField taskInput;
    private ArrayList<Task> tasks;

    public ToDoFrame(){
        setTitle("To-Do List");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tasks = FilesStorage.loadTasks();
        taskListModel = new DefaultListModel<>();
        tasks.forEach(taskListModel::addElement);

        taskList= new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskInput = new JTextField();
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton doneButton = new JButton("Mark Done");

        addButton.addActionListener(e ->{
            String text = taskInput.getText().trim();
            if(!text.isEmpty()){
                Task newTask = new Task(text);
                taskListModel.addElement(newTask);
                tasks.add(newTask);
                taskInput.setText("");
                FilesStorage.saveTasks(tasks);
            }
        });

        deleteButton.addActionListener(e ->{
            int index = taskList.getSelectedIndex();
            if(index!=-1){
                tasks.remove(index);
                taskListModel.remove(index);
                FilesStorage.saveTasks(tasks);
            }
        });

        doneButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if(index != -1){
                Task task=tasks.get(index);
                task.toggleDone();
                taskList.repaint();
                FilesStorage.saveTasks(tasks);
            }
        });

        JPanel inputPanel =new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel controlPanel = new JPanel();
        controlPanel.add(doneButton);
        controlPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
