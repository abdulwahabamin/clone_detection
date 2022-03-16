    public ShareGroup(Context context, String userName, Mode mode){
        this.mode = mode;
        shareGroupWeakReference = new WeakReference<ShareGroup>(this);

        deleteFiles();

        this.context = context;
        ShareGroup.userName = userName;

        memberList = new ArrayList<>();
        memberList.add(userName);

        handler = new EasyHandler();
        foundGroups = new ArrayList<GlidePlayerGroup>();
        currentGroup = null;
        context.startService(new Intent(context, NetworkService.class));
        networkNotification = AppNotification.getInstance(context);
        networkNotification.displayNetworkNotification(null, false);
    }

