  public ElasticDragDismissFrameLayout(Context context, AttributeSet attrs,
                                       int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    this.context = context;
    final TypedArray a = getContext().obtainStyledAttributes(
        attrs, R.styleable.ElasticDragDismissFrameLayout, 0, 0);

    if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragDismissDistance)) {
      dragDismissDistance = a.getDimensionPixelSize(R.styleable
          .ElasticDragDismissFrameLayout_dragDismissDistance, 0);
    } else if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragDismissFraction)) {
      dragDismissFraction = a.getFloat(R.styleable
          .ElasticDragDismissFrameLayout_dragDismissFraction, dragDismissFraction);
    }
    if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragDismissScale)) {
      dragDismissScale = a.getFloat(R.styleable
          .ElasticDragDismissFrameLayout_dragDismissScale, dragDismissScale);
      shouldScale = dragDismissScale != 1f;
    }
    if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragElasticity)) {
      dragElacticity = a.getFloat(R.styleable.ElasticDragDismissFrameLayout_dragElasticity,
          dragElacticity);
    }
    a.recycle();
  }

