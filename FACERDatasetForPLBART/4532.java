	public ExploreRenameDialog(Activity activity, File usefile, BRefreshable refreshFragment, FileManager filemanager) {
		super(activity);
		this.refreshFragment=refreshFragment;
		
		this.usefile = usefile;
		
		this.activity=activity;
		fm=filemanager;

		this.setContentView(R.layout.explore_rename_dialog);
        //TextView dialogTitle = (TextView) this.findViewById(android.R.id.title);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(this.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        this.getWindow().setAttributes(lp);
        //dialogTitle.setText(activity.getResources().getString(R.string.label_rename));
        //((TextView) this.findViewById(dialogTitle)).setTypeface(B.getTypeFaceBold());
        //this.setView(title);
		renameText = (EditText) this.findViewById(R.id.file_name_edit);
        renameText.setText(Files.getFilenameLessExtension(usefile.getName()));
        renameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (renameText.getText().toString().matches("[^-_.A-Za-z0-9]")) {
                    BLog.e("disable");
                    bim.setEnabled(false);
                    bim.setAlpha(0.5f);
                } else {
                    BLog.e("enable");
                    bim.setEnabled(true);
                    bim.setAlpha(1f);
                }
            }
        });
        Device.setKeyboard(activity, renameText, true);

        //this.setIcon(R.drawable.icon);

		bim = (Button) this.findViewById(R.id.file_explore_rename_now);
		bim.setOnClickListener(onRenameClick);
        bim.setEnabled(false);
        bim.setAlpha(0.5f);
        TextView txt = (TextView) this.findViewById(R.id.file_name_ext);
        txt.setText(Files.getExtension(usefile.getName()));

        Button close = (Button) this.findViewById(R.id.dialog_cancel);
        close.setOnClickListener(onCloseClick);

		thisDialog=this;
		this.setOnDismissListener(onDismiss);
		


		//context.getMenuInflater().inflate(R.menu.notes_home_popup, popupMenu.getMenu());
	}

