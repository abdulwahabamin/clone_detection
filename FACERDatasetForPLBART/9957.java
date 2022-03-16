        public Loadable(Context context, ImageView view, FileSystemObject fso) {
            this.mContext = context.getApplicationContext();
            this.fso = fso;
            this.view = new WeakReference<ImageView>(view);
            this.result = null;
        }

