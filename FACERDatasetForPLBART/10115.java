        /**
         * Method that sets the image drawable of a ImageView
         *
         * @param ctx The current context
         * @param view The view which apply the style
         * @param resource The string resource
         */
        public void setImageDrawable(Context ctx, ImageView view, String resource) {
            String resId = mId + "_" + resource; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "drawable", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                view.setImageDrawable(this.mResources.getDrawable(id));
                return;
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    resource, "drawable", mDefaultTheme.mPackage); //$NON-NLS-1$
            view.setImageDrawable(mDefaultTheme.mResources.getDrawable(id));
        }

