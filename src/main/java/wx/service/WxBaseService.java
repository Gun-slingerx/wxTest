package wx.service;

public abstract class WxBaseService {

    private String json;

    public abstract String doPost();

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
