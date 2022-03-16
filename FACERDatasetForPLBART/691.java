    private static void logd(String tag, String content) {
        if (isAndroid) {
            Log.d(tag, content);
        } else {
            System.out.println(tag + "-" + content);
        }
    }

