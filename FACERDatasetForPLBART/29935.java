    private void setDeg(int deg) {
        int index = Math.abs(Math.round(deg % 360) / 45);
        switch (index) {
            case 0:
                directionView.setText(activity().getString(R.string.top));
                setDirection(getString(R.string.north));
                break;
            case 1:
                directionView.setText(activity().getString(R.string.top_right));
                setDirection(getString(R.string.north_east));
                break;
            case 2:
                directionView.setText(activity().getString(R.string.right));
                setDirection(getString(R.string.east));
                break;
            case 3:
                directionView.setText(activity().getString(R.string.bottom_right));
                setDirection(getString(R.string.south_east));
                break;
            case 4:
                directionView.setText(activity().getString(R.string.down));
                setDirection(getString(R.string.south));
                break;
            case 5:
                directionView.setText(activity().getString(R.string.bottom_left));
                setDirection(getString(R.string.south_west));
                break;
            case 6:
                directionView.setText(activity().getString(R.string.left));
                setDirection(getString(R.string.west));
                break;
            case 7:
                directionView.setText(activity().getString(R.string.top_left));
                setDirection(getString(R.string.north_west));
                break;
        }
    }

