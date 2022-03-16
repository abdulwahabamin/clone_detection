    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        this.indicatorViewWidth = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int indicatorViewHeight = MeasureSpec.getSize(heightMeasureSpec);

        int desiredWidth = indicatorViewWidth + getPaddingLeft() + getPaddingRight();
        int desiredHeight = this.getChildAt(0).getMeasuredHeight() + getPaddingTop() + getPaddingBottom();

        //测�?宽度
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST:
                indicatorViewWidth = Math.min(desiredWidth, indicatorViewWidth);
                break;
            case MeasureSpec.UNSPECIFIED:
                indicatorViewWidth = desiredWidth;
                break;
        }

        //测�?高度
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST:
                indicatorViewHeight = Math.min(desiredHeight, indicatorViewHeight);
                break;
            case MeasureSpec.UNSPECIFIED:
                indicatorViewHeight = desiredHeight;
                break;
        }
        setMeasuredDimension(indicatorViewWidth, indicatorViewHeight);
    }

