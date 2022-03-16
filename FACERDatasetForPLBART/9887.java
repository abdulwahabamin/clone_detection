    /**
     * Method that applies the current theme to the activity
     */
    private void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(this.mContext);
        theme.setBackgroundDrawable(
                this.mContext, this.mContentView, "background_drawable"); //$NON-NLS-1$
        applyTabTheme();
        View v = this.mContentView.findViewById(R.id.filesystem_info_dialog_tab_divider1);
        theme.setBackgroundColor(this.mContext, v, "horizontal_divider_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_dialog_tab_divider2);
        theme.setBackgroundColor(this.mContext, v, "vertical_divider_color"); //$NON-NLS-1$

        v = this.mContentView.findViewById(R.id.filesystem_info_status_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_status);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_mount_point_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_mount_point);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_device_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_device);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_type_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_type);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_options_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_options);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_dump_pass_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_dump_pass);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_msg);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        ((TextView)v).setCompoundDrawablesWithIntrinsicBounds(
                theme.getDrawable(this.mContext,
                        "filesystem_dialog_warning_drawable"), //$NON-NLS-1$
                null, null, null);

        v = this.mContentView.findViewById(R.id.filesystem_info_total_disk_usage_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_total_disk_usage);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_used_disk_usage_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_used_disk_usage);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_free_disk_usage_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.filesystem_info_free_disk_usage);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
    }

