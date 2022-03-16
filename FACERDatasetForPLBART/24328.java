    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
       View v = super.newView(context, cursor, parent);
       ViewHolder vh = new ViewHolder();
       vh.line1 = (TextView) v.findViewById(R.id.line1);
       vh.line2 = (TextView) v.findViewById(R.id.line2);
       vh.play_indicator = (ImageView) v.findViewById(R.id.play_indicator);
       v.setTag(vh);
       return v;
    }

