    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth=getWidth();
        viewHeight=getHeight();
        spaceHeightWidth();

        Paint.FontMetrics fontMetrics=mTextPaint.getFontMetrics();
        float fontHeight=fontMetrics.bottom-fontMetrics.top;

        for(int i=0;i<mTopTemp.size();i++){
            float _hTop=(maxTemp-mTopTemp.get(i))*mSpace + 65*pxScale/3;
            if(i<mTopTemp.size()-1){
                canvas.drawLine(tmpArray[i],_hTop,tmpArray[i+1],(maxTemp-mTopTemp.get(i+1))*mSpace+65*pxScale/3,mLinePaint);
            }

            canvas.drawText(mTopTemp.get(i)+"°",tmpArray[i],_hTop-3*fontHeight/8,mTextPaint);
            canvas.drawCircle(tmpArray[i],_hTop,10*pxScale/3,mPoint1Paint);
        }

        for(int i=0;i<mLowTemp.size();i++){
            float _hLow=(maxTemp-mLowTemp.get(i))*mSpace + 65*pxScale/3;
            if(i<mTopTemp.size()-1){
                canvas.drawLine(tmpArray[i],_hLow,tmpArray[i+1],(maxTemp-mLowTemp.get(i+1))*mSpace+65*pxScale/3,mLinePaint);
            }

            canvas.drawText(mLowTemp.get(i)+"°",tmpArray[i],_hLow+fontHeight,mTextPaint);
            canvas.drawCircle(tmpArray[i],_hLow,10*pxScale/3,mPoint2Paint);
        }
    }

