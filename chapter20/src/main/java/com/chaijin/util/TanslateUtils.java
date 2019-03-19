package com.chaijin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.chaijin.util.entity.Result;
import com.chaijin.util.tanslate.TransApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TanslateUtils {

    private static final Logger log = LoggerFactory.getLogger(TanslateUtils.class);

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20190315000277342";
    private static final String SECURITY_KEY = "4ke3o_TC2AeJnvLmmcjS";


    //将中文（中英文也可以）翻译成英文
    public static String translateZH2EN(String transStr){
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String str = api.getTransResult(transStr, "auto", "en");
        Result result = JSON.parseObject(str, new TypeReference<Result>(){});
        String en = result.getTransResult().get(0).getDst();
		//异常返回，常见原因：ip变更，此ip需要添加到开通API地址
        if(StringUtils.isEmpty(en)){
            log.error(en);
        }
        String rtn_str = en.replaceAll(" ","_").replaceAll("\\?","").toLowerCase();
        if (rtn_str.length() > 30){
            rtn_str = rtn_str.substring(0,25);
        }
        return rtn_str;
    }

}