package storage;

import model.Task;
import java.io.*;
import java.util.ArrayList;

public class FilesStorage {
    private static final String FILE_NAME = "tasks.txt";
    
    public static void saveTasks(ArrayList<Task> tasks){
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for(Task t : tasks){
                writer.println(t.getDescription()+"::"+t.isDone());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> loadTasks(){
        ArrayList<Task> tasks = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split("::");
                if(parts.length == 2){
                    Task t = new Task(parts[0]);
                    if(Boolean.parseBoolean(parts[1])){
                        t.toggleDone();
                    }
                    tasks.add(t);
                }
            }
        }catch(IOException e){

        }
        return tasks;
    }
}
