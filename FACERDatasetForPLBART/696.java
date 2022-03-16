    private static void logwtf(String tag, String content) {
        if (isAndroid) {
            Log.wtf(tag, content);
        } else {
            System.out.println(tag + "-" + content);
        }
    }

