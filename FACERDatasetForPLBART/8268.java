    /**
     * Method that reconfigures the layout for better fit in portrait and landscape modes
     */
    private void onLayoutChanged() {
        Theme theme = ThemeManager.getCurrentTheme(this);
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(Gravity.START);

        // Apply only when the orientation was changed
        int orientation = getResources().getConfiguration().orientation;
        if (this.mOrientation == orientation) return;
        this.mOrientation = orientation;

        // imitate a closed drawer while layout is rebuilt to avoid NullPointerException
        if (drawerOpen) {
            mDrawerLayout.closeDrawer(Gravity.START);
        }

        if (this.mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Landscape mode
            ViewGroup statusBar = (ViewGroup)findViewById(R.id.navigation_statusbar);
            if (statusBar.getParent() != null) {
                ViewGroup parent = (ViewGroup) statusBar.getParent();
                parent.removeView(statusBar);
            }

            // Calculate the action button size (all the buttons must fit in the title bar)
            int bw = (int)getResources().getDimension(R.dimen.default_buttom_width);
            int abw = this.mActionBar.getChildCount() * bw;
            int rbw = 0;
            int cc = statusBar.getChildCount();
            for (int i = 0; i < cc; i++) {
                View child = statusBar.getChildAt(i);
                if (child instanceof ButtonItem) {
                    rbw += bw;
                }
            }
            // Currently there isn't overflow menu
            int w = abw + rbw - bw;

            // Add to the new location
            ViewGroup newParent = (ViewGroup)findViewById(R.id.navigation_title_landscape_holder);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            w,
                            ViewGroup.LayoutParams.MATCH_PARENT);
            statusBar.setLayoutParams(params);
            newParent.addView(statusBar);

            // Apply theme
            theme.setBackgroundDrawable(this, statusBar, "titlebar_drawable"); //$NON-NLS-1$

            // Hide holder
            View holder = findViewById(R.id.navigation_statusbar_portrait_holder);
            holder.setVisibility(View.GONE);

        } else {
            // Portrait mode
            ViewGroup statusBar = (ViewGroup)findViewById(R.id.navigation_statusbar);
            if (statusBar.getParent() != null) {
                ViewGroup parent = (ViewGroup) statusBar.getParent();
                parent.removeView(statusBar);
            }

            // Add to the new location
            ViewGroup newParent = (ViewGroup)findViewById(
                    R.id.navigation_statusbar_portrait_holder);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
            statusBar.setLayoutParams(params);
            newParent.addView(statusBar);

            // Apply theme
            theme.setBackgroundDrawable(this, statusBar, "statusbar_drawable"); //$NON-NLS-1$

            // Show holder
            newParent.setVisibility(View.VISIBLE);
        }

        // if drawer was open, imitate reopening
        if (drawerOpen) {
            mDrawerToggle.onDrawerOpened(mDrawer);
        }
    }

