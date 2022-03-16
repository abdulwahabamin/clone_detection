    private void drawTemp(Canvas canvas) {
        for (int i = 0; i < hourlyWeatherList.size(); i++) {
            if (currentItemIndex == i) {
                //计算�??示文字的�?动轨迹
//                int Y = getTempBarY(i);
                String tmp = hourlyWeatherList.get(i).getTmp();
                float temp = Integer.parseInt(tmp);
                int Y = (int) (tempHeightPixel(temp) + paddingT);
                //画出温度�??示
                int offset = itemWidth / 4;
                Rect targetRect = new Rect(getScrollBarX(), Y - DisplayUtil.dip2px(getContext(), 24)
                        , getScrollBarX() + offset, Y - DisplayUtil.dip2px(getContext(), 4));
                Paint.FontMetricsInt fontMetrics = textLinePaint.getFontMetricsInt();
                int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                textLinePaint.setTextAlign(Paint.Align.LEFT);
                if (ContentUtil.APP_SETTING_UNIT.equals("hua")) {
                    tmp = String.valueOf(TransUnitUtil.getF(tmp));
                }
                canvas.drawText(tmp + "°", targetRect.centerX(), baseline, textLinePaint);
            }
        }
    }

