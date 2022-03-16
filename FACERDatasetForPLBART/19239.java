	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		mContext = getActivity().getApplicationContext();
		mApp = (Common) mContext;
		View rootView = getActivity().getLayoutInflater().inflate(R.layout.fragment_folders_selection, null);
		mMusicFolders = new HashMap<String, Boolean>();

        mFoldersListView = (ListView) rootView.findViewById(R.id.folders_list_view);
        mFoldersListView.setFastScrollEnabled(true);
        mWelcomeSetup = getArguments().getBoolean("com.aniruddhc.acemusic.player.WELCOME");

        mUpLayout = (RelativeLayout) rootView.findViewById(R.id.folders_up_layout);
        mUpIcon = (ImageView) rootView.findViewById(R.id.folders_up_icon);
        mUpText = (TextView) rootView.findViewById(R.id.folders_up_text);
        mCurrentFolderText = (TextView) rootView.findViewById(R.id.folders_current_directory_text);

        mUpText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mCurrentFolderText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

        mUpLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    getDir(new File(mCurrentDir).getParentFile().getCanonicalPath());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

        if (mWelcomeSetup) {
            mFoldersListView.setDivider(getResources().getDrawable(R.drawable.icon_list_divider_light));
            mUpIcon.setImageResource(R.drawable.up);
        } else {
            mUpIcon.setImageResource(UIElementsHelper.getIcon(mContext, "up"));

            if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                mUpIcon.setImageResource(R.drawable.icon_list_divider_light);
            } else {
                mUpIcon.setImageResource(R.drawable.icon_list_divider);
            }

        }

		mFoldersListView.setDividerHeight(1);
		mRootDir = Environment.getExternalStorageDirectory().getAbsolutePath().toString();
		mCurrentDir = mRootDir;

        //Get a mCursor with a list of all the current folder paths (will be empty if this is the first run).
		mCursor = mApp.getDBAccessHelper().getAllMusicFolderPaths();
        
		//Get a list of all the paths that are currently stored in the DB.
		for (int i=0; i < mCursor.getCount(); i++) {
			mCursor.moveToPosition(i);
			
			//Filter out any double slashes.
			String path = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.FOLDER_PATH));
			if (path.contains("//")) {
				path.replace("//", "/");
			}

			mMusicFolders.put(path, true);
		}
		
		//Close the cursor.
        if (mCursor!=null)
		    mCursor.close();
		
		//Get the folder hierarchy of the selected folder.
        getDir(mRootDir);
        
        mFoldersListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
				String newPath = mFileFolderPathsList.get(index);
				getDir(newPath);
				
			}
        	
        });
        
        return rootView;
    }

