    public TouchInterceptor(Context context, AttributeSet attrs) {
        super(context, attrs);
        SharedPreferences pref = context.getSharedPreferences("Music", 3);
        mRemoveMode = pref.getInt("deletemode", -1);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

