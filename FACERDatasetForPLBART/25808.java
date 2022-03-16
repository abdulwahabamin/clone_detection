    public void setColorLever(List<LevelColorPair> colorLevelInfo) {
        if (colorLevelInfo == null) {
            return;
        }
        mLevelColors = new ArrayList<>();
        mLevelColors.clear();
        mLevelColors.addAll(colorLevelInfo);
        mLevelCount = mLevelColors.size();
        invalidate();
    }

