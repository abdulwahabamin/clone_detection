    public int getSectionColor() {
        int sectionColor = UIUtil.getColor(getContext(), R.color.colorAccent);
        for (LevelColorPair levelColorPair : mLevelColors) {
            if (levelColorPair.levelNumber > mCurrentValue) {
                sectionColor = levelColorPair.color;
                break;
            }
        }
        return sectionColor;
    }

