    private static void logi(String tag, String content) {
        if (isAndroid) {
            Log.i(tag, content);
        } else {
            System.out.println(tag + "-" + content);
        }
    }

