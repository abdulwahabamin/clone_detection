    public static AppPreference.GraphGridColors getGraphGridColor(Context context) {
        Theme theme = getTheme(context);
        if (null == theme) {
            return new AppPreference.GraphGridColors(Color.parseColor("#333333"), Color.LTGRAY);
        } else switch (theme) {
            case dark:
                return new AppPreference.GraphGridColors(Color.WHITE, Color.GRAY);
            case light:
                return new AppPreference.GraphGridColors(Color.parseColor("#333333"), Color.LTGRAY);
            default:
                return new AppPreference.GraphGridColors(Color.parseColor("#333333"), Color.LTGRAY);
        }
    }

