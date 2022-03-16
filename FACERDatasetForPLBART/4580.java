    public FileImagesAdapter(Activity c, GridView parent, FileManager fileManager) {
        this.activity = c;
        this.parent=parent;
        fm= fileManager;//fm.init(activity);
        param = new LayoutParams(LayoutParams.MATCH_PARENT,300);
        txtparams = new LayoutParams(LayoutParams.MATCH_PARENT,40);
        txtppod = new LayoutParams(LayoutParams.MATCH_PARENT,300);
        animation1 = AnimationUtils.loadAnimation(activity, R.anim.to_middle);
        animation2 = AnimationUtils.loadAnimation(activity, R.anim.from_middle);

        laycheck = new RelativeLayout.LayoutParams(65,60);
        laycheck.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        laycheck.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        //isActionModeShowing = false;
        //txtparams.
        //cache = new HashMap<String,Bitmap>();
    }

