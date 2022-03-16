    void showOrHideEmptyMessage(int selection) {

        switch (selection) {

            case View.VISIBLE:
                root.addView(imageView);
                root.addView(emptyText);
                break;

            case View.GONE:
                root.removeView(imageView);
                root.removeView(emptyText);

        }
    }

