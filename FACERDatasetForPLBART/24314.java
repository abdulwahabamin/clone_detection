    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        if (icicle != null) {
            mCurrentId = icicle.getLong(getSelectedCategoryId());
            mCurrentName = icicle.getString(CURRENT_NAME);
            mIsUnknown = icicle.getBoolean(IS_UNKNOWN);
        }
    }

