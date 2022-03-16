    synchronized public void loadAsync(Task task) {
        if(activeTasks.size() < maxThreads) {
            Executor executor = new Executor();
            activeTasks.put(task, executor);
            executor.execute(task);
        } else {
            taskList.addLast(task);
        }
    }

