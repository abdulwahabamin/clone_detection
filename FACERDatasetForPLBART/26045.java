    private static void logToFile(final String logText, final Throwable t) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                StringWriter sw = new StringWriter();
                sw.write(logText);
                sw.write("\n");
                t.printStackTrace(new PrintWriter(sw));
                writeToLog(sw.toString());
            }
        };
        executeCommand(command);
    }

