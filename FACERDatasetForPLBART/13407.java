        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MimeTypeInfo other = (MimeTypeInfo) obj;
            if (this.mCategory != other.mCategory)
                return false;
            if (this.mDrawable == null) {
                if (other.mDrawable != null)
                    return false;
            } else if (!this.mDrawable.equals(other.mDrawable))
                return false;
            if (this.mMimeType == null) {
                if (other.mMimeType != null)
                    return false;
            } else if (!this.mMimeType.equals(other.mMimeType))
                return false;
            return true;
        }

