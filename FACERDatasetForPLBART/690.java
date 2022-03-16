    private static void loge(String tag, String content, Throwable tr) {
        if (isAndroid) {
            Log.e(tag, content, tr);
        } else {
            System.err.println(tag + "-" + content);
        }
    }

