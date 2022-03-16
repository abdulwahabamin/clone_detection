    private static String getThrowable(Throwable throwable, String mag) {
        /* æ‰“å?°å¼‚å¸¸ */
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(mag)) {
            sb.append(mag);
        }
        if (throwable != null) {
            sb.append(LINE_BREAK);
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            throwable.printStackTrace(printWriter);
            sb.append(stringWriter.toString());
        }
        return sb.toString();
    }

