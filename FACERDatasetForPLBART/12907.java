        /**
         * Method that sets the background color of a View
         *
         * @param ctx The current context
         * @param view The view which apply the style
         * @param resource The string resource
         */
        public void setBackgroundColor(Context ctx, View view, String resource) {
            String resId = mId + "_" + resource; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "color", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                view.setBackgroundColor(this.mResources.getColor(id));
                return;
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    resource, "color", mDefaultTheme.mPackage); //$NON-NLS-1$
            view.setBackgroundColor(mDefaultTheme.mResources.getColor(id));
        }

