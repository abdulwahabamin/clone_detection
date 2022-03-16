    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citymanagement_activity_layout);
        mListData=new ArrayList<>();
        activity_flag=false;
        wnl_spf =getSharedPreferences("WanNianLi",MODE_PRIVATE);
        initAdapterData();
        initWidgets();

    }

