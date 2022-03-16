    /**
     * Method that communicates the exit code of the program
     *
     * @param exitCode The exit code of the program
     * @hide
     */
    public final void onRequestExitCode(int exitCode) {
        //If a listener is defined, then send the start event
        if (getAsyncResultListener() != null) {
            getAsyncResultListener().onAsyncExitCode(exitCode);
        }
    }

