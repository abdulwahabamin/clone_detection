        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((this.mCategory == null) ? 0 : this.mCategory.hashCode());
            result = prime * result
                    + ((this.mDrawable == null) ? 0 : this.mDrawable.hashCode());
            result = prime * result
                    + ((this.mMimeType == null) ? 0 : this.mMimeType.hashCode());
            return result;
        }

