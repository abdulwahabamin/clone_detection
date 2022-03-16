    synchronized public void cancelTask(Task task, boolean interrupt) {
        if(activeTasks.containsKey(task)) {
            activeTasks.get(task).cancel(interrupt);
            activeTasks.remove(task);
        } else if(taskList.contains(task)) {
            taskList.remove(task);
        }
    }

