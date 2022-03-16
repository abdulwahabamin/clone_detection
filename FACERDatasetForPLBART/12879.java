        /**
         * Constructor of <code>SavedState</code>
         *
         * @param source The source
         */
        public SavedState(Parcel source) {
            super(source);
            this.color = source.readInt();
        }

