    /**
     * Method that set the task to execute when the re-execution ends.
     *
     * @param task The task to execute when the re-execution ends
     */
    public void setTask(AsyncTask<Object, Integer, Boolean> task) {
        this.mTask = task;
    }

