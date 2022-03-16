    public FilesAdapter(Context context,List<FileDirectory> fileDirectories, FileEx fileEx, OnItemSelectedListener onItemSelectedListener){
        this.fileDirectories=fileDirectories;
        this.fileEx = fileEx;
        this.onItemSelectedListener=onItemSelectedListener;
        onDirectoryChangeListener=new OnDirectoryChangeListener() {
            @Override
            public void onDirectoryChange(List<?> newList) {
                setFileDirectories((List<FileDirectory>)newList);
            }
        };
        this.context=context;
        Arrays.sort(IMG_TYPES);
        selectedColor=this.context.getString(com.singh.multimeet.quicxplo.R.string.selectedColor);
        createScrollList();
        calendar=Calendar.getInstance();
    }

