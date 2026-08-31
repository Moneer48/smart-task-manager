//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var running = true
    val newTask = TaskManager()
    println("\n--- This is Moneer's Task Manager ---")

    while(running) {

        println("\n---------------------------\nChoose among the following:")
        println("""
            1. Add Task
            2. View Tasks
            3. Mark Task as Completed
            4. Delete Task
            5. Exit
        """.trimIndent())

        print("\nInput: ")
        val input = readLine()?.toIntOrNull() ?: 6

        when(input) {
            1 -> {
                println("--- Task Creation ---")

                println("Title: ")
                val title = readLine() ?: ""

                println("Description: ")
                val description = readLine() ?: ""

                println("Priority Level: ")
                println("1: Low\n2: Medium\n3: High")
                val priorityInput = readLine()?.toIntOrNull()

                val priority = when(priorityInput) {
                    1 -> Priority.LOW
                    2 -> Priority.MEDIUM
                    3 -> Priority.HIGH
                    else -> Priority.LOW
                }

                newTask.addTask(title, description, priority)
            }
            2 -> newTask.viewTasks()
            3 -> {
                println("Enter task ID to be marked as complete: ")
                val taskId = readLine()?.toIntOrNull() ?: 0
                newTask.markTaskCompleted(taskId)
            }
            4 -> {
                println("Enter task ID to be deleted: ")
                val taskId = readLine()?.toIntOrNull() ?: 0
                newTask.deleteTask(taskId)
            }
            5 -> {
            println("\nGood Bye :)")
            running = false
            }
            6 -> println("Invalid Input!")
        }
    }
}