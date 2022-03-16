        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            IndexerFile ind =Searcher.getResults().get(position);

            if(ind!=null) {
                File f = ind.getAsFileItem().getAbsoluteFile();
                if(f!=null && f.isFile()) {
					amb.done();
                    if(Files.isImage(f.getName())) {
						FileManagerList fml = new FileManagerList(Searcher.getResultsFileItems());
						fml.setStartAtPosition(position);
						State.addCachedFileManager(fml);
                        Bgo.openFragmentBackStack(activity, new ImagesSliderFragment());

                    } else if(Files.isTextFile(f.getName())) {

						State.addToState(State.SECTION_TEXT_FILE_VIEW,new StateObject(StateObject.STRING_FILE_PATH,f.getAbsolutePath()));
						Bgo.openFragmentBackStack(activity,new TextFileFragment());

					} else {
						//openOptions(f.getAbsolutePath());
						if(Files.removeBriefFileExtension(f.getName()).endsWith(".zip")) {

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

