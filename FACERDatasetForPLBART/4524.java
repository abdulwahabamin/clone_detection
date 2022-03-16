	public ExploreDialog(Activity activity, File usefile, BRefreshable refreshFragment, FileManagerDisk filemanager) {
		super(activity);
		this.refreshFragment=refreshFragment;
		
		this.usefile = usefile;
		
		this.activity=activity;
		fm=filemanager;

		this.setContentView(R.layout.explore_dialog);

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(this.getWindow().getAttributes());
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		this.getWindow().setAttributes(lp);
        //TextView dialogTitle = (TextView) this.findViewById(android.R.id.title);

        //dialogTitle.setText(activity.getResources().getString(R.string.file_menu_options));
        //((TextView) this.findViewById(dialogTitle)).setTypeface(B.getTypeFaceBold());
        //this.setView(title);

        //this.setIcon(R.drawable.icon);

		Button bim = (Button) this.findViewById(R.id.dialog_cancel);
		bim.setOnClickListener(onCloseClick);
		Button eim = (Button) this.findViewById(R.id.explore_dialog_open);
		eim.setOnClickListener(onOpenClick);
		Button del = (Button) this.findViewById(R.id.explore_dialog_delete);
		del.setOnClickListener(onDeleteClick);
		Button rename = (Button) this.findViewById(R.id.explore_dialog_rename);
		rename.setOnClickListener(onRenameClick);

		thisDialog=this;
		this.setOnDismissListener(onDismiss);
		
		Button copy = (Button) this.findViewById(R.id.dialog_copy);
		copy.setOnClickListener(onCopyClick);


		//context.getMenuInflater().inflate(R.menu.notes_home_popup, popupMenu.getMenu());
	}

