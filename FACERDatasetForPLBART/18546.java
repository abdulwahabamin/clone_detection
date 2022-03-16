        public View getView(final int position, View convertView, ViewGroup parent){

    		View v = convertView;

    		if (v == null) {
    			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    			v = inflater.inflate(R.layout.customize_screens_listview_layout, null);
    		}
    		
    		screenTitle = (TextView) v.findViewById(R.id.customize_screens_title);

    		screenTitle.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
    		screenTitle.setPaintFlags(screenTitle.getPaintFlags()
    										 | Paint.ANTI_ALIAS_FLAG
    										 | Paint.SUBPIXEL_TEXT_FLAG);		
    		
    		screenTitle.setText(mScreensList.get(position));
    		
    		return v;

    	}

