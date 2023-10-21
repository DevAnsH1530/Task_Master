# Task Management System (Java SE 8)
## Project Description
The Task Management System is a Java SE 8 based application designed to help users
manage their tasks efficiently. This system utilizes Java's Collections framework for data
storage, robust exception handling for error management, and multithreading for concurrent
task processing.
### Key Features
1. **Task Management:** Add, edit, and delete tasks. Each task includes details such as task
ID, title, description, and status.
2. **Concurrency:** Utilizes multithreading to manage tasks concurrently, improving
performance and responsiveness.
3. **Exception Handling:** Robust error handling and graceful error reporting to ensure the
application runs smoothly.
4. **User-friendly Interface:** Command-line interface with intuitive commands for task
management.
### Technologies Used
- **Java Version:** Java SE 8
- **Collections Framework:** Utilized for efficient data storage and retrieval.
- **Multithreading:** Java's `ExecutorService` for handling concurrent task execution.
- **Exception Handling:** Java's exception handling mechanisms for error handling.
### How to Run the Application
1. Clone this repository to your local machine.
2. Compile the Java code: `javac TaskManagementSystem.java`.
3. Run the application: `java TaskManagementSystem`.
### Directory Structure
- `TaskManagementSystem.java`: Main application code.
- `Task.java`: Class definition for tasks.

- `TaskNotFoundException.java`: Custom exception class for task-related errors.
### Usage
Follow the command-line prompts to perform the following operations:
- Add a new task.
- Edit an existing task.
- Remove a task.
- List all tasks.
- Find a task by ID.
- Exit the application.
### Contributors
- Devansh Gupta
### Acknowledgments
Special thanks to the Java SE 8 development community for making this project possible.
