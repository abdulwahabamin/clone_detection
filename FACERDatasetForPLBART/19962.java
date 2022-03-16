        /**
         * Add item height at position if doesn't already exist.
         */
        public void add(int position, int height) {
            int currHeight = mMap.get(position, -1);
            if (currHeight != height) {
                if (currHeight == -1) {
                    if (mMap.size() == mMaxSize) {
                        // remove oldest entry
                        mMap.delete(mOrder.remove(0));
                    }
                } else {
                    // move position to newest slot
                    mOrder.remove((Integer) position);
                }
                mMap.put(position, height);
                mOrder.add(position);
            }
        }

