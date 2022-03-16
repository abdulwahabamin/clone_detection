    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        //é€?æ˜ŽçŠ¶æ€?æ ?
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        viewPager = findViewById(R.id.view_pager);
        llRound = findViewById(R.id.ll_round);
        tvLocation = findViewById(R.id.tv_location);
        ivLoc = findViewById(R.id.iv_loc);
        ivBack = findViewById(R.id.iv_main_back);
        RelativeLayout rvTitle = findViewById(R.id.rv_title);
        initFragments(true);
        ImageView ivSet = findViewById(R.id.iv_set);
        ImageView ivAdd = findViewById(R.id.iv_add_city);
        ivSet.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        setMargins(viewPager, 0, getStatusBarHeight(this) + DisplayUtil.dip2px(this, 52), 0, 0);
        setMargins(rvTitle, 0, getStatusBarHeight(this), 0, 0);

    }

