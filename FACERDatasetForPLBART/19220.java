    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT==Build.VERSION_CODES.KITKAT) {
            getActionBar().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
            getWindow().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
        }

    }

