    /**
     * 绘制底部左�?�边的日出时间和日�?�时间
     *
     * @param canvas
     */
    private void drawFont(Canvas canvas) {
        if (ContentUtil.APP_SETTING_TESI.equalsIgnoreCase("mid")) {
            mFontSize = DisplayUtil.dp2px(getContext(), 10);
        } else if (ContentUtil.APP_SETTING_TESI.equalsIgnoreCase("large")) {
            mFontSize = DisplayUtil.dp2px(getContext(), 13);
        } else {
            mFontSize = DisplayUtil.dp2px(getContext(), 12);
        }

        mTextPaint.setColor(mFontColor);
        mTextPaint.setTextSize(mFontSize);
        if (ContentUtil.APP_SETTING_THEME.equals("深色")) {
            mTimePaint.setColor(getResources().getColor(R.color.aqi_color_light));
        } else {
            mTimePaint.setColor(getResources().getColor(R.color.air_text_common_light));
        }
        mTimePaint.setTextSize(mFontSize);
        String startTime = TextUtils.isEmpty(mStartTime) ? "" : mStartTime;
        String endTime = TextUtils.isEmpty(mEndTime) ? "" : mEndTime;
        String sunrise = "日出";
        String sunset = "日�?�";
        if (!isSun) {
            sunrise = "月出";
            sunset = "月�?�";
        }
        if (ContentUtil.APP_SETTING_LANG.equals("en") || ContentUtil.APP_SETTING_LANG.equals("sys") && ContentUtil.SYS_LANG.equals("en")) {
            sunrise = "Sunrise";
            sunset = "Sunset";
            if (!isSun) {
                sunrise = "Moonrise";
                sunset = "Moonset";
            }
        }
        mTimePaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(sunrise, mWidth / 2 - mRadius + DisplayUtil.dip2px(mContext, 8), mRadius + DisplayUtil.dip2px(mContext, 16) + marginTop, mTextPaint);
        canvas.drawText(startTime, mWidth / 2 - mRadius + DisplayUtil.dip2px(mContext, 8), mRadius + DisplayUtil.dip2px(mContext, 32) + marginTop, mTimePaint);
        canvas.drawText(sunset, mWidth / 2 + mRadius - DisplayUtil.dip2px(mContext, 8), mRadius + DisplayUtil.dip2px(mContext, 16) + marginTop, mTextPaint);
        canvas.drawText(endTime, mWidth / 2 + mRadius - DisplayUtil.dip2px(mContext, 8), mRadius + DisplayUtil.dip2px(mContext, 32) + marginTop, mTimePaint);
    }

