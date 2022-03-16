    /**
     * Method that applies the current theme to the activity
     */
    public void applyTheme() {
        //- Breadcrumb
        if (getBreadcrumb() != null) {
            getBreadcrumb().applyTheme();
        }

        //- Redraw the adapter view
        Theme theme = ThemeManager.getCurrentTheme(getContext());
        theme.setBackgroundDrawable(getContext(), this, "background_drawable"); //$NON-NLS-1$
        if (this.mAdapter != null) {
            this.mAdapter.notifyThemeChanged();
        }
        if (this.mAdapterView instanceof ListView) {
            ((ListView)this.mAdapterView).setDivider(
                    theme.getDrawable(getContext(), "horizontal_divider_drawable")); //$NON-NLS-1$
        }
        refresh();
    }

