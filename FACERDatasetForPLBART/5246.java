    public MediaViewHolder(View v){
        super(v);
        thumbnail=v.findViewById(R.id.thumbnail);
        name=v.findViewById(R.id.name);
        constraintLayout=(LinearLayout) v;
        setTypeFace();
    }

