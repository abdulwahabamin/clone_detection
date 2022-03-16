    private void runTasks() {
        if (readDatabaseTask != null) {
            if (readDatabaseTask.getStatus().equals(AsyncTask.Status.PENDING)) {
                ((ReadDatabaseTask) readDatabaseTask).execute();
            }

        }
        if (!calculateSize.isEmpty()) {
            for (AsyncTask task : calculateSize) {
                if (task.getStatus().equals(AsyncTask.Status.PENDING)) {
                    ((CalculateSizeTask) task).execute();
                }
            }
        }
    }

