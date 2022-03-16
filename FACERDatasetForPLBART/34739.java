    private Bitmap getDescBitmap(){

        int l = (width - 7 * DisplayUtil.sp2px(MyApplication.getAppContext(),50)) / 2;
        Bitmap descBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvasTemp = new Canvas(descBitmap);
        int [] easyPosition = {width / 2 , height / 2 - getPx(8.0)};
        int [] weatherPosition = {width / 2 ,  height / 2 + getPx(42.0)};
//        int [] easyPosition = {l, height / 2 - getPx(8.0)};
//        int [] weatherPosition = {l,  height / 2 + getPx(42.0)};
        canvasTemp.drawText("Eaaaasy",easyPosition[0],easyPosition[1],mPaint);
        canvasTemp.drawText("Weather",weatherPosition[0],weatherPosition[1],mPaint);
        return descBitmap;
    }

