package xml;

/**
 * 数据库配置信息
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
public class JdbcConfig {

    private String driverName;
    private String userName;
    private String password;
    private String url;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "JdbcConfig [driverName=" + driverName + ", userName=" + userName + ", password=" + password + ", url="
                + url + "]";
    }

}
