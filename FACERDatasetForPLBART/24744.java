    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler=new Handler();
        mContext =this;
        activity=this;
        picasso =Picasso.with(mContext);
        BindingView();
        Setup();
    }

