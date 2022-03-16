    /**
     * èŽ·å?–å±?å¹•å®½é«˜ï¼Œsdk17å?Žä¸?å»ºè®®é‡‡ç”¨
     *
     * @param context
     */
    private static int[] getScreenHW(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        int[] HW = new int[] { width, height };
        return HW;
    }

