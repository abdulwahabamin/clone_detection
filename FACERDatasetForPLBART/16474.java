    /**
     * èŽ·å?–å¼‚å¸¸ä¿¡æ?¯åœ¨ç¨‹åº?ä¸­å‡ºé”™çš„ä½?ç½®å?ŠåŽŸå› 
     */
    public static String getErrorInfo(Throwable throwable) {
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        throwable.printStackTrace(pw);
        pw.close();
        return writer.toString();
    }

