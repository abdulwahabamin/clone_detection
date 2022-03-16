    public StorageChooserViewHolder(View v){
        super(v);
        icon=v.findViewById(com.singh.multimeet.quicxplo.R.id.icon);
        title=v.findViewById(com.singh.multimeet.quicxplo.R.id.title);
        path=v.findViewById(com.singh.multimeet.quicxplo.R.id.path);
        constraintLayout=(ConstraintLayout) v;
        setTypeFace();
    }

