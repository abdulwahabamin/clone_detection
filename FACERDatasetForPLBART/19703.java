    /**
     * Returns the view container for the ActionBar.
     * @return
     */
    public View getActionBarView(Activity activity) {
        Window window = activity.getWindow();
        View view = window.getDecorView();
        int resId = getResources().getIdentifier("action_bar_container", "id", "android");

        return view.findViewById(resId);
    }

