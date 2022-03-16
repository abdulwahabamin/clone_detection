    private static void logv(String tag, String content) {
        if (isAndroid) {
            Log.v(tag, content);
        } else {
            System.out.println(tag + "-" + content);
        }
    }

