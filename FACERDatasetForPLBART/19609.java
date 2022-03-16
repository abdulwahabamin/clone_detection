    /**
     * Applies KitKat specific translucency.
     */
    public void applyKitKatTranslucency() {
        if (Build.VERSION.SDK_INT==Build.VERSION_CODES.KITKAT) {

            //Calculate ActionBar and navigation bar height.
            TypedValue tv = new TypedValue();
            int actionBarHeight = 0;
            if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            }

            ((View) this.getListView().getParent()).setPadding(0, actionBarHeight + mApp.getStatusBarHeight(mContext),
                                                               0, 0);

            this.getListView().setBackgroundColor(0xFFEEEEEE);
            this.getListView().setPadding(0, 0, 0, mApp.getNavigationBarHeight(mContext));
            this.getListView().setClipToPadding(false);

            //Set the window color.
            getWindow().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));

        }

    }

