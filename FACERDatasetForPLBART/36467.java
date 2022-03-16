    /**
     * 设置状�?�?图标为深色和魅�?特定的文字风格
     * �?�以用�?�判断是�?�为 Flyme 用户
     *
     * @param isFontColorDark 是�?�把状�?�?字体�?�图标颜色设置为深色
     * @return boolean �?功执行返回 true
     */
    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {
        Window window = activity.getWindow();
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field flymeFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                flymeFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = flymeFlags.getInt(lp);
                if (isFontColorDark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                flymeFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

