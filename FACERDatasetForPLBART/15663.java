    private void selectTab(int position) {

        for (int i = 0, pos = 0; i < mContainer.getChildCount(); i ++ , pos++) {
            View tab = mContainer.getChildAt(i);
            tab.setSelected(pos == position);
        }
        
        View selectedTab = mContainer.getChildAt(position);

        final int w = selectedTab.getMeasuredWidth();
        final int l = selectedTab.getLeft();

        final int x = l - this.getWidth() / 2 + w / 2;

        smoothScrollTo(x, this.getScrollY());

    }

