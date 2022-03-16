    public void setIndicatorValue(int indicatorValue) {

        if (indicatorValue < 0)
            throw new IllegalStateException("�?�数indicatorValue必须大于0");

        this.indicatorValue = indicatorValue;
        if (indicatorValueChangeListener != null) {
            String stateDescription;
            int indicatorTextColor;
            if (indicatorValue <= 50) {
                stateDescription = indicatorStrings[0];
                indicatorTextColor = indicatorColorIds[0];
            } else if (indicatorValue > 50 && indicatorValue <= 100) {
                stateDescription = indicatorStrings[1];
                indicatorTextColor = indicatorColorIds[1];
            } else if (indicatorValue > 100 && indicatorValue <= 150) {
                stateDescription = indicatorStrings[2];
                indicatorTextColor = indicatorColorIds[2];
            } else if (indicatorValue > 150 && indicatorValue <= 200) {
                stateDescription = indicatorStrings[3];
                indicatorTextColor = indicatorColorIds[3];
            } else if (indicatorValue > 200 && indicatorValue <= 300) {
                stateDescription = indicatorStrings[4];
                indicatorTextColor = indicatorColorIds[4];
            } else {
                stateDescription = indicatorStrings[5];
                indicatorTextColor = indicatorColorIds[5];
            }
            marker.recycle();
            marker = drawableToBitmap(createVectorDrawable(markerId, indicatorTextColor));
            indicatorValueChangeListener.onChange(this.indicatorValue, stateDescription, indicatorTextColor);
        }
        invalidate();
    }

