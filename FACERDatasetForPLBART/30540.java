    private void init(Context context) {
        mContext = context;
        if (ContentUtil.APP_SETTING_THEME.equals("深色")) {
            isDark = true;
        } else {
            isDark = false;
        }
        initDefValue();
        initPaint();
    }

