	private static void setActionBarBackOnly(Activity activity, String title, int R_MENU_, ColorDrawable color,ActionModeBack amb ) {
		//ACT.CURRENT= R_MENU_;
        ActionBar ab = ((AppCompatActivity) activity).getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.show();

	}

