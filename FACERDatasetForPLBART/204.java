    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);

        initPreData();

        bindView();

        initView();

        setListener();

        registerReceiver();

        initData();
    }

