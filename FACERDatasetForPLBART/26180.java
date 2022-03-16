    /**
     * èŽ·å?–çŠ¶æ€?æ ?é«˜åº¦
     *
     * @return
     */
    public static int getStatusBarHeight() {
        int id = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (id == 0) {
            return 0;
        } else {
            return Resources.getSystem().getDimensionPixelSize(id);
        }
    }

