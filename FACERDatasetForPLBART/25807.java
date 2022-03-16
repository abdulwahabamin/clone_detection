    public void setColorLever(int[] colorIds, int[] levels) {

        if (colorIds.length != levels.length) {
            return;
        }
        mLevelColors = new ArrayList<>();

        for (int index = 0; index < colorIds.length; index++) {
            mLevelColors.add(new LevelColorPair(levels[index], UIUtil.getColor(getContext(), colorIds[index])));
        }
        mLevelCount = mLevelColors.size();
        invalidate();
    }

