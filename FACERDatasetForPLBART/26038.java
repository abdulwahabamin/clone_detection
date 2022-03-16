    /**
     * Flush the written logs. The log methods write logs to a buffer.
     *
     * NOTE this will be called if close is called.
     */
    public static void flush() {
        Runnable command = new Runnable() {
            @Override
            public void run() {
                LogToES.flush();
            }
        };

        executeCommand(command);
    }

