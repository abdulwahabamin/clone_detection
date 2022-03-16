        @Override
        protected Long doInBackground(Integer[]... params) {
            synchronized (this) {
                startAlarms();
            }
            return 0l;
        }

