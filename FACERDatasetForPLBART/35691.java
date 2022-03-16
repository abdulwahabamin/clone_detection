    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================\n");
        sb.append(":::请求失败，状�?如下\n");
        sb.append(":::状�?�?：").append(resultCode).append("\n");
        sb.append(":::失败信�?�：").append(failureMessage).append("\n");
        sb.append("======================\n");
        return sb.toString();
    }

