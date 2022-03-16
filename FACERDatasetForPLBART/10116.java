        /**
         * Method that returns the resource id of a drawable in the current theme
         *
         * @param ctx The current context
         * @param resource The string resource
         * @return int The resource id
         */
        public int getResourceId(Context ctx, String resource) {
            String resId = mId + "_" + resource; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "drawable", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                return id;
            }

            // Default theme
            return mDefaultTheme.mResources.getIdentifier(
                    resource, "drawable", mDefaultTheme.mPackage); //$NON-NLS-1$
        }

