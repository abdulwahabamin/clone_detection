    private void initDefValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;

        itemWidth = DisplayUtil.dp2px(mContext, 60);

        defWidthPixel = itemWidth * (ITEM_SIZE - 1);
        defHeightPixel = DisplayUtil.dp2px(mContext, 80);

        lowestTempHeight = DisplayUtil.dp2px(mContext, 40);//长度  �?�y轴值
        highestTempHeight = DisplayUtil.dp2px(mContext, 70);
        //defPadding
        paddingT = DisplayUtil.dp2px(mContext, 20);
        paddingL = DisplayUtil.dp2px(mContext, 10);
        paddingR = DisplayUtil.dp2px(mContext, 15);

        textSize = DisplayUtil.sp2px(mContext, 12);


        bitmapHeight = 1 / 2f * (2 * defHeightPixel - lowestTempHeight) + DisplayUtil.dp2px(mContext, 2);//- 给文字留地方
        bitmapXY = 18;

    }

