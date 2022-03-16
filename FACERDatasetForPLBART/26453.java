    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Router.instance().register(this);
        initBeforeView();
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initViews();
        initDataObserver();
    }

