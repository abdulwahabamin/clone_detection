    /**
     * 根�?�手指滚动itemView的�?离�?�判断是滚动到开始�?置还是�?�左或者�?��?�滚动
     */
    private void scrollByDistanceX() {
        // 如果�?�左滚动的�?离大于�?幕的二分之一，就让其删除
        if (itemView.getScrollX() >= screenWidth / 2) {
            scrollLeft();
        } else if (itemView.getScrollX() <= -screenWidth / 2) {
            scrollRight();
        } else {
            // 滚回到原始�?置,为了�?�下懒这里是直接调用scrollTo滚动
            itemView.scrollTo(0, 0);
        }

    }

