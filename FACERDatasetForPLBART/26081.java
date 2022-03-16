    private static void outputError(final Object obj, final String format, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String logText = (args == null || args.length == 0) ? format : String.format(format, args);
                    // If the last arg is a throwable, print the stack.
                    if (args != null && args.length > 0 && args[args.length - 1] instanceof Throwable) {
                        Throwable t = (Throwable) args[args.length - 1];
                        Log.e(tag(obj), logText, t);
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

