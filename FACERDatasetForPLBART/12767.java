        /**
         * Constructor of <code>BackgroundAsyncTask</code>
         *
         * @param ctx The current context
         * @param callable The {@link BackgroundCallable} interface
         */
        public BackgroundAsyncTask(Context ctx, BackgroundCallable callable) {
            super();
            this.mCtx = ctx;
            this.mCallable = callable;
        }

