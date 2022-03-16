    private static void logw(String tag, String content) {
        if (isAndroid) {
            Log.w(tag, "" + content);
        } else {
            System.out.println(tag + "-" + content);
        }
    }

