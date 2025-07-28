# ToDoMan

project:
  name: ToDoMan
  description: |
    ToDoMan is a simple and effective desktop-based To-Do List application built with Java and Swing.
    It enables users to manage daily tasks, save progress using file I/O, and offers a beginner-friendly code structure.
  version: 1.0
  author: Vinay
  license: MIT

technologies:
  - Java
  - Swing
  - File I/O (java.io)

features:
  - Add new tasks
  - Mark tasks as done/undone
  - Delete tasks
  - Auto-save to file (tasks.txt)
  - Load tasks on startup

structure:
  todoman:
    - App.java: Entry point of the app
    - model:
        - Task.java: Task data model (description + status)
    - ui:
        - ToDoFrame.java: GUI design and event handling
    - storage:
        - FileStorage.java: Handles saving/loading tasks from file

classes:
  - name: Task.java
    location: model
    description: Defines task structure and behavior
    methods:
      - getDescription(): returns the task description
      - isDone(): returns whether task is complete
      - toggleDone(): toggles task completion
      - toString(): returns formatted task string for UI

  - name: FileStorage.java
    location: storage
    description: Manages saving/loading task data to/from `tasks.txt`
    methods:
      - saveTasks(ArrayList<Task>): writes tasks to file
      - loadTasks(): reads tasks from file into ArrayList

  - name: ToDoFrame.java
    location: ui
    description: GUI class that contains task list, buttons, input field
    components:
      - JTextField: for user input
      - JList: shows list of tasks
      - DefaultListModel: connects list with task data
      - JButton: add, delete, mark done buttons
    notes: Uses BorderLayout, JScrollPane, JOptionPane for layout and dialogs

  - name: App.java
    location: root
    description: Application entry point
    mainMethod: |
      Uses SwingUtilities.invokeLater to launch the GUI safely on the Event Dispatch Thread (EDT)

file_format:
  file: tasks.txt
  format: "<description>::<true/false>"
  example:
    - Buy groceries::true
    - Finish homework::false

how_it_works:
  steps:
    - App launches and reads `tasks.txt`
    - Displays all tasks in the GUI
    - User adds, deletes, or marks tasks
    - Changes are saved immediately
    - Upon next launch, tasks are loaded again

requirements:
  java: "8+"
  ide: "VS Code, IntelliJ IDEA, or Eclipse"

run_instructions:
  steps:
    - Clone the repository
    - Open in IDE
    - Compile and run `App.java`
    - Use the UI to manage your to-dos

enhancements:
  - Task categories (Work, Personal)
  - Due dates or reminders
  - Completion statistics
  - Dark mode UI
  - Use a database instead of file

license: MIT

