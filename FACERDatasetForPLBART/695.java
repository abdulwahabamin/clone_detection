    private static void logwtf(String tag, Throwable tr) {
        if (isAndroid) {
            Log.wtf(tag, tr);
        } else {
            if (tr != null) {
                System.out.println(tag + "-" + tr.getMessage());
            }
        }
    }

