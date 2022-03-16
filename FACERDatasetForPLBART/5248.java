    public QuickAccessViewHolder(View v){
        super(v);
        icon=v.findViewById(R.id.icon);
        label=v.findViewById(R.id.label);
        constraintLayout=(CardView) v;
        setTypeFace();
    }

