        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (currentTransaction == null) {
                currentTransaction = fragmentManager.beginTransaction();
            }
            // Detach the fragment, because another one is being attached
            currentTransaction.detach((Fragment)object);
        }

