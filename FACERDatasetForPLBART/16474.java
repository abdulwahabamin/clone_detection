    /**
     * 获�?�异常信�?�在程�?中出错的�?置�?�原因
     */
    public static String getErrorInfo(Throwable throwable) {
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        throwable.printStackTrace(pw);
        pw.close();
        return writer.toString();
    }

