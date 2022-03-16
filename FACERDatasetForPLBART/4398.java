	public static void setActionBarBackOnlyWithLogo(final Activity activity,int Rdrawable, String title, int R_MENU_, int Rcolor) {
		ACT.CURRENT= R_MENU_;
		final AppCompatActivity apact = (AppCompatActivity) activity;

		ActionBar actionBar = apact.getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);

        actionBar.setDisplayShowCustomEnabled(false);//.setDisplayShowTitleEnabled(true);

        actionBar.setDisplayShowTitleEnabled(true);
        //actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(title);
        actionBar.setLogo(null);
        apact.supportInvalidateOptionsMenu();
        actionBar.invalidateOptionsMenu();
		actionBar.show();

	}

