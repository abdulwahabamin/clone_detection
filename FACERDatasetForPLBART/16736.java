    public SearchAdapter(Context context) {
        this.context = context;
        if (context instanceof ItemClickListener) {
            itemClickListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ItemClickListener");
        }
        if (context instanceof FirePopupMenuSelectedListener) {
            popupMenuSelectedListener = (FirePopupMenuSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FirePopupMenuSelectedListener");
        }
    }

