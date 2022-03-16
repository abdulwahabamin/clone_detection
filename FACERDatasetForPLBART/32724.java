    public static GraphGridColors getWidgetGraphGridColor(Context context) {
        String theme = getWidgetTheme(context);
        if (null == theme) {
            return new GraphGridColors(Color.parseColor("#333333"), Color.LTGRAY);
        } else switch (theme) {
            case "dark":
                return new GraphGridColors(Color.WHITE, Color.GRAY);
            case "light":
                return new GraphGridColors(Color.parseColor("#333333"), Color.LTGRAY);
            default:
                return new GraphGridColors(Color.WHITE, Color.GRAY);
        }
    }

