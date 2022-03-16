        /**
         * {@inheritDoc}
         */
        @Override
        public void accept() {
            // Remove the flinger effect
            this.mItemView.setTranslationX(0);
            clearVars();
        }

