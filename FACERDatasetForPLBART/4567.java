		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {


			File f = fm.getDirectoryItemAsFile(position);
            //BLog.e("OPEN FILES !!!!: "+f.getName());
			if(f!=null) {
				State.setFolderPosition(fm.getCurrentDirectory().getAbsolutePath(), list.getFirstVisiblePosition());
				if(f.isDirectory()) {

					boolean ok=fm.setCurrentDirectory(activity, f.getAbsolutePath());
					if(ok) {
						refreshData();
						title.setText(f.getName());
						path.setText(f.getAbsolutePath());
						info.setText("" + fm.getCurrentDirectoryCount());
						files.setText("" + fm.getCurrentFileCount());
						setColors();
					} else {
						Toast.makeText(activity,"Cannot read directory, insufficient permissions",Toast.LENGTH_SHORT);
					}
					//adapter.notifyDataSetChanged();
					
				} else if(f.isFile()) {
					String fname=Files.removeBriefFileExtension(f.getName());
					if(Files.isImage(fname)) {

						//FileManager fm = new FileManager();
						//fm.setCurrentDirectory(activity,f.getParentFile().getAbsolutePath());
						//fm.readDirectory(activity);
						int usepos=position;
                        List<FileItem> useitems = new ArrayList<FileItem>();

							for(int i=0; i<fm.getDirectory(activity).size(); i++) {

								if(!Files.isImage(Files.removeBriefFileExtension(fm.getDirectoryItem(i).getName()))) {
                                    if(i<position)
                                        usepos--;
                                } else
                                    useitems.add(fm.getDirectoryItem(i));
							}


                        FileManagerList fml = new FileManagerList(useitems);
                        fml.setStartAtPosition(usepos);
                        State.addCachedFileManager(fml);

						Bgo.openFragmentBackStack(activity,new ImagesSliderFragment());

					} else if(Files.isTextFile(f.getName())) {

						State.addCachedFileManager(fm);
                        State.addToState(State.SECTION_TEXT_FILE_VIEW,new StateObject(StateObject.STRING_FILE_PATH,fm.getDirectoryItem(position).getAbsolutePath()));
						Bgo.openFragmentBackStack(activity,new TextFileFragment());

					} else {
						//openOptions(f.getAbsolutePath());
						if(fname.endsWith(".zip")) {

							FileManagerZip fmz = new FileManagerZip(f.getAbsolutePath());
							State.addCachedFileManager(fmz);
							Bgo.openFragmentBackStack(activity, new ZipExploreFragment());

						} else {
							Device.openAndroidFile(activity, f);
						}
					}
				}
			}
			
			
		}

