package use_case.get_other_cities;

public class GetOtherCitiesInputData {
    private final long timestamp; // 使用系统当前时间作为默认值

    // 无参数构造函数，默认使用当前时间
    public GetOtherCitiesInputData() {
        this.timestamp = System.currentTimeMillis(); // 获取当前时间的时间戳
    }

    // 允许指定时间戳的构造函数
    public GetOtherCitiesInputData(long timestamp) {
        this.timestamp = timestamp;
    }

    // 获取时间戳
    public long getTimestamp() {
        return timestamp;
    }
}
