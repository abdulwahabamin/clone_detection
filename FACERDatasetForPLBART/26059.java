    private static void printStackTraces(StackTraceElement[] traces,
                                         String tag, String keyword, boolean fullLog, boolean release) {
        printLog(tag, "------------------------------------", release);
        for (StackTraceElement e : traces) {
            String info = e.toString();
            if (fullLog
                    || (!isNullOrEmpty(keyword) && info.indexOf(keyword) != -1)) {
                printLog(tag, info, release);
            }
        }
        printLog(tag, "------------------------------------", release);
    }

