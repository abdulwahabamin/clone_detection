    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int result;
        //通过MeasureSpec.getMode与getSize方法获�?�宽和高的测�?方�?与测�?大�?
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //�?存最�?�的测�?值，优化代�?的�?�?�以�?用这个�?��?的。
        int width = 0, height = 0;
        //对测�?模�?进行判断，如果是EXACTLY的�?则最�?�的测�?值就是系统帮我们测�?的结果。
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            //如果是UNSPECIFIED 则使用我们的默认值作为最�?�的测�?值
            result = 300;
            //如果是AT_MOST 则就�?用系统测�?结果与我们默认结果�?�最�?值�?�决定最�?�的测�?结果
            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(result, widthSize);
            }
        }
        //高度和宽度的过程是一致的。
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            result = 300;
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(result, heightSize);
            }
        }
        //把我们最�?�的宽和高设置进去
        viewHeight = height;
        viewWidth = width;
        setMeasuredDimension(width, height);
    }

