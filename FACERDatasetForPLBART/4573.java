	    public FileExploreSelectedFilesAdapter(Activity a, FileManagerDisk filemanager) {
	        activity = a;
			fm=filemanager;
	        //this.data=data;
	        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        
	        Iterator<String> it= fm.getSelectedFiles().keySet().iterator();
	        while(it.hasNext()) {
	        	FileItem fi= fm.getSelectedFiles().get(it.next());
	        	if(fi!=null)
	        		selectedFiles.add(fi);
	        }
	    }

