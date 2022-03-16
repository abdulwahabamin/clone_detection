    private static void outputInfo(final Object obj, final String format, final String thread,
                                   final int line, final String filename, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = (args == null || args.length == 0) ? format : String.format(format, args);
                    String logText = msgForTextLog(LogOptions.LEVEL_INFO, obj, filename, line, thread, msg);
                    Log.i(tag(obj), logText.substring(4));
                    writeToLog(logText);
                } catch (Throwable e) {
                    new Exception("exception when logging \"" + format + "\"", e).printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

