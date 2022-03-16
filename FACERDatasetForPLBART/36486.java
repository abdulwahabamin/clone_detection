    /**
     * 控件�?始化，构造函数调用
     */
    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        this.setOrientation(LinearLayout.HORIZONTAL);
        //开�?�绘图缓存，�??高绘图效率
        this.setDrawingCacheEnabled(true);

        initPaint();
        initAttrs(attrs);
        fillViewToParent(context);

        this.setWillNotDraw(false);// 确�?onDraw()被调用

        this.paddingTopInXML = this.getPaddingTop();
        this.setPadding(this.getPaddingLeft() + this.marker.getWidth() / 2,
                this.getPaddingTop() + this.marker.getHeight(),
                this.getPaddingRight() + this.marker.getWidth() / 2,
                this.getPaddingBottom());
    }

