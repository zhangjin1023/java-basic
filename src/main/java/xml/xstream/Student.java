package xml.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * xml解析位student实体
 *
 * @author zhang_jin[zhang_jin@suixingpay.com]
 */
@XStreamAlias("student")
public class Student {
    @XStreamAsAttribute
    private String version;
    private String name;
    @XStreamAlias("student_age")
    private String age;
    // @XStreamOmitField
    private String sex;
    @XStreamImplicit(itemFieldName = "mobile")
    private List<String> mobiles;

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Student [version=" + version + ", name=" + name + ", age=" + age + ", sex=" + sex + ", mobiles="
                + mobiles + "]";
    }

}
