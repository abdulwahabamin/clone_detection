    public static void appendLog(Context context, String tag, Throwable throwable, String... texts) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        File logFile = new File(logFilePathname);
        Date now = new Date();
        try {
            if (logFile.exists()) {
                if (logFileAtTheEndOfLive == null) {
                    boolean succeeded = initFileLogging(logFile);
                    if (!succeeded) {
                        createNewLogFile(logFile, now);
                    }
                } else if(Calendar.getInstance().after(logFileAtTheEndOfLive)) {
                    logFile.delete();
                    createNewLogFile(logFile, now);
                }
            } else {
                createNewLogFile(logFile, now);
            }
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(DATE_FORMATTER.format(now));
            buf.append(" ");
            buf.append(tag);
            buf.append(" - ");
            if (texts != null) {
                for (String text: texts) {
                    buf.append(text);
                }
            }
            if (throwable != null) {
                buf.append("\n");
                buf.append(throwable.getMessage());
                for (StackTraceElement ste: throwable.getStackTrace()) {
                    buf.newLine();
                    buf.append(ste.toString());
                }
            }
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

