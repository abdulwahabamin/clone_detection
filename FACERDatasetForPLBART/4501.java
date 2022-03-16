    public ActionModeBack(Activity activity, String title,int Rmenu, ActionModeCallback callback) {
        //BLog.e("ACTION MODE CALL NEW INSTANCE !!!!!!!");
        this.activity = activity;
        this.title=title;
        this.callback=callback;
        this.useRmenu=Rmenu;
        isActionModeShowing=true;
        mMode = ((AppCompatActivity)activity).startSupportActionMode(this);
        mMode.setTitle(title);

    }

