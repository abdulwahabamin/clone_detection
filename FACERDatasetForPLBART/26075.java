    private static void outputDebug(final Object obj, final String format, final Object... args) {
        final Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String logText = (args == null || args.length == 0) ? format : String.format(format, args);
                    Log.d(tag(obj), logText);
                    writeToLog(logText);
                } catch (Throwable e) {
                    new Exception("exception when logging \"" + format + "\"", e).printStackTrace();
                }
            }
        };
        executeCommand(command);
    }

