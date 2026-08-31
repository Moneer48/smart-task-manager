class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var id = 1

    fun addTask( title: String,
                 description: String,
                 priorityLevel: Priority) {
        val newTask = Task(
            id = id++,
            title = title,
            description = description,
            priority = priorityLevel
        )

        tasks.add(newTask)
        println("Task added successfully!")
    }


    fun viewTasks() {
        if (tasks.isEmpty()) {
            println("No tasks exist yet!")
            return
        }

        println("--- Tasks List ---")
        for (task in tasks) {
            val status = if(task.isCompleted) "Completed" else "Not completed"
            println("| ID: ${task.id} | Title: ${task.title} | Priority: ${ task.priority } | Status: $status |")
            println("    Description: ${task.description}\n------------------")
        }

    }

    fun markTaskCompleted(id: Int) {
        if (id in tasks.map { it.id }) {
            val task = tasks.find { it.id == id }
            task!!.isCompleted = true
            return
        }
        println("No task of this ID!")
    }

    fun deleteTask(id: Int) {
        if (id in tasks.map { it.id }) {
            val task = tasks.find { it.id == id }

            do {
                print("Task found. Are you sure you want to delete that? (Y/N): ")
                val input = readLine()
                when(input?.uppercase()) {
                    "Y" -> {
                        tasks.remove(task)

                        println("Task removed successfully!")
                        return
                    }

                    "N" -> {
                        println("Canceled Successfully!")
                        return
                    }
                }
            } while(input?.uppercase() != "Y" && input?.uppercase() != "N")
        }
        else {
            println("No task of ID: $id")
        }
    }
}