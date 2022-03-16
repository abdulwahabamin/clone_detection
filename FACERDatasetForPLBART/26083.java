    private static void outputError(final Object obj, final Throwable t, final String methodname) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String logText = objClassName(obj);
                    Log.e(tag(obj), logText, t);
                    logToFile(logText, t);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

