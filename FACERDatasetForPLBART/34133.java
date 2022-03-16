    public static void setNavigationBarMode(Activity context, boolean darkTheme, boolean blackTheme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            View content = context.findViewById(android.R.id.content);
            if (!darkTheme && !blackTheme) {
                content.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
            }
        }
    }

