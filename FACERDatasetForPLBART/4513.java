    private void revertStartValues() {
        float startMid = scaleStart*1.4f;
        float startMax = scaleStart*1.8f;
        if(mScaleFactor>=startMax) {
            mScaleFactor=scaleStart;
        } else if(mScaleFactor>=startMid) {
            mScaleFactor=startMax;
        } else if(mScaleFactor==scaleStart) {
            mScaleFactor=startMid;
        } else {
            mScaleFactor=scaleStart;
        }
        //int borderWidth = (int) borderPaint.getStrokeWidth();
        pivotPointX = ((viewWidth - borderWidth) - (int) (bmpWidth * mScaleFactor)) / 2;
        pivotPointY = ((viewHeight - borderWidth) - (int) (bmpHeight * mScaleFactor)) / 2;
        //pivotPointY=-pivotPointY;
        mPosX=mPosXstart;//pivotPointX;
        mPosY=mPosYstart;//-(pivotPointY/2);
        //if((isPortraitImage&&isPortrait)||(!isPortraitImage&&!isPortrait))
        //    mPosY=-((pivotPointY/2)+(pivotPointY/4));
        //pivotPointY=pivotPointYstart;
        //pivotPointX=pivotPointXstart;
        //mPosY=mPosYstart;
        //mPosX=mPosXstart;
        //mScaleFactor=scaleStart;
    }

