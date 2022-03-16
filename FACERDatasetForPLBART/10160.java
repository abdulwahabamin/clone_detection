    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(getContext());

        //- Breadcrumb
        if (this.mBreadcrumbBar != null) {
            int cc = this.mBreadcrumbBar.getChildCount();
            for (int i = 0; i < cc; i++) {
                // There are 2 types: Breadcrumb items and separators
                View v = this.mBreadcrumbBar.getChildAt(i);
                if (v instanceof BreadcrumbItem) {
                    // Breadcrumb item
                    theme.setTextColor(
                            getContext(), (BreadcrumbItem)v, "action_bar_text_color"); //$NON-NLS-1$
                } else if (v instanceof ImageView) {
                    // Divider drawable
                    theme.setImageDrawable(
                            getContext(),
                            (ImageView)v, "breadcrumb_divider_drawable"); //$NON-NLS-1$
                }
            }
        }
        if (this.mDiskUsageInfo != null) {
            Drawable dw = theme.getDrawable(getContext(), "horizontal_progress_bar"); //$NON-NLS-1$
            this.mDiskUsageInfo.setProgressDrawable(dw);
        }
        final ImageView fsInfo = (ImageView)findViewById(R.id.ab_filesystem_info);
        if (fsInfo != null) {
            MountPoint mp = (MountPoint) fsInfo.getTag();
            if (mp == null) {
                theme.setImageDrawable(getContext(), fsInfo, "filesystem_warning_drawable");
            } else {
                String resource =
                        MountPointHelper.isReadOnly(mp)
                        ? "filesystem_locked_drawable"
                        : "filesystem_unlocked_drawable";
                theme.setImageDrawable(getContext(), fsInfo, resource);
            }
        }
    }

