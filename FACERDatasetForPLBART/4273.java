        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            IndexerFile ind =Searcher.getResults().get(position);

            if(ind!=null) {
                State.setFolderPosition("searcher", list.getFirstVisiblePosition());
                File f = ind.getAsFileItem().getAbsoluteFile();
                if(f.isFile()) {
                    if(Files.isImage(Files.removeBriefFileExtension(f.getName()))) {
                        FileManagerList fml = new FileManagerList(Searcher.getResultsFileItems());
                        fml.setStartAtPosition(position);
                        State.addCachedFileManager(fml);
                        Bgo.openFragmentBackStack(activity, new ImagesSliderFragment());

                    } else if(Files.isTextFile(f.getName())) {

                        //State.addCachedFileManager(fm);
                        State.addToState(State.SECTION_TEXT_FILE_VIEW,new StateObject(StateObject.STRING_FILE_PATH,ind.getAsFileItem().getAbsolutePath()));
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

