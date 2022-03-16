	    public FileExploreAdapterZip(Activity a, FileManagerZip filemanager) {
	        activity = a;

			this.fm=filemanager;
			buildList();
	        //this.data=data;
	        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


	    }

