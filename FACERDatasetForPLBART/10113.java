        /**
         * Method that sets the titlebar drawable of an ActionBar
         *
         * @param ctx The current context
         * @param actionBar The action bar
         * @param resource The string resource
         */
        public void setTitlebarDrawable(Context ctx, ActionBar actionBar, String resource) {
            String resId = this.mId + "_" + resource; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "drawable", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                actionBar.setBackgroundDrawable(this.mResources.getDrawable(id));
                return;
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    resource, "drawable", mDefaultTheme.mPackage); //$NON-NLS-1$
            actionBar.setBackgroundDrawable(mDefaultTheme.mResources.getDrawable(id));
        }

