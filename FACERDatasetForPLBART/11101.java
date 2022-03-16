    /**
     * Method that initializes the titlebar of the activity.
     */
    private void initTitleActionBar() {
        //Configure the action bar options
        getActionBar().setBackgroundDrawable(
                getResources().getDrawable(R.drawable.bg_material_titlebar));
        getActionBar().setDisplayOptions(
                ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        View customTitle = getLayoutInflater().inflate(R.layout.simple_customtitle, null, false);
        this.mTitle = (TextView)customTitle.findViewById(R.id.customtitle_title);
        this.mTitle.setText(R.string.pref);
        this.mTitle.setContentDescription(getString(R.string.pref));
        getActionBar().setCustomView(customTitle);
    }

