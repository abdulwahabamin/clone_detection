    private void setWindowSize() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        viewWidth = size.x;
        viewHeight = size.y;


        if(viewWidth>viewHeight)
            isPortrait=false;
        else
            isPortrait=true;

        if(bmpWidth>bmpHeight)
            isPortraitImage=false;
        else
            isPortraitImage=true;

        //borderWidth = (int) borderPaint.getStrokeWidth();
        mScaleFactor = Math.min((viewWidth - borderWidth)
                / bmpWidth, (viewHeight - borderWidth)
                / bmpHeight);

        mScaleFactor = Math.max(minScale, mScaleFactor);
        mScaleFactor = Math.min(maxScale, mScaleFactor);

        if(isPortrait && !isPortraitImage) {
            mScaleFactor=mScaleFactor*1.4f;
        } else if(!isPortrait && isPortraitImage) {
            mScaleFactor=mScaleFactor*1.4f;
        }
        //BLog.e("firsttime scalefactor: : " + mScaleFactor);

        pivotPointX = ((viewWidth - borderWidth) - (int) (bmpWidth * mScaleFactor)) / 2;
        pivotPointY = ((viewHeight - borderWidth) - (int) (bmpHeight * mScaleFactor)) / 2;

        fixTrans();
        //pivotPointY=-pivotPointY;
        mPosX=pivotPointX;
        mPosY=-(pivotPointY/4);
        //if((isPortraitImage&&isPortrait)||(!isPortraitImage&&!isPortrait))
        //    mPosY=-((pivotPointY/2)+(pivotPointY/4));

        //float scaleX = viewWidth / (float) bmpWidth;
        //float scaleY = viewHeight / (float) bmpHeight;

        //float scale = Math.min(scaleX, scaleY);





        scaleStart=mScaleFactor;
        pivotPointYstart=pivotPointY;
        pivotPointXstart=pivotPointX;
        mPosYstart=mPosY;
        mPosXstart=mPosX;

        //BLog.e("BEGIN --- SF: " + mPosX + ", PPX: " + mPosY + ", PPY: " + pivotPointY);
        //fixTrans();
        //matrix.setScale(scale, scale);
        //BLog.e("START --- SF: " + mScaleFactor + ", PPX: " + pivotPointX + ", PPY: " + pivotPointY);
        //matrix.setScale(mScaleFactor, mScaleFactor);
        //fixTrans();

    }

