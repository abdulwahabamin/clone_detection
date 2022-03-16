    public int getMessageViewContentAsInt() {
        switch (messageViewContent) {
        case SMALLEST:
            return 1;
        case SMALLER:
            return 2;
        default:
        case NORMAL:
            return 3;
        case LARGER:
            return 4;
        case LARGEST:
            return 5;
        }
    }

