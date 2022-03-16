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
        this.mTitle.setText(R.string.editor);
        this.mTitle.setContentDescription(getString(R.string.editor));

        this.mSave = (ButtonItem)customTitle.findViewById(R.id.ab_button0);
        this.mSave.setImageResource(R.drawable.ic_material_light_save);
        this.mSave.setContentDescription(getString(R.string.actionbar_button_save_cd));
        this.mSave.setVisibility(View.GONE);

        this.mPrint = (ButtonItem)customTitle.findViewById(R.id.ab_button1);
        this.mPrint.setImageResource(R.drawable.ic_material_light_print);
        this.mPrint.setContentDescription(getString(R.string.actionbar_button_print_cd));
        this.mPrint.setVisibility(View.VISIBLE);

        ButtonItem configuration = (ButtonItem)customTitle.findViewById(R.id.ab_button2);
        configuration.setImageResource(R.drawable.ic_material_light_overflow);
        configuration.setContentDescription(getString(R.string.actionbar_button_overflow_cd));

        View status = findViewById(R.id.editor_status);
        boolean showOptionsMenu = AndroidHelper.showOptionsMenu(this);
        configuration.setVisibility(showOptionsMenu ? View.VISIBLE : View.GONE);
        this.mOptionsAnchorView = showOptionsMenu ? configuration : status;

        getActionBar().setCustomView(customTitle);
    }

