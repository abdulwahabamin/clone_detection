    /**
     * 用于绘制指示器图标
     */
    private void drawMarkView(Canvas canvas) {

        int width = this.indicatorViewWidth - this.getPaddingLeft() - this.getPaddingRight() - intervalValue * 5;

        int left = this.getPaddingLeft();
        if (indicatorValue <= 50) {
            left += indicatorValue * (width * 4 / 6 / 200);
        } else if (indicatorValue > 50 && indicatorValue <= 100) {
            left += indicatorValue * (width * 4 / 6 / 200) + intervalValue;
        } else if (indicatorValue > 100 && indicatorValue <= 150) {
            left += indicatorValue * (width * 4 / 6 / 200) + intervalValue * 2;
        } else if (indicatorValue > 150 && indicatorValue <= 200) {
            left += indicatorValue * (width * 4 / 6 / 200) + intervalValue * 3;
        } else if (indicatorValue > 200 && indicatorValue <= 300) {
            left += (width * 4 / 6) + (indicatorValue - 200) * width / 6 / 100 + intervalValue * 4;
        } else {
            left += (width * 5 / 6) + (indicatorValue - 300) * width / 6 / 200 + intervalValue * 5;
        }
        canvas.drawBitmap(marker, left - marker.getWidth() / 2 - 2, this.paddingTopInXML, paint);
    }

