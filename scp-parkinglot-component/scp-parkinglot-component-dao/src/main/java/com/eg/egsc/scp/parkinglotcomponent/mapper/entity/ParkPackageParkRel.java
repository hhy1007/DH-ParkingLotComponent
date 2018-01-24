package com.eg.egsc.scp.parkinglotcomponent.mapper.entity;

public class ParkPackageParkRel {
    private String packageId;

    private String parkCode;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ParkPackageParkRel other = (ParkPackageParkRel) that;
        return (this.getPackageId() == null ? other.getPackageId() == null : this.getPackageId().equals(other.getPackageId()))
            && (this.getParkCode() == null ? other.getParkCode() == null : this.getParkCode().equals(other.getParkCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPackageId() == null) ? 0 : getPackageId().hashCode());
        result = prime * result + ((getParkCode() == null) ? 0 : getParkCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", packageId=").append(packageId);
        sb.append(", parkCode=").append(parkCode);
        sb.append("]");
        return sb.toString();
    }
}