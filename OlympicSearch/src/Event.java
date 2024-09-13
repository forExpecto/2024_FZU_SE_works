public class Event {
    private String startdate;
    private String itemcodename;
    private String homename;
    private String awayname;
    private String venuename;
    private String title;

    // 构造函数
    public Event(String startdate, String itemcodename, String homename, String awayname, String venuename, String title) {
        this.startdate = startdate;
        this.itemcodename = itemcodename;
        this.homename = homename;
        this.awayname = awayname;
        this.venuename = venuename;
        this.title = title;
    }

    // Getter 和 Setter 方法
    public String getStartdate() { return startdate; }
    public void setStartdate(String startdate) { this.startdate = startdate; }

    public String getItemcodename() { return itemcodename; }
    public void setItemcodename(String itemcodename) { this.itemcodename = itemcodename; }

    public String getHomename() { return homename; }
    public void setHomename(String homename) { this.homename = homename; }

    public String getAwayname() { return awayname; }
    public void setAwayname(String awayname) { this.awayname = awayname; }

    public String getVenuename() { return venuename; }
    public void setVenuename(String venuename) { this.venuename = venuename; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return "Event{" +
                "startdate='" + startdate + '\'' +
                ", itemcodename='" + itemcodename + '\'' +
                ", homename='" + homename + '\'' +
                ", awayname='" + awayname + '\'' +
                ", venuename='" + venuename + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
