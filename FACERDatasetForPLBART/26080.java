    private static void outputWarning(final Object obj, final String format, final String theadName,
                                      final int line, final String filename, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = (args == null || args.length == 0) ? format : String.format(format, args);
                    String logText = msgForTextLog(LogOptions.LEVEL_WARN, obj, filename, line, theadName, msg);
                    Log.w(tag(obj), logText.substring(4));
                    writeToLog(logText);
                } catch (Throwable e) {
                    new Exception("exception when logging \"" + format + "\"", e).printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

