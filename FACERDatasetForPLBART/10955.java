    /**
     * Method that applies the current theme to the activity
     * @hide
     */
    void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseTheme(this, false);

        //- ActionBar
        theme.setTitlebarDrawable(this, getActionBar(), "titlebar_drawable"); //$NON-NLS-1$
        View v = getActionBar().getCustomView().findViewById(R.id.customtitle_title);
        theme.setTextColor(this, (TextView)v, "action_bar_text_color"); //$NON-NLS-1$
        v = findViewById(R.id.ab_button0);
        theme.setImageDrawable(this, (ImageView)v, "ab_save_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_button1);
        theme.setImageDrawable(this, (ImageView)v, "ab_print_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_button2);
        theme.setImageDrawable(this, (ImageView)v, "ab_overflow_drawable"); //$NON-NLS-1$
        //- View
        v = findViewById(R.id.editor_layout);
        theme.setBackgroundDrawable(this, v, "background_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.editor);
        theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$
        //- ProgressBar
        Drawable dw = theme.getDrawable(this, "horizontal_progress_bar"); //$NON-NLS-1$
        this.mProgressBar.setProgressDrawable(dw);
        v = findViewById(R.id.editor_progress_msg);
        theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$

        // Need a full process of syntax highlight
        if (!this.mBinary && this.mSyntaxHighlight && this.mSyntaxHighlightProcessor != null) {
            reloadSyntaxHighlight();
        }
    }

