public class MedalCount {
    private String bronze;
    private String rank;
    private String count;
    private String silver;
    private String countryname;
    private String gold;
    private String countryid;

    // 构造函数、getter和setter省略，为了简洁

    @Override
    public String toString() {
        return "MedalCount{" +
                "bronze='" + bronze + '\'' +
                ", rank='" + rank + '\'' +
                ", count='" + count + '\'' +
                ", silver='" + silver + '\'' +
                ", countryname='" + countryname + '\'' +
                ", gold='" + gold + '\'' +
                ", countryid='" + countryid + '\'' +
                '}';
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRank() {
        return rank;
    }

    public String getBronze() {
        return bronze;
    }

    public void setBronze(String bronze) {
        this.bronze = bronze;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getCountryid() {
        return countryid;
    }

    public void setCountryid(String countryid) {
        this.countryid = countryid;
    }
}