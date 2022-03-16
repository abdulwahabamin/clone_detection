	    @Override
	    public View getView(final int position, View view, ViewGroup parent) {
	        ViewHolder holder;
	    	//view = inflater.inflate(android.R.layout.simple_list_item_1, null);
	        //LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        if (view == null) {
	        	view = inflater.inflate(R.layout.file_explore_list_item_zip, null);

	            //convertView = inflater.inflate(R.layout.list_item, null);
	            holder = new ViewHolder();
                holder.view=view;
	            holder.title = (TextView) view.findViewById(R.id.explore_item_head);
	            holder.selectBox = (ImageView) view.findViewById(R.id.explore_file_type);
	            holder.data = (TextView) view.findViewById(R.id.explore_item_size);
                //holder.date = (TextView) view.findViewById(R.id.explore_item_date);

                holder.subpath=(TextView) view.findViewById(R.id.zip_subpath);
	            view.setTag(holder);

	        }
	 
	        holder = (ViewHolder) view.getTag();

			FileItemZip item= files.get(position);

            if(item.subpath.length()>1)
                holder.view.setPadding(40,0,0,0);
            else
                holder.view.setPadding(0,0,0,0);
            CheckHolder chkhold= new CheckHolder();
            chkhold.position= Integer.valueOf(position);


            holder.subpath.setText(item.subpath);

	        holder.title.setText(item.file);
	        holder.selectBox.setTag(chkhold);
			//Log.e("SIZE",item.getAbsolutePath()+" = "+item.length());
			String size = Num.btyesToFileSizeString(item.length());
			if(item.PARENT_TYPE_==FileItem.PARENT_TYPE_ZIP)
				size=Num.btyesToFileSizeString(item.zipFileSize);
	        holder.data.setText(size);
            //holder.date.setText(Cal.getCal(item.lastModified()).getDatabaseDate());



	        //} else {
			holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));
	       // }

			view.setBackgroundColor(activity.getResources().getColor(R.color.transparent));


	        return view;
	 
	    }

