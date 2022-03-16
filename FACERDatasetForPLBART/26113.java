    /**
     * Warning: Deletes the content of a directory.
     * This is an I/O operation and this method executes in the main thread, so it is recommended to
     * perform the operation using another thread.
     *
     * @param directory The directory which its content will be deleted.
     */
    public static void clearDirectory(final File directory) {
        TaskScheduler.execute(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                if (directory.exists()) {
                    for (File file : directory.listFiles()) {
                        result = file.delete();
                    }
                }
            }
        });
    }

