    /**
     * 构造方法传入布局方�?�，�?�?��?传
     * @param context context
     * @param orientation 方�?�
     */
    public DividerItemDecoration(Context context, int orientation) {
        this.mOrientation = orientation;
        if(orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL){
            throw new IllegalArgumentException("请传入正确的�?�数") ;
        }
        mItemSize = (int) TypedValue.applyDimension(mItemSize, TypedValue.COMPLEX_UNIT_DIP,context.getResources().getDisplayMetrics());
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG) ;
        mPaint.setColor(ContextCompat.getColor(context, R.color.maincolor));
         /*设置填充*/
        mPaint.setStyle(Paint.Style.FILL);
    }

