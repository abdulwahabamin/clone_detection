    /**
     * Method that applies the current theme to the activity
     */
    private void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(this.mContext);
        theme.setBackgroundDrawable(
                this.mContext, this.mContentView, "background_drawable"); //$NON-NLS-1$
        applyTabTheme();
        View v = this.mContentView.findViewById(R.id.fso_properties_dialog_tab_divider1);
        theme.setBackgroundColor(this.mContext, v, "horizontal_divider_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_dialog_tab_divider2);
        theme.setBackgroundColor(this.mContext, v, "vertical_divider_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_dialog_tab_divider3);
        theme.setBackgroundColor(this.mContext, v, "vertical_divider_color"); //$NON-NLS-1$

        v = this.mContentView.findViewById(R.id.fso_properties_name_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_name);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_parent_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_parent);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_type_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_type);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_category_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_category);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_link_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_link);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_size_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_size);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_contains_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_contains);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_last_accessed_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_last_accessed);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_last_modified_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_last_modified);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_last_changed_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_last_changed);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_include_in_media_scan_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$

        v = this.mContentView.findViewById(R.id.fso_properties_owner_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_group_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_special_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_read_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_write_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_execute_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_owner_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_group_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_properties_permissions_others_label);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        v = this.mContentView.findViewById(R.id.fso_info_msg);
        theme.setTextColor(this.mContext, (TextView)v, "text_color"); //$NON-NLS-1$
        ((TextView)v).setCompoundDrawablesWithIntrinsicBounds(
                theme.getDrawable(this.mContext,
                        "filesystem_dialog_warning_drawable"), //$NON-NLS-1$
                null, null, null);
    }

