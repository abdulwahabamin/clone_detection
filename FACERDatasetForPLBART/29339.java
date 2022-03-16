    /**
     * initialize the widget
     */
    private void init(Context context){
        header= LayoutInflater.from(context).inflate(R.layout.pull_to_refresh,null,false);
        mProgressBar=(ProgressBar)header.findViewById(R.id.progress_bar);
        arrow=(ImageView)header.findViewById(R.id.arrow);
        description=(TextView)header.findViewById(R.id.description);
        updateAt=(TextView)header.findViewById(R.id.updated_at);
        updateIndicationImage=(ImageView)header.findViewById(R.id.update_indication_image);
        touchSlop= ViewConfiguration.get(context).getScaledTouchSlop();
        setOrientation(VERTICAL);
        addView(header,0);
    }

