	    @Override
	    public View getView(final int position, View view, ViewGroup parent) {
	        ViewHolder holder;
	    	//view = inflater.inflate(android.R.layout.simple_list_item_1, null);
	        //LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        if (view == null) {
	        	view = inflater.inflate(R.layout.file_explore_list_item, null);
	            //convertView = inflater.inflate(R.layout.list_item, null);
	            holder = new ViewHolder();
	            holder.title = (TextView) view.findViewById(R.id.explore_item_head);
	            holder.selectBox = (ImageView) view.findViewById(R.id.explore_file_type);
	            holder.data = (TextView) view.findViewById(R.id.explore_item_size);
                holder.date = (TextView) view.findViewById(R.id.explore_item_date);
                holder.check=(ImageView) view.findViewById(R.id.file_explore_check);
	            view.setTag(holder);

	        }
	 
	        holder = (ViewHolder) view.getTag();



			//TextView textView = (TextView) view.findViewById(R.id.explore_item_head);
			//ImageView img = (ImageView) view.findViewById(R.id.explore_file_type);

			// put the image on the text view
			FileItem item= files.get(position);

			if(item!=null) {
				CheckHolder chkhold = new CheckHolder();
				chkhold.position = Integer.valueOf(position);
				chkhold.check = holder.check;

				//holder.title.setCompoundDrawablesWithIntrinsicBounds(item.icon, 0, 0, 0);
				holder.title.setText(item.file);
				holder.selectBox.setTag(chkhold);
				//Log.e("SIZE",item.getAbsolutePath()+" = "+item.length());
				String size = Num.btyesToFileSizeString(item.length());
				if (item.PARENT_TYPE_ == FileItem.PARENT_TYPE_ZIP)
					size = Num.btyesToFileSizeString(item.zipFileSize);
				holder.data.setText(size);
				holder.date.setText(Cal.getCal(item.lastModified()).getDatabaseDate());
				//if(item.icon==Files.F_DIR) {
				//	holder.selectBox.setVisibility(View.GONE);
				//} else {
				if (isMultiSelect) {
					holder.selectBox.setVisibility(View.VISIBLE);
					holder.selectBox.setClickable(true);
					if (item.getAbsoluteFile() == null || item.getAbsoluteFile().isDirectory())
						holder.check.setVisibility(View.GONE);
					else
						holder.check.setVisibility(View.VISIBLE);
					holder.selectBox.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {

							CheckHolder chk = (CheckHolder) v.getTag();
							FileItem f = fm.getDirectoryItem(chk.position.intValue());
							//ImageView img = (ImageView) v.getTag();
							//BLog.e("SEL", "view tag: " + v.getTag().toString() +"--"+Integer.valueOf(v.getTag().toString()).intValue()+ "--" + f.getName());
							if (f != null && !f.getAbsoluteFile().isDirectory()) {
								if (fm.getSelectedFiles().get(f.getAbsolutePath()) != null) {


									chk.check.setImageDrawable(activity.getResources().getDrawable(R.drawable.s_checkon));
									//BLog.e("REM",f.getAbsolutePath());
									fm.removeSelectedFile(f);
									setAnimListners(f);
									notifyDataSetChanged();
									if (fm.getSelectedFiles().isEmpty()) {
										if (fileSelectedActionSelecter.mMode != null)
											fileSelectedActionSelecter.mMode.finish();
									} else {
										if (fileSelectedActionSelecter.mMode != null)
											fileSelectedActionSelecter.mMode.setTitle(fm.getSelectedFiles().size() + "");
									}


								} else {
									fm.addSelectedFile(f);
									//File fi=new File(f.file);
									//if(fi.exists() && !fi.isDirectory()) {
									if (!fm.getSelectedFiles().isEmpty()) {
										if (!fileSelectedActionSelecter.isActionModeShowing) {
											fileSelectedActionSelecter.mMode = ((AppCompatActivity) activity).startSupportActionMode(fileSelectedActionSelecter);
											fileSelectedActionSelecter.isActionModeShowing = true;
										}
									} else if (fileSelectedActionSelecter.mMode != null) {
										fileSelectedActionSelecter.mMode.finish();
										fileSelectedActionSelecter.isActionModeShowing = false;
									}

									// Set action mode title
									if (fileSelectedActionSelecter.mMode != null)
										fileSelectedActionSelecter.mMode.setTitle(fm.getSelectedFiles().size() + "");

									notifyDataSetChanged();
								}
							}
						}

					});
				} else {
					holder.check.setVisibility(View.GONE);
				}

				//holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));

				//if(item.file.endsWith(".jpg")) {
				//	holder.selectBox.setImageDrawable(item);
				//} else {
				holder.selectBox.setImageDrawable(activity.getResources().getDrawable(item.icon));
				// }
				//BLog.e("DISPO",item.getAbsolutePath());
				if (fm.getSelectedFiles().get(item.getAbsolutePath()) != null) {
					//holder.selectBox.setImageResource(R.drawable.cb_checked);
					view.setBackgroundColor(activity.getResources().getColor(R.color.browse_brand_alpha50));
					holder.check.setImageDrawable(activity.getResources().getDrawable(R.drawable.s_checkon));
					//holder.selectBox.setBackgroundResource(R.drawable.navigation_accept);

				} else {
					//holder.selectBox.setImageResource(R.drawable.cb_unchecked);
					view.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
					holder.check.setImageDrawable(activity.getResources().getDrawable(R.drawable.s_checkoff));
					//holder.selectBox.setBackgroundResource(R.drawable.navigation_cancel);

				}
				ImageView showInfo = (ImageView) view.findViewById(R.id.file_info);
				InfoClicker info = new InfoClicker(activity, item);
				//info.pos=position;
				showInfo.setOnClickListener(info);
			}
	        return view;
	 
	    }

