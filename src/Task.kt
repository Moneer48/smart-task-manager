data class Task(val id: Int,
                val title: String,
                val description: String,
                val priority: Priority,
                var isCompleted: Boolean = false)