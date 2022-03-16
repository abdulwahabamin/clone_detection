        /**
         * Add item height at position if doesn't already exist.
         */
        public void add(int position, int height) {
            int currentHeight = mMap.get(position, -1);
            if (currentHeight != height) {
                if (currentHeight == -1 && mMap.size() == mMaxSize) {
                	// remove oldest entry
                    mMap.delete(mOrder.remove(0));
                } else {
                    // move position to newest slot
                    mOrder.remove((Integer) position);
                }
                mMap.put(position, height);
                mOrder.add(position);
            }
        }

