    /**
     * 往�?�滑动，getScrollX()返回的是左边缘的�?离，就是以View左边缘为原点到开始滑动的�?离，所以�?��?�边滑动为负值
     */
    private void scrollRight() {
        removeDirection = RemoveDirection.RIGHT;
        final int delta = (screenWidth + itemView.getScrollX());
        // 调用startScroll方法�?�设置一些滚动的�?�数，我们在computeScroll()方法中调用scrollTo�?�滚动item
        scroller.startScroll(itemView.getScrollX(), 0, -delta, 0,
                Math.abs(delta));
        postInvalidate(); // 刷新itemView
    }

