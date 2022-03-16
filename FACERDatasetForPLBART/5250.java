    public RecentFileViewHolder(View v){
        super(v);
        name=v.findViewById(com.singh.multimeet.quicxplo.R.id.name);
        size=v.findViewById(com.singh.multimeet.quicxplo.R.id.size);
        folder=v.findViewById(com.singh.multimeet.quicxplo.R.id.folder);
        date=v.findViewById(com.singh.multimeet.quicxplo.R.id.date);
        marker=v.findViewById(com.singh.multimeet.quicxplo.R.id.marker);
        icon=v.findViewById(com.singh.multimeet.quicxplo.R.id.icon);
        main=(RelativeLayout)v;
        setTypeFace();
    }

