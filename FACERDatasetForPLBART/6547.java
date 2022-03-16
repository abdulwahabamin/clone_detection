        @Override
        public int getItemViewType(int position) {
            final Item item = getItem(position);
            if (item instanceof RootItem || item instanceof AppItem) {
                return 0;
            } else {
                return 1;
            }
        }

