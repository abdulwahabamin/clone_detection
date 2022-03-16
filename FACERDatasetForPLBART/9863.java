    /**
     * Method that applies the current theme to the dialog
     *
     * @param ctx The current context
     * @param root The root view
     */
    private void applyTheme(Context ctx, ViewGroup root) {
        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(ctx);
        theme.setBackgroundDrawable(ctx, root, "background_drawable"); //$NON-NLS-1$
        View v = root.findViewById(R.id.checksum_filename_label);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.checksum_filename);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.checksum_md5_label);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        theme.setBackgroundColor(ctx, this.mChecksums[0], "console_bg_color"); //$NON-NLS-1$
        theme.setTextColor(ctx, this.mChecksums[0], "console_fg_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.checksum_sha1_label);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        theme.setBackgroundColor(ctx, this.mChecksums[1], "console_bg_color"); //$NON-NLS-1$
        theme.setTextColor(ctx, this.mChecksums[1], "console_fg_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.bt_md5_clipboard);
        theme.setImageDrawable(ctx, (ImageView)v, "ic_copy_drawable"); //$NON-NLS-1$
        v = root.findViewById(R.id.bt_sha1_clipboard);
        theme.setImageDrawable(ctx, (ImageView)v, "ic_copy_drawable"); //$NON-NLS-1$
    }

