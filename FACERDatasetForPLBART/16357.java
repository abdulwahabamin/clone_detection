    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        getP();
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            bindUI(null);
        }
        BaseApplication.getInstance().addActivity(this);
        initView(savedInstanceState);
        initData();
    }

