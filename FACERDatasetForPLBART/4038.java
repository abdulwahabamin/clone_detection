    public void setMessageViewContent(int size) {
        switch (size) {
        case 1:
            messageViewContent = TextSize.SMALLEST;
            break;
        case 2:
            messageViewContent = TextSize.SMALLER;
            break;
        case 3:
            messageViewContent = TextSize.NORMAL;
            break;
        case 4:
            messageViewContent = TextSize.LARGER;
            break;
        case 5:
            messageViewContent = TextSize.LARGEST;
            break;
        }
    }

