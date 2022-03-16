    public FileViewHolder(View v){
        super(v);
        name=v.findViewById(R.id.name);
        icon=v.findViewById(R.id.icon);
        info=v.findViewById(R.id.info);
        size=v.findViewById(R.id.size);
        mainView=v.findViewById(R.id.main_view);
        setTypeFace();
    }

