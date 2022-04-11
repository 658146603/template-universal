package template.universal.model;

import java.util.Date;

public class TrustableKey {
    String page;
    String key;
    Date expire;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}