    public StorageViewHolder(View v){
        super(v);
        used=v.findViewById(com.singh.multimeet.quicxplo.R.id.used);
        total=v.findViewById(com.singh.multimeet.quicxplo.R.id.total);
        free=v.findViewById(com.singh.multimeet.quicxplo.R.id.free);
        label=v.findViewById(com.singh.multimeet.quicxplo.R.id.label);
        percentage=v.findViewById(com.singh.multimeet.quicxplo.R.id.percentage);
        progressBar=v.findViewById(com.singh.multimeet.quicxplo.R.id.progressBar);
        rootView=(CardView) v;
        setTypeFace();
    }

