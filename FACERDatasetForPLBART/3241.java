    public static void openFile(Activity activity, FileManagerDisk fm, File f) {
        if(f!=null) {

                if(Files.isImage(f.getName())) {

					//boolean hitfile=false;
					int usepos=0;
					List<FileItem> useitems = new ArrayList<FileItem>();

					for(int i=0; i<fm.getDirectory(activity).size(); i++) {
						File testFile =fm.getDirectoryItem(i);
						if(!Files.isImage(Files.removeBriefFileExtension(testFile.getName()))) {

						} else {
							useitems.add(fm.getDirectoryItem(i));

						}
						if(f.getName().equals(testFile.getName())) {

							usepos=useitems.size()-1;
						}
					}


					FileManagerList fml = new FileManagerList(useitems);
					fml.setStartAtPosition(usepos);
					State.addCachedFileManager(fml);

					Bgo.openFragmentBackStack(activity,new ImagesSliderFragment());

                } else if(State.getFileExploreState()==State.FILE_EXPLORE_STATE_STANDALONE) {
                    //openOptions(f.getAbsolutePath());
                    Device.openAndroidFile(activity, f);
                } else {

                    JSONArray jarr = new JSONArray();
                    jarr.put(f.getAbsolutePath());
                    //State.clearStateObjects(State.getPreviousSection());
                    Log.e("FEF", "back to: " + State.getPreviousSection() + " -- with--" + jarr.toString());
                    State.addToState(State.SECTION_FILE_EXPLORE,new StateObject(StateObject.STRING_FILE_PATH,jarr.toString()));
                    Bgo.goPreviousFragment(activity);
                }

        }
    }

