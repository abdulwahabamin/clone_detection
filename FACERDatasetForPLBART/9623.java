    /**
     * Method that converts every permission into octal numbers,
     * conforming with the unix style (xe: 0755).
     *
     * @return String The octal numbers string for the permissions
     */
    @SuppressWarnings("boxing")
    public String toOctalString() {
        //SetUID/SetGID/Sticky Bit
        int b = 0;
        if (this.mUser.isSetUID()) {
            b = b | 0x04;
        }
        if (this.mGroup.isSetGID()) {
            b = b | 0x02;
        }
        if (this.mOthers.isStickybit()) {
            b = b | 0x01;
        }
        //User
        int u = 0;
        if (this.mUser.isRead()) {
            u = u | 0x04;
        }
        if (this.mUser.isWrite()) {
            u = u | 0x02;
        }
        if (this.mUser.isExecute()) {
            u = u | 0x01;
        }
        //Group
        int g = 0;
        if (this.mGroup.isRead()) {
            g = g | 0x04;
        }
        if (this.mGroup.isWrite()) {
            g = g | 0x02;
        }
        if (this.mGroup.isExecute()) {
            g = g | 0x01;
        }
        //Others
        int o = 0;
        if (this.mOthers.isRead()) {
            o = o | 0x04;
        }
        if (this.mOthers.isWrite()) {
            o = o | 0x02;
        }
        if (this.mOthers.isExecute()) {
            o = o | 0x01;
        }

        //Return octal string
        return String.format("%d%d%d%d", b, u, g, o); //$NON-NLS-1$
    }

