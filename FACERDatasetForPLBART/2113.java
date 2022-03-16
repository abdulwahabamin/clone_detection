    private void interruptTasks() {
        if (readDatabaseTask != null) {
            readDatabaseTask.cancel(true);
        }
        if (!calculateSize.isEmpty()) {
            for (AsyncTask task : calculateSize) {
                task.cancel(true);
            }
        }
    }

