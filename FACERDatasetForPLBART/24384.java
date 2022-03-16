        @Override
        public void finishUpdate(ViewGroup container) {
            if (currentTransaction != null) {
                currentTransaction.commit();
                currentTransaction = null;
            }
        }

