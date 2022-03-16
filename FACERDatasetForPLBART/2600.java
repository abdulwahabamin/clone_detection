     /** Called when the activity is first created. */ 
     @Override 
     public void onCreate(Bundle icicle) { 
          super.onCreate(icicle);

          mDistribution.setFirst(MENU_DISTRIBUTION_START, DIALOG_DISTRIBUTION_START);

          // Check whether EULA has been accepted
          // or information about new version can be presented.
          /*
          if (mDistribution.showEulaOrNewVersion()) {
              return;
          }
          */

          currentHandler = new Handler() {
			public void handleMessage(Message msg) {
				FileManagerActivity.this.handleMessage(msg);
			}
		};

		  requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
          setContentView(R.layout.filelist);
          
          mEmptyText = (TextView) findViewById(R.id.empty_text);
          mProgressBar = (ProgressBar) findViewById(R.id.scan_progress);

		  getListView().setOnCreateContextMenuListener(this);
		  getListView().setEmptyView(findViewById(R.id.empty));
	      getListView().setTextFilterEnabled(true);
	      getListView().requestFocus();
	      getListView().requestFocusFromTouch();
	      
          mDirectoryButtons = (LinearLayout) findViewById(R.id.directory_buttons);
          mEditFilename = (EditText) findViewById(R.id.filename);
          

          mButtonPick = (Button) findViewById(R.id.button_pick);
          
          mButtonPick.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					pickFileOrDirectory();
				}
          });
          
          // Initialize only when necessary:
          mDirectoryInput = null;
          
          // Create map of extensions:
          getMimeTypes();
          
          getSdCardPath();
          
          mState = STATE_BROWSE;
          
          Intent intent = getIntent();
          String action = intent.getAction();
          
          File browseto = new File("/");
          
          if (!TextUtils.isEmpty(mSdCardPath)) {
        	  browseto = new File(mSdCardPath);
          }
          
          // Default state
          mState = STATE_BROWSE;
          mWritableOnly = false;
          
          if (action != null) {
        	  if (action.equals(FileManagerIntents.ACTION_PICK_FILE)) {
        		  mState = STATE_PICK_FILE;
        	  } else if (action.equals(FileManagerIntents.ACTION_PICK_DIRECTORY)) {
        		  mState = STATE_PICK_DIRECTORY;
        		  mWritableOnly = intent.getBooleanExtra(FileManagerIntents.EXTRA_WRITEABLE_ONLY, false);
        		  
        		  // Remove edit text and make button fill whole line
        		  mEditFilename.setVisibility(View.GONE);
        		  mButtonPick.setLayoutParams(new LinearLayout.LayoutParams(
        				  LinearLayout.LayoutParams.FILL_PARENT,
        				  LinearLayout.LayoutParams.WRAP_CONTENT));
        	  } else if (action.equals(Intent.ACTION_CREATE_SHORTCUT)) {
        		  mState = STATE_CREATE_SHORTCUT;
        	  }
          }
          
          if (mState == STATE_BROWSE) {
        	  // Remove edit text and button.
        	  mEditFilename.setVisibility(View.GONE);
        	  mButtonPick.setVisibility(View.GONE);
          }

          // Set current directory and file based on intent data.
    	  File file = FileUtils.getFile(intent.getData());
    	  if (file != null) {
    		  File dir = FileUtils.getPathWithoutFilename(file);
    		  if (dir.isDirectory()) {
    			  browseto = dir;
    		  }
    		  if (!file.isDirectory()) {
    			  mEditFilename.setText(file.getName());
    		  }
    	  }
    	  
    	  String title = intent.getStringExtra(FileManagerIntents.EXTRA_TITLE);
    	  if (title != null) {
    		  setTitle(title);
    	  }

    	  String buttontext = intent.getStringExtra(FileManagerIntents.EXTRA_BUTTON_TEXT);
    	  if (buttontext != null) {
    		  mButtonPick.setText(buttontext);
    	  }
    	  
          mStepsBack = 0;
          
          if (icicle != null) {
        	  browseto = new File(icicle.getString(BUNDLE_CURRENT_DIRECTORY));
        	  mContextFile = new File(icicle.getString(BUNDLE_CONTEXT_FILE));
        	  mContextText = icicle.getString(BUNDLE_CONTEXT_TEXT);
        	  
        	  boolean show = icicle.getBoolean(BUNDLE_SHOW_DIRECTORY_INPUT);
        	  showDirectoryInput(show);
        	  
        	  mStepsBack = icicle.getInt(BUNDLE_STEPS_BACK);
          }
          
          browseTo(browseto);
     }

