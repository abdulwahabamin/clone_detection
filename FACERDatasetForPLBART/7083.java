    @Override
    public void Init( Commander c ) {
        if( c != null ) {
            commander = c;
            workerHandler = new WorkerHandler();
            readerHandler = new ReaderHandler();
            if( ctx == null )
                ctx = c.getContext();
        }
        parentWidth = 0;
        nameWidth = 0;
        sizeWidth = 0;
        dateWidth = 0;
        attrWidth = 0;
        mInflater = (LayoutInflater)ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        Utils.changeLanguage( ctx );
        localeDateFormat = DateFormat.getDateFormat( ctx );
        localeTimeFormat = DateFormat.getTimeFormat( ctx );
        density = ctx.getResources().getDisplayMetrics().density;
    }

