        /**
         * Only update roots belonging to given package name. Other roots will
         * be copied from cached {@link #mRoots} values.
         */
        public UpdateTask(String filterPackage) {
            mFilterPackage = filterPackage;
        }

