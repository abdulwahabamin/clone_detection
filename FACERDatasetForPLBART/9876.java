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
        View v = root.findViewById(R.id.execution_time_label);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.execution_script_name);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.execution_time_label);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        theme.setTextColor(ctx, this.mTvTime, "text_color"); //$NON-NLS-1$
        v = root.findViewById(R.id.execution_exitcode_label);
        theme.setTextColor(ctx, (TextView)v, "text_color"); //$NON-NLS-1$
        theme.setTextColor(ctx, this.mTvExitCode, "text_color"); //$NON-NLS-1$
        theme.setBackgroundColor(ctx, this.mTvOutput, "console_bg_color"); //$NON-NLS-1$
        theme.setTextColor(ctx, this.mTvOutput, "console_fg_color"); //$NON-NLS-1$
    }

