    /**
     * Method that attach a asynchronous task for executing when exception need
     * to be re-executed.
     *
     * @param ex The exception
     * @param task The task
     * @see RelaunchableException
     */
    public static void attachAsyncTask(Throwable ex, AsyncTask<Object, Integer, Boolean> task) {
        if (ex instanceof RelaunchableException) {
            ((RelaunchableException)ex).setTask(task);
        }
    }

