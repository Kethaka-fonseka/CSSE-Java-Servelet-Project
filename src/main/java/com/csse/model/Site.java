package com.csse.model;

public class Site {
    private String siteName;
    private String siteLocation;
    private String siteId;
    private int siteBudget;
    private int minBudget;

    public Site() {
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public int getSiteBudget() {
        return siteBudget;
    }

    public void setSiteBudget(int siteBudget) {
        this.siteBudget = siteBudget;
    }

    public int getMinBudget() {
        return minBudget;
    }

    public void setMinBudget(int minBudget) {
        this.minBudget = minBudget;
    }
}
