    /**
     * �?始化paint
     */
    private void initPaint() {
        this.paint = new Paint();
        // 设置是�?�使用抗锯齿功能，会消耗较大资�?，绘制图形速度会�?�慢。
        this.paint.setAntiAlias(true);
        // 设定是�?�使用图�?抖动处�?�，会使绘制出�?�的图片颜色更加平滑和饱满，图�?更加清晰
        this.paint.setDither(true);
    }

