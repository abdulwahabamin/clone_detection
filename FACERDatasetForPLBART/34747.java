    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int translateLength = (viewWidth - 2 * padding) / 7;
        textPaint.setTextSize(translateLength / 4);
        lowTempPaint.setTextSize(translateLength / 4);
        highTempPaint.setTextSize(translateLength / 4);

        //画水平基准线
        canvas.drawLine(padding,
                viewHeight - padding,
                viewWidth - padding,
                viewHeight - padding,
                baseLinePaint);

        //画竖直基准线
        for (int i = 1; i < 7; i++) {
            canvas.save();
            canvas.translate(translateLength * i, 0);
            dPath.moveTo(padding,
                    viewHeight - padding - 10);
            dPath.lineTo(padding,
                    padding);
            canvas.drawPath(dPath, verticalLinePaint);
            canvas.restore();
        }
        if (weeks[0] == null) return;
        //画日期
        for (int i = 0; i < weeks.length; i++) {
            canvas.save();
            canvas.translate(translateLength * i, 0);
            canvas.drawText(weeks[i], padding + translateLength / 2, 4 * textPadding, textPaint);
            canvas.drawText(weekWeathers.get(i).getCond(), padding + translateLength / 2, 6 * textPadding,textPaint);
            canvas.restore();
        }


        int lowestTemp = IntegerUtils.getSmallestNum(lists);

        for (int i = 0; i < weekWeathers.size(); i++) {
            int lowDiff = weekWeathers.get(i).getLowTemp() - lowestTemp;
            int diff = weekWeathers.get(i).getHighTemp() - weekWeathers.get(i).getLowTemp();
            lowTempX[i] = padding + translateLength / 2 + translateLength * i;
            lowTempY[i] = viewHeight - (15 + lowDiff) * tempPadding;
            canvas.drawCircle(lowTempX[i],
                    lowTempY[i],
                    8,
                    lowPointPaint);
            canvas.drawText(weekWeathers.get(i).getLowTemp() + "℃",
                    lowTempX[i],
                    lowTempY[i] + 2 * textPadding,
                    lowTempPaint);

            highTempX[i] = (padding + translateLength / 2 + translateLength * i);
            highTempY[i] = viewHeight - (15 + lowDiff) * tempPadding - tempPadding * diff;
            canvas.drawCircle(highTempX[i],
                    highTempY[i],
                    8,
                    highPointPaint);
            canvas.drawText(weekWeathers.get(i).getHighTemp() + "℃",
                    highTempX[i],
                    highTempY[i] - textPadding,
                    highTempPaint);
        }
        for (int i = 0; i < 6; i++) {
            mPath.reset();
            mPath.moveTo(lowTempX[i] + 8, lowTempY[i]);
            mPath.lineTo(lowTempX[i + 1] - 8, lowTempY[i + 1]);
            canvas.drawPath(mPath, lowLinePaint);
            mPath.rewind();
            mPath.moveTo(highTempX[i] + 8, highTempY[i]);
            mPath.lineTo(highTempX[i + 1] - 8, highTempY[i + 1]);
            canvas.drawPath(mPath, highLinePaint);
        }
    }

