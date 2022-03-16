    protected void resetActionBarTitle() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            int labelRes = getActivityLabelResourceId();
            if (labelRes > 0) {
                actionBar.setTitle(labelRes);
            }
        }
    }

