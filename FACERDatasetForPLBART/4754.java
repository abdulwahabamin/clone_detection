	@Override
	public void onResume() {
		super.onResume();
		Fab.hide();

		fm=(FileManagerList)State.getCachedFileManager(FileManagerList.class);
		if(fm==null) {
			//fm = new FileManagerDisk(State.getStateObjectString(State.SECTION_IMAGES_SLIDER, StateObject.STRING_FILE_PATH));
			fm.setStartAtPosition(State.getStateObjectInt(State.SECTION_IMAGES_SLIDER, StateObject.INT_VALUE));
		}
		State.setCurrentSection(State.SECTION_IMAGES_SLIDER);

		imgfiles=fm.getDirectory(activity);
		for(int i=imgfiles.size()-1; i>=0; i--) {
			FileItem imfile= imgfiles.get(i);
			if(!Files.isImage(Files.removeBriefFileExtension(imfile.getName())))
				imgfiles.remove(i);
		}
		WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);



		pager = (ImageSliderPager) view.findViewById(R.id.pager);

		pager.setViewWidth(size.x);
		pager.setOffscreenPageLimit(0);
		pager.setAdapter(new ImageSliderAdapter(activity, imgfiles));

        pager.setCurrentItem(fm.getStartAtPosition());

        btnBack=(ImageView) view.findViewById(R.id.slider_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bgo.goPreviousFragment(activity);
            }
        });

        btnShare=(ImageView) view.findViewById(R.id.slider_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = pager.getCurrentItem();
                File fi = fm.getDirectoryItemAsFile(pos);
                if (fi != null) {
                    //this.done();
                    BriefActivityManager.shareFile(activity, fi.getAbsolutePath());
                }
            }
        });

		refresh();
	}

