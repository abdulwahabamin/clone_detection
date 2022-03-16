    private static boolean isPortrait (Context cx) {
        Display d = ((WindowManager) cx.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if (d.getWidth() == d.getHeight()) {
            return false;
        } else {
            return d.getWidth() < d.getHeight();
        }
    }

