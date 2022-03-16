    /**
     * é‡?å?¯åº”ç”¨
     */
    public void restartApplication() {
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            exitApplication();
        }
    }

