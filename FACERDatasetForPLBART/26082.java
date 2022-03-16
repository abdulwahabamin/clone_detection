    private static void outputError(final Object obj, final String format, final String threadName,
                                    final int line, final String filename, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = (args == null || args.length == 0) ? format : String.format(format, args);
                    String logText = msgForTextLog(LogOptions.LEVEL_ERROR, obj, filename, line, threadName, msg);
                    // If the last arg is a throwable, print the stack.
                    if (args != null && args.length > 0 && args[args.length - 1] instanceof Throwable) {
                        Throwable t = (Throwable) args[args.length - 1];
                        Log.e(tag(obj), logText.substring(4), t);
                        logToFile(logText, t);
                    } else {
                        Log.e(tag(obj), logText);
                        writeToLog(logText);
                    }
                } catch (Throwable e) {
                    new Exception("exception when logging \"" + format + "\"", e).printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

