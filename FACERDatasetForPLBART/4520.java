    void fixTrans() {
        matrix.getValues(m);
        float transX = m[Matrix.MTRANS_X];
        float transY = m[Matrix.MTRANS_Y];



        float fixTransX = getFixTrans(transX, viewWidth, bmpWidth * mScaleFactor);
        float fixTransY = getFixTrans(transY, viewHeight, bmpHeight * mScaleFactor);

        if (fixTransX != 0 || fixTransY != 0)
            matrix.postTranslate(fixTransX, fixTransY);
    }

