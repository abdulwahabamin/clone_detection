    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTheme();
        setContentView(getLayoutId());
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        setmScreenWidth(metric.widthPixels);
        setmScreenHeight(metric.heightPixels);
        mDensity = metric.density;
        initData();
        initView();
        initEvent();
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

    }

