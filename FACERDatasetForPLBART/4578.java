	    @Override
	    public View getView(final int position, View view, ViewGroup parent) {
	        if (view == null) {
	        	view = inflater.inflate(R.layout.file_explore_list_item, null);

	        }
	        //BLog.e("FESFA","called getViw()");
	        
	        
            TextView title = (TextView) view.findViewById(R.id.explore_item_head);
            ImageView selectBox = (ImageView) view.findViewById(R.id.explore_file_type);
            TextView data = (TextView) view.findViewById(R.id.explore_item_size);
            TextView date = (TextView) view.findViewById(R.id.explore_item_date);
			//TextView textView = (TextView) view.findViewById(R.id.explore_item_head);
			//ImageView img = (ImageView) view.findViewById(R.id.explore_file_type);

			// put the image on the text view
			FileItem item=selectedFiles.get(position);
			//selectBox.setVisibility(View.GONE);
			if(item!=null) {
                selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));
				//title.setCompoundDrawablesWithIntrinsicBounds(item.icon, 0, 0, 0);
				title.setText(item.file);
                data.setText(Num.btyesToFileSizeString(item.length()));
                date.setText(Cal.getCal(item.lastModified()).getDatabaseDate());
				if(stopfileshash.get(item.getAbsolutePath())!=null) {
					view.setBackgroundColor(activity.getResources().getColor(R.color.black_alpha));
				} else {
					view.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
				}
			}


	        return view;
	 
	    }

