    private static void printLog(String tag, String log, boolean release) {
        if (release) {
            info(tag, log);
        } else {
            debug(tag, log);
        }
    }

