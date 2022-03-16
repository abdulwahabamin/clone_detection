    /**
     * Method that applies the current theme to the widget components
     */
    public void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(getContext());
        View v = findViewById(R.id.inline_autocomplete_bg_text);
        theme.setTextColor(getContext(), (TextView)v, "text_color"); //$NON-NLS-1$
        v = findViewById(R.id.inline_autocomplete_fg_text);
        theme.setTextColor(getContext(), (TextView)v, "text_color"); //$NON-NLS-1$
        v = findViewById(R.id.inline_autocomplete_button_tab);
        theme.setImageDrawable(
                getContext(), (ImageView)v, "ab_tab_drawable"); //$NON-NLS-1$
    }

