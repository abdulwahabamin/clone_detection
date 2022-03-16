    /**
     * �?�左滑动，根�?�上�?�我们知�?��?�左滑动为正值
     */
    private void scrollLeft() {
        removeDirection = RemoveDirection.LEFT;
        final int delta = (screenWidth - itemView.getScrollX());
        // 调用startScroll方法�?�设置一些滚动的�?�数，我们在computeScroll()方法中调用scrollTo�?�滚动item
        scroller.startScroll(itemView.getScrollX(), 0, delta, 0,
                Math.abs(delta));
        postInvalidate(); // 刷新itemView
    }

