    /**
     * Method that applies the current theme to the tab host
     */
    private void applyTabTheme() {
        // Apply the theme
        Theme theme = ThemeManager.getCurrentTheme(this.mContext);
        View v = this.mContentView.findViewById(R.id.filesystem_info_dialog_tab_info);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_dialog_tab_disk_usage);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
    }

