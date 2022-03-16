    /**
     * Constructor of <code>NavigationView</code>.
     *
     * @param context The current context
     * @param attrs The attributes of the XML tag that is inflating the view.
     */
    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Navigable);
        try {
            init(a);
        } finally {
            a.recycle();
        }
    }

