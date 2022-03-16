    @Override
    public void onResume() {
        super.onResume();
        applyKitKatTranslucency();
        getActionBar().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));

    }

