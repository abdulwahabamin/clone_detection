    /**
     * For the theme chooser
     */
    private void initActionBar() {

    	ActionBar actBar = getActionBar();
        
        // The ActionBar Title and UP ids are hidden.
        int upId = Resources.getSystem().getIdentifier("up", "id", "android");
        
        ImageView actionBarUp = (ImageView)findViewById(upId);

        // Theme chooser
        ThemeUtils.setActionBarBackground(this, actBar, "action_bar_background");
        ThemeUtils.initThemeChooser(this, actionBarUp, "action_bar_up", THEME_ITEM_BACKGROUND);

    	actBar.setDisplayUseLogoEnabled(true);
        actBar.setDisplayShowTitleEnabled(false);
    }

