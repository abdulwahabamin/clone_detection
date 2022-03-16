    private static void outputVerbose(final Object obj, final String format, final boolean outToDDMS, final boolean outToFile, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String logText = (args == null || args.length == 0) ? format : String.format(format, args);
                    if (outToDDMS) {
                        Log.v(tag(obj), logText);
                    }
                    if (outToFile) {
                        writeToLog(logText);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

