    @Override
    public void onNavigationDrawerItemSelected(int position) {

        SearchPacket packet = null;
        String gofilepath=null;

        //ActionModeBack.isActionModeShowing=false;
        //Log.e("Nav", "Nav drawer selection : " + position);
        if(!NavigationDrawerFragment.items.isEmpty()) {

            NavigationDrawerFragment.Holder navitem = NavigationDrawerFragment.items.get(position);
            //Log.e("Nav","Nav drawer selection : "+navitem.Rid);
            switch (navitem.Rid) {
                case R.drawable.nav_btn_txt:
                    packet = new SearchPacket(Files.CAT_TEXTFILE, R.drawable.nav_btn_txt, activity.getString(R.string.text_files));
                    State.addToState(State.SECTION_SEARCH_SHORTCUT, new StateObject(StateObject.STRING_BJSON_OBJECT, packet.toString()));
                    //BLog.e("gofilepath: " + gofilepath);
                    break;
                case R.drawable.nav_btn_videos:
                    packet = new SearchPacket(Files.CAT_VIDEO, R.drawable.nav_btn_videos, activity.getString(R.string.nav_videos));
                    State.addToState(State.SECTION_SEARCH_SHORTCUT, new StateObject(StateObject.STRING_BJSON_OBJECT, packet.toString()));
                    break;
                case R.drawable.nav_btn_images:
                    packet = new SearchPacket(Files.CAT_IMAGE, R.drawable.nav_btn_images, activity.getString(R.string.nav_images));
                    State.addToState(State.SECTION_SEARCH_SHORTCUT, new StateObject(StateObject.STRING_BJSON_OBJECT, packet.toString()));
                    break;
                case R.drawable.nav_btn_download:
                    gofilepath =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
                    if(gofilepath==null) {
                        File f= new File(Files.SDCARD_PATH+File.separator+ Indexer.downloadFolder);
                        if(f.exists()) {
                            gofilepath=f.getAbsolutePath();
                        } else {
                            //BLog.e("gopacket !!!!.......................... ");
                            packet = new SearchPacket(Files.CAT_ANY, R.drawable.nav_btn_download, activity.getString(R.string.useful_folders));
                            State.addToState(State.SECTION_SEARCH_SHORTCUT, new StateObject(StateObject.STRING_BJSON_OBJECT, packet.toString()));
                        }
                    }

                    BLog.e("gofilepath: " + gofilepath);
                    //packet =  new SearchPacket(Files.,"");
                    //State.addToState(State.SECTION_SEARCH_SHORTCUT,new StateObject(StateObject.STRING_BJSON_OBJECT,packet.toString()));
                    break;
                case R.drawable.nav_btn_documents:
                    packet = new SearchPacket(Files.CAT_DOCUMENT, R.drawable.nav_btn_documents, activity.getString(R.string.nav_documents));
                    State.addToState(State.SECTION_SEARCH_SHORTCUT, new StateObject(StateObject.STRING_BJSON_OBJECT, packet.toString()));
                    break;
                case R.drawable.nav_btn_music:
                    packet = new SearchPacket(Files.CAT_SOUND, R.drawable.nav_btn_music, activity.getString(R.string.nav_music));
                    State.addToState(State.SECTION_SEARCH_SHORTCUT, new StateObject(StateObject.STRING_BJSON_OBJECT, packet.toString()));
                    break;
            }
        }
        if(packet!=null)
            Bgo.openFragmentBackStack(activity, new ShortcutSearchFragment());
        if(gofilepath!=null) {
            mNavigationDrawerFragment.closeDrawer();
            //State.clearStateObjects(State.SECTION_FILE_EXPLORE);
            State.addToState(State.SECTION_FILE_EXPLORE, new StateObject(StateObject.STRING_FILE_PATH, gofilepath));
            Bgo.refreshCurrentFragment(activity);
            //Bgo.openFragment(activity, FileExploreFragment.class);
        }
    }

