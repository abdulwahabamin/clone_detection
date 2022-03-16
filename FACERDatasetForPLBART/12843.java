        public DocumentAdapter(Context ctx, FileSystemObject document,
                DocumentAdapterReader reader) {
            super();
            mCtx = ctx;
            mDocument = document;
            mPrintPageMargin = ctx.getResources().getDimensionPixelSize(
                    R.dimen.print_page_margins);
            mReader = reader;
        }

