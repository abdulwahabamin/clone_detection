    /**
     * Apply KitKat specific translucency.
     */
    private void applyKitKatTranslucency() {

        //KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            int topPadding = Common.getStatusBarHeight(mContext);
            if (mDrawerParentLayout!=null) {
                mDrawerParentLayout.setPadding(0, (0-topPadding), 0, 0);
                mDrawerParentLayout.setClipToPadding(false);

                int navigationBarHeight = Common.getNavigationBarHeight(mContext);
                mListView.setClipToPadding(false);
                mListView.setPadding(mListView.getPaddingLeft(),
                                     mListView.getPaddingTop(),
                                     mListView.getPaddingRight(),
                                     mListView.getPaddingBottom() + navigationBarHeight);


            }

        }

    }

