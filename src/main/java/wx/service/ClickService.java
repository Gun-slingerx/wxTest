package wx.service;

import cn.hutool.json.JSONObject;
import wx.res.ClickRes;
import wx.util.XmlUtil;

public class ClickService extends WxBaseService{

    @Override
    public String doPost() {
        String json = this.getJson();
        JSONObject jsonObject = new JSONObject(json);
        ClickRes clickRes = new ClickRes();
        clickRes.setToUserName((String) jsonObject.get("FromUserName"));
        clickRes.setFromUserName((String) jsonObject.get("ToUserName"));
        clickRes.setCreateTime("1723517590");
        clickRes.setMsgType("text");
        clickRes.setContent("hello!!!");
        try {
            return XmlUtil.obj2Xml(clickRes,"xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ClickService(String json) {
        super.setJson(json);
    }
}
