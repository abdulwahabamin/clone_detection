	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTheme(android.R.style.Theme_Holo_Dialog);
		super.onCreate(savedInstanceState);
		setResult(RESULT_CANCELED, new Intent());
		sharedPreferences = this.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
		//Retrieve the id of the widget that called this activity.
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras!=null) {
			mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, 
		            					 AppWidgetManager.INVALID_APPWIDGET_ID);
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.select_widget_color);
		builder.setCancelable(false);
		builder.setSingleChoiceItems(R.array.widget_color_options, -1, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (which==0) {
					//Light theme.
					sharedPreferences.edit().putString("" + mAppWidgetId, "LIGHT").commit();
				} else if (which==1) {
					//Dark theme.
					sharedPreferences.edit().putString("" + mAppWidgetId, "DARK").commit();
				}
				
				updateWidgetConfig();
			}
			
		});
		
		builder.create().show();
	}

