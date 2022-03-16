    public SearchShortcutAdapter(Activity a, ListView parent) {
        this.parent=parent;
        activity = a;
        this.files=files;
        //this.data=data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

