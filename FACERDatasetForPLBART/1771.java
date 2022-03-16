	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
		String str = getItem(position);   
		
		ViewHolder viewHolder;
		
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(res_id, parent, false);
          
          viewHolder = new ViewHolder();
          viewHolder.message = (TextView) convertView;
          convertView.setTag(viewHolder);
       } else {
    	   //if it was already reused 
           viewHolder = (ViewHolder) convertView.getTag();
       }
       // Populate the data into the template view using the data object
       viewHolder.message.setText(str);
       
       if (str.startsWith("Me:  ")){
    	   viewHolder.message.setTextColor(0xFF0099CC);
    	   if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
    		   viewHolder.message.setGravity(Gravity.RIGHT);
       }
       else{
    	   viewHolder.message.setTextColor(0xFF15B72E);
    	   if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
    		   viewHolder.message.setGravity(Gravity.LEFT);
       }
       
       // Return the completed view to render on screen
       return convertView;
   }

