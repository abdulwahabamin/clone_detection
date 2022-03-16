    private int calculateItemIndex() {
        int x = getScrollBarX();
        int sum = paddingL - itemWidth / 2;
        for (int i = 0; i < ITEM_SIZE - 1; i++) {
            sum += itemWidth;
            if (x < sum)
                return i;
        }
        return ITEM_SIZE - 1;
    }

