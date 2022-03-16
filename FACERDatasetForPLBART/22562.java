    public static void setStatusBarColor(Activity activity, String key, int color) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                final Window window = activity.getWindow();
                if (Config.coloredStatusBar(activity, key))
                    window.setStatusBarColor(getStatusBarColor(color));
                else window.setStatusBarColor(Color.BLACK);
                if (Config.coloredNavigationBar(activity, key))
                    window.setNavigationBarColor(color);
                else window.setNavigationBarColor(Color.BLACK);
                applyTaskDescription(activity, key, color);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                final View decorView = activity.getWindow().getDecorView();
                final int lightStatusMode = Config.lightStatusBarMode(activity, key);
                boolean lightStatusEnabled = false;
                switch (lightStatusMode) {
                    case Config.LIGHT_STATUS_BAR_OFF:
                    default:
                        break;
                    case Config.LIGHT_STATUS_BAR_ON:
                        lightStatusEnabled = true;
                        break;
                    case Config.LIGHT_STATUS_BAR_AUTO:
                        lightStatusEnabled = Util.isColorLight(color);
                        break;
                }

                final int systemUiVisibility = decorView.getSystemUiVisibility();
                if (lightStatusEnabled) {
                    decorView.setSystemUiVisibility(systemUiVisibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                } else {
                    decorView.setSystemUiVisibility(systemUiVisibility & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                final int color2 = Config.coloredStatusBar(activity, key) ?
                        Color.TRANSPARENT : Color.BLACK;
                activity.getWindow().setStatusBarColor(color2);
            }
            if (Config.coloredStatusBar(activity, key))
                ((DrawerLayout) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0)).setStatusBarBackgroundColor(getStatusBarColor(color));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

