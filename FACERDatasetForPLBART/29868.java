    @Override
    public int getItemViewType(int position) {
        switch (aboutCards.get(position).type) {
            case 0:
                return AboutModel.ABOUT_1;
            case 1:
                return AboutModel.ABOUT_2;
            case 2:
                return AboutModel.ABOUT_3;
            case 3:
                return AboutModel.ABOUT_4;
            case 4:
                return AboutModel.ABOUT_5;
            default:
                return -1;
        }
    }

