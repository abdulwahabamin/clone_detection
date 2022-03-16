    private static int getKeyboardHeightValue(Activity activity) {
        Rect r = new Rect();
        View rootview = activity.getWindow().getDecorView(); // this = activity
        rootview.getWindowVisibleDisplayFrame(r);
        int remainh=r.bottom;//-r.top;

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;

        return height-remainh;
    }

