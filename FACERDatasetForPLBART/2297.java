     public IconifiedTextView(Context context, IconifiedText aIconifiedText) { 
          super(context); 
		
		// inflate rating
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		inflater.inflate(
				R.layout.filelist_item, this, true);
		
		mIcon = (ImageView) findViewById(R.id.icon);
		mText = (TextView) findViewById(R.id.text);
		mInfo = (TextView) findViewById(R.id.info);
     } 

