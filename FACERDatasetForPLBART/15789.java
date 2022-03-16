    synchronized protected void onTaskComplete(Task loadTask) {
        activeTasks.remove(loadTask);
        if(taskList.size() > 0) {
            Task task = taskList.getFirst();
            taskList.remove(task);
            loadAsync(task);
        }
    }

