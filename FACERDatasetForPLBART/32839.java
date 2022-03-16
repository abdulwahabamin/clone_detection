    public static int getBackgroundColor(Context context) {
        Theme theme = getTheme(context);
        if (null == theme) {
            return ContextCompat.getColor(context,
                    R.color.widget_transparentTheme_colorBackground);
        } else switch (theme) {
            case dark:
                return ContextCompat.getColor(context,
                        R.color.widget_darkTheme_colorBackground);
            case light:
                return Color.WHITE;
            default:
                return ContextCompat.getColor(context,
                        R.color.widget_transparentTheme_colorBackground);
        }
    }

