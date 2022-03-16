     /** Called when the activity is first created. */ 
     @Override 
     public void onCreate(Bundle icicle) { 
          super.onCreate(icicle); 

          mDistribution.setFirst(MENU_DISTRIBUTION_START, DIALOG_DISTRIBUTION_START);
          
          // Check whether EULA has been accepted
          // or information about new version can be presented.
          if (mDistribution.showEulaOrNewVersion()) {
              return;
          }

          currentHandler = new Handler() {
			public void handleMessage(Message msg) {
				FileManagerActivity.this.handleMessage(msg);
			}
		};

		  requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
          setContentView(R.layout.filelist);
          
          
          SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
          prefs.registerOnSharedPreferenceChangeListener(this);

          
          mEmptyText = (TextView) findViewById(R.id.empty_text);
          mProgressBar = (ProgressBar) findViewById(R.id.scan_progress);

		  getListView().setOnCreateContextMenuListener(this);
		  getListView().setEmptyView(findViewById(R.id.empty));
	      getListView().setTextFilterEnabled(true);
	      getListView().requestFocus();
	      getListView().requestFocusFromTouch();
	      
          mDirectoryButtons = (LinearLayout) findViewById(R.id.directory_buttons);
          mActionNormal = (LinearLayout) findViewById(R.id.action_normal);
          mActionMultiselect = (LinearLayout) findViewById(R.id.action_multiselect);
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
        		  mFilterFiletype = intent.getStringExtra("FILE_EXTENSION");
        		  if(mFilterFiletype == null)
        			  mFilterFiletype = "";
        		  mFilterMimetype = intent.getType();
        		  if(mFilterMimetype == null)
        			  mFilterMimetype = "";
          	  } else if (action.equals(FileManagerIntents.ACTION_PICK_DIRECTORY)) {
        		  mState = STATE_PICK_DIRECTORY;        		          		          
        		  mWritableOnly = intent.getBooleanExtra(FileManagerIntents.EXTRA_WRITEABLE_ONLY, false);
        		  
        		  // Remove edit text and make button fill whole line
        		  mEditFilename.setVisibility(View.GONE);
        		  mButtonPick.setLayoutParams(new LinearLayout.LayoutParams(
        				  LinearLayout.LayoutParams.FILL_PARENT,
        				  LinearLayout.LayoutParams.WRAP_CONTENT));
        	  } else if (action.equals(FileManagerIntents.ACTION_MULTI_SELECT)) {
	    		  mState = STATE_MULTI_SELECT;        		          		          
	    		  
	    		  // Remove buttons
                  mDirectoryButtons.setVisibility(View.GONE);
                  mActionNormal.setVisibility(View.GONE);

                  // Multi select action: move
	              mButtonMove = (Button) findViewById(R.id.button_move);
	              mButtonMove.setOnClickListener(new View.OnClickListener() {
	                    
	                    public void onClick(View arg0) {
	                        if (checkSelection()) {
	                            promptDestinationAndMoveFile();
	                        }
	                    }
	              });
	              
	              // Multi select action: copy
	              mButtonCopy = (Button) findViewById(R.id.button_copy);
	              mButtonCopy.setOnClickListener(new View.OnClickListener() {
	                    
	                    public void onClick(View arg0) {
                            if (checkSelection()) {
                                promptDestinationAndCopyFile();
                            }
	                    }
	              });
	            
	              // Multi select action: delete
	              mButtonDelete = (Button) findViewById(R.id.button_delete);
	              mButtonDelete.setOnClickListener(new View.OnClickListener() {
	                    
	                    public void onClick(View arg0) {
                            if (checkSelection()) {
                                showDialog(DIALOG_MULTI_DELETE);
                            }
	                    }
	              });

                  // Multi select action: delete
                  mButtonCompress = (Button) findViewById(R.id.button_compress_zip);
                  mButtonCompress.setOnClickListener(new View.OnClickListener() {

                      public void onClick(View arg0) {
                          if (checkSelection()) {
                              showDialog(DIALOG_MULTI_COMPRESS_ZIP);
                          }
                      }
                  });

	              // Cache the checked and unchecked icons
	              mIconChecked = getResources().getDrawable(R.drawable.ic_button_checked);
	              mIconUnchecked = getResources().getDrawable(R.drawable.ic_button_unchecked);
	              
	              mCheckIconSelect = (ImageView) findViewById(R.id.check_icon_select);
	              mCheckIconSelect.setOnClickListener(new View.OnClickListener() {
					
	            	  @Override
	            	  public void onClick(View v) {
	            		  mSelected = !mSelected;
	            		  
	            		  if(mSelected){
	            			  mCheckIconSelect.setImageDrawable(mIconChecked);
	            		  } else {
	            			  mCheckIconSelect.setImageDrawable(mIconUnchecked);
	            		  }
	            		  
	            		  toggleSelection(mSelected);
	            	  }
	              });
	            
  	    	  } 
    	  
          } 
          
          if (mState == STATE_BROWSE) {
        	  // Remove edit text and button.
        	  mEditFilename.setVisibility(View.GONE);
        	  mButtonPick.setVisibility(View.GONE);
          }

          if (mState != STATE_MULTI_SELECT) {
    		  // Remove multiselect action buttons
    		  mActionMultiselect.setVisibility(View.GONE);
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
    	  } else{
    		  if(mState == STATE_PICK_FILE || mState == STATE_PICK_DIRECTORY
    				  || action.equals(Intent.ACTION_GET_CONTENT)){
    			  String path = PreferenceActivity.getDefaultPickFilePath(this);
    			  if(path != null){
    				  File dir = new File(path);
    				  if(dir.exists() && dir.isDirectory()){
		    			  browseto = dir;
    				  }
    			  }
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
          
          getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				IconifiedTextListAdapter adapter = (IconifiedTextListAdapter) getListAdapter();
				if(adapter != null){
					switch (scrollState) {
			        case OnScrollListener.SCROLL_STATE_IDLE:
			        	adapter.toggleScrolling(false);
			        	adapter.notifyDataSetChanged();
			            break;
			        case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
			        	adapter.toggleScrolling(true);
			            break;
			        case OnScrollListener.SCROLL_STATE_FLING:
			        	adapter.toggleScrolling(true);
			            break;
			        }
				}
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// Not used
			}
		});
          
          browseTo(browseto);
     }

