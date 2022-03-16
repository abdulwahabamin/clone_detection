    private static void logwtf(String tag, String content, Throwable tr) {
        if (isAndroid) {
            Log.wtf(tag, content, tr);
        } else {
            System.out.println(tag + "-" + content);
        }
    }

