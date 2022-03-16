    private void drawLines(Canvas canvas) {
        //底部的线的高度 高度为控件高度�?去text高度的1.5�?
        baseLineHeight = mHeight - 1.5f * textSize;
        Path path = new Path();
        List<Float> dashWidth = new ArrayList<>();
        List<Float> dashHeight = new ArrayList<>();

        List<Point> mPointList = new ArrayList<>();

        for (int i = 0; i < hourlyWeatherList.size(); i++) {
            float temp = Integer.parseInt(hourlyWeatherList.get(i).getTmp());

            float w = itemWidth * i + paddingL;
            float h = tempHeightPixel(temp) + paddingT;
            Point point = new Point((int) w, (int) h);
            mPointList.add(point);
            //画虚线
            if (dashLineList.contains(i)) {
                dashWidth.add(w);
                dashHeight.add(h);
            }
        }

        float prePreviousPointX = Float.NaN;
        float prePreviousPointY = Float.NaN;
        float previousPointX = Float.NaN;
        float previousPointY = Float.NaN;
        float currentPointX = Float.NaN;
        float currentPointY = Float.NaN;
        float nextPointX;
        float nextPointY;

        for (int valueIndex = 0; valueIndex < hourlyWeatherList.size(); ++valueIndex) {
            if (Float.isNaN(currentPointX)) {
                Point point = mPointList.get(valueIndex);
                currentPointX = point.x;
                currentPointY = point.y;
            }
            if (Float.isNaN(previousPointX)) {
                //是�?�是第一个点
                if (valueIndex > 0) {
                    Point point = mPointList.get(valueIndex - 1);
                    previousPointX = point.x;
                    previousPointY = point.y;
                } else {
                    //是的�?就用当�?点表示上一个点
                    previousPointX = currentPointX;
                    previousPointY = currentPointY;
                }
            }

            if (Float.isNaN(prePreviousPointX)) {
                //是�?�是�?两个点
                if (valueIndex > 1) {
                    Point point = mPointList.get(valueIndex - 2);
                    prePreviousPointX = point.x;
                    prePreviousPointY = point.y;
                } else {
                    //是的�?就用当�?点表示上上个点
                    prePreviousPointX = previousPointX;
                    prePreviousPointY = previousPointY;
                }
            }

            // 判断是�?是最�?�一个点了
            if (valueIndex < hourlyWeatherList.size() - 1) {
                Point point = mPointList.get(valueIndex + 1);
                nextPointX = point.x;
                nextPointY = point.y;
            } else {
                //是的�?就用当�?点表示下一个点
                nextPointX = currentPointX;
                nextPointY = currentPointY;
            }

            if (valueIndex == 0) {
                // 将Path移动到开始点
                path.moveTo(currentPointX, currentPointY);
            } else {
                // 求出控制点�??标
                final float firstDiffX = (currentPointX - prePreviousPointX);
                final float firstDiffY = (currentPointY - prePreviousPointY);
                final float secondDiffX = (nextPointX - previousPointX);
                final float secondDiffY = (nextPointY - previousPointY);
                final float firstControlPointX = previousPointX + (0.2F * firstDiffX);
                final float firstControlPointY = previousPointY + (0.2F * firstDiffY);
                final float secondControlPointX = currentPointX - (0.2F * secondDiffX);
                final float secondControlPointY = currentPointY - (0.2F * secondDiffY);
                //画出曲线
                path.cubicTo(firstControlPointX, firstControlPointY, secondControlPointX, secondControlPointY,
                        currentPointX, currentPointY);
            }

            // 更新值,
            prePreviousPointX = previousPointX;
            prePreviousPointY = previousPointY;
            previousPointX = currentPointX;
            previousPointY = currentPointY;
            currentPointX = nextPointX;
            currentPointY = nextPointY;
        }

        //画折线
        canvas.drawPath(path, foldLinePaint);

        path.lineTo(mWidth - paddingR, baseLineHeight);
        path.lineTo(paddingL, baseLineHeight);
        //画阴影
        int[] shadeColors = new int[]{
                Color.argb(100, 145, 145, 145), Color.argb(30, 145, 145, 145),
                Color.argb(18, 237, 238, 240)};

        Shader mShader = new LinearGradient(0, 0, 0, getHeight(), shadeColors, null, Shader.TileMode.CLAMP);

        backPaint.setShader(mShader);
        canvas.drawPath(path, backPaint);

        //画虚线
        drawDashLine(dashWidth, dashHeight, canvas);

        for (int i = 0; i < hourlyWeatherList.size(); i++) {
            float temp = Integer.parseInt(hourlyWeatherList.get(i).getTmp());

            float w = itemWidth * i + paddingL;
            float h = tempHeightPixel(temp) + paddingT;

            //画时间
            String time = hourlyWeatherList.get(i).getTime();
            //画时间
            if (ITEM_SIZE > 8){
                if (i % 2 == 0) {
                    if (i == 0) {
                        textPaint.setTextAlign(Paint.Align.LEFT);
                    } else {
                        textPaint.setTextAlign(Paint.Align.CENTER);
                    }
                    canvas.drawText(time.substring(time.length() - 5), w, baseLineHeight + textSize + DisplayUtil.dip2px(mContext, 3), textPaint);
                }
            }else {
                textPaint.setTextAlign(Paint.Align.CENTER);
                if (i == 0) {
                    canvas.drawText(mContext.getString(R.string.now), w, baseLineHeight + textSize + DisplayUtil.dip2px(mContext, 3), textPaint);
                } else {
                    canvas.drawText(time.substring(time.length() - 5), w, baseLineHeight + textSize + DisplayUtil.dip2px(mContext, 3), textPaint);
                }
            }
        }

    }

