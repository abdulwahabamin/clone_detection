	public FileExploreAdapter(Activity a, FileManager filemanager,boolean isMultiSelect) {
		activity = a;
		this.isMultiSelect=isMultiSelect;
		this.fm=filemanager;
		buildList();
		//this.data=data;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		animation1 = AnimationUtils.loadAnimation(activity, R.anim.to_middle);
		animation2 = AnimationUtils.loadAnimation(activity, R.anim.from_middle);


	}

