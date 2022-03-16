    /**
     * Method that initializes the titlebar of the activity.
     */
    private void initTitleActionBar() {
        //Configure the action bar options
        // Set up the action bar to show a dropdown list.
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(
                getResources().getDrawable(R.drawable.bg_material_titlebar));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayHomeAsUpEnabled(true);

        View customTitle = getLayoutInflater().inflate(R.layout.simple_customtitle, null, false);

        TextView title = (TextView)customTitle.findViewById(R.id.customtitle_title);
        title.setText(R.string.search);
        title.setContentDescription(getString(R.string.search));
        ButtonItem configuration = (ButtonItem)customTitle.findViewById(R.id.ab_button1);
        configuration.setImageResource(R.drawable.ic_material_light_config);
        configuration.setVisibility(View.VISIBLE);
        actionBar.setCustomView(customTitle);
    }

