    private static void outputVerbose(final Object obj, final int line,
                                      final String filename, final String format, final String thread, final boolean outToDDMS, final boolean outToFile, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    if (outToDDMS) {
                        String msg = (args == null || args.length == 0) ? format : String.format(format, args);
                        final String logText = msgForTextLog(LogOptions.LEVEL_VERBOSE, obj, filename, line, thread, msg);
                        Log.v(tag(obj), logText.substring(4));
                        if (outToFile) {
                            writeToLog(logText);
                        }
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

