    private void drawBitmaps(Canvas canvas) {

        int scrollX = mScrollX;
        boolean leftHide;
        boolean rightHide;
        for (int i = 0; i < dashLineList.size() - 1; i++) {
            leftHide = true;
            rightHide = true;

            int left = itemWidth * dashLineList.get(i) + paddingL;
            int right = itemWidth * dashLineList.get(i + 1) + paddingL;
            //图的中间�?置  drawBitmap是左边开始画
            float drawPoint = 0;
            if (left > scrollX && left < scrollX + screenWidth) {
                leftHide = false;//左边缘显示
            }
            if (right > scrollX && right < scrollX + screenWidth) {
                rightHide = false;
            }


            if (!leftHide && !rightHide) {//左�?�边缘都显示
                drawPoint = (left + right) / 2f;

            } else if (leftHide && !rightHide) {//�?�边缘与�?幕左边

                drawPoint = (scrollX + right) / 2f;
            } else if (!leftHide) {//左边缘与�?幕�?�边
                //rightHide is True when reach this statement
                drawPoint = (left + screenWidth + scrollX) / 2f;

            } else {//左�?�边缘都�?显示
                if (right < scrollX + screenWidth) { //左�?�边缘都在�?幕左边
                    continue;
                } else if (left > scrollX + screenWidth) {//左�?�边缘都在�?幕�?�边
                    continue;
                } else {
                    drawPoint = (screenWidth) / 2f + scrollX;
                }
            }


            String code = hourlyWeatherList.get(dashLineList.get(i)).getCond_code();
            BitmapDrawable bd;


            if (code.contains("d")) {
                bd = (BitmapDrawable) mContext.getResources().getDrawable(IconUtils.getDayIconDark(code.replace("d", "")));
            } else {
                bd = (BitmapDrawable) mContext.getResources().getDrawable(IconUtils.getNightIconDark(code.replace("n", "")));
            }

            assert bd != null;
            Bitmap bitmap = DisplayUtil.bitmapResize(bd.getBitmap(),
                    DisplayUtil.dp2px(mContext, bitmapXY), DisplayUtil.dp2px(mContext, bitmapXY));

            //越界判断
            if (drawPoint >= right - bitmap.getWidth() / 2f) {
                drawPoint = right - bitmap.getWidth() / 2f;
            }
            if (drawPoint <= left + bitmap.getWidth() / 2f) {
                drawPoint = left + bitmap.getWidth() / 2f;
            }

            drawBitmap(canvas, bitmap, drawPoint, bitmapHeight);
//            String text = hourlyWeatherList.get(dashLineList.get(i)).getCond_txt();
//            textPaint.setTextSize(DisplayUtil.sp2px(mContext, 8));
//            canvas.drawText(text, drawPoint, bitmapHeight + bitmap.getHeight() + 100 / 3f, textPaint);

        }

    }

