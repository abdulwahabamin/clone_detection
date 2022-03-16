        /**
         * @hide
         */
        void onRequestProgress() {
            Spanned mProgress = this.mCallable.requestProgress();
            publishProgress(mProgress);
        }

