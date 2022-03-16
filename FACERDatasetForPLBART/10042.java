    /**
     * Method that returns an {@link Intent} from his {@link ComponentName}
     *
     * @param cn The ComponentName
     * @param request The requested intent
     * @return Intent The intent
     */
    public static final Intent getIntentFromComponentName(ComponentName cn, Intent request) {
        Intent intent = new Intent(request);
        intent.setFlags(
                intent.getFlags() &~
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.addFlags(
                Intent.FLAG_ACTIVITY_FORWARD_RESULT |
                Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        intent.setComponent(
                new ComponentName(
                        cn.getPackageName(),
                        cn.getClassName()));
        return intent;
    }

